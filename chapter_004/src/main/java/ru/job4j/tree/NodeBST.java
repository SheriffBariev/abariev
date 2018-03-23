package ru.job4j.tree;

/**
 * @author Bariev Ayup.
 */
public class NodeBST<E extends Comparable<E>> {
    NodeBST<E> right;
    NodeBST<E> left;
    E value;

    public NodeBST(E value) {
        this.value = value;
    }

    public void addNode(E value) {
        if (value.compareTo(this.value) <= 0) {
            if (left != null) {
                left.addNode(value);
            } else {
                left = new NodeBST<>(value);
            }
        } else {
            if (right != null) {
                right.addNode(value);
            } else {
                right = new NodeBST<>(value);
            }
        }
    }
}
