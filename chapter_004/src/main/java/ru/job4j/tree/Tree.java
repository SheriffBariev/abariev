package ru.job4j.tree;

import java.util.*;

/**
 * Tree.
 * @author Ayup Bariev.
 * @since 12.03.2018.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Parent node.
     */
    private Node<E> root;

    /**
     * Constructor.
     * @param value
     */
    public Tree(E value) {
        root = new Node(value);
    }

    /**
     * Add.
     * @param parent parent.
     * @param child child.
     * @return boolean.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> check = findBy(parent);
        if (check.isPresent()) {
            Node<E> parentValue = check.get();
            boolean duplicate = false;
            if (findBy(child).isPresent()) {
                duplicate = true;
            }
            if (!duplicate) {
                parentValue.add(new Node<E>(child));
                result = true;
            }
        }
        return result;
    }

    /**
     * Encapsulation method.
     * @param node node.
     * @return boolean.
     */
    private boolean isBinary(Node<E> node) {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(node);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                return false;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return true;
    }

    /**
     * Method.
     * @return boolean.
     */
    public boolean isBinary() {
        return isBinary(this.root);
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Queue<Node<E>> elements = new LinkedList<>(Arrays.asList(root));

            @Override
            public boolean hasNext() {
                return !elements.isEmpty();
            }

            @Override
            public E next() {
                Node<E> res = this.elements.poll();
                elements.addAll(res.leaves());
                return res.getValue();
            }
        };
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        System.out.println(tree.findBy(4).get().getValue());

    }
}
