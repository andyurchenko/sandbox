package src.main.it.sevenbits.DoubleEndedQueue;

import src.main.it.sevenbits.matrix.Matrix;

public class Node {
    Node next;
    Node prev;
    Matrix matrix;

    public Node(Matrix matrix) {
        this.next = null;
        this.prev = null;
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        return matrix.toString();
    }
}
