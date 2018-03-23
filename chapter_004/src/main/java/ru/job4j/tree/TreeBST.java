package ru.job4j.tree;


import java.util.*;

/**
 * @author Ayup Bariev.
 * @since 23.03.2018.
 */
public class TreeBST<E extends Comparable<E>>  implements Iterable<E> {

    private NodeBST<E> root;
    private int modCount = 0;

    public TreeBST(E value) {
        this.root = new NodeBST<E>(value);
    }


    public void add(E value) {
        root.addNode(value);
        modCount++;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private final Queue<NodeBST<E>> data = new LinkedList<>();
            private int expectedModCount = modCount;

            {
                data.offer(root);
            }

            @Override
            public boolean hasNext() {
                checkModification();
                return !data.isEmpty();
            }

            @Override
            public E next() {
                checkModification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result;
                NodeBST<E> node = data.poll();
                result = node.value;
                if (node.left != null) {
                    data.offer(node.left);
                }
                if (node.right != null) {
                    data.offer(node.right);
                }

                return result;
            }

            private void checkModification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };


    }
}
