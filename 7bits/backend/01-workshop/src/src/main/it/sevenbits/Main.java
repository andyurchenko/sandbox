package src.main.it.sevenbits;

import src.main.it.sevenbits.DoubleEndedQueue.DoubleEndedQueue;
import src.main.it.sevenbits.DoubleEndedQueue.Node;
import src.main.it.sevenbits.matrix.Matrix;

public class Main {

    public static void main(String[] args) {

        Matrix matrix = new Matrix(parseForIntWithDefaultValue(args[0]), parseForIntWithDefaultValue(args[1]), parseForIntWithDefaultValue(args[2]));
        System.out.println(matrix);
        matrix.inverseMatrixValue();
        System.out.println(matrix);

        Matrix matrix1 = new Matrix(1, 1, 10);
        Matrix matrix2 = new Matrix(2, 2, 100);
        Matrix matrix3 = new Matrix(3, 3, 1000);
        Matrix matrix4 = new Matrix(4, 4, 10000);

        DoubleEndedQueue queue = new DoubleEndedQueue();
        queue.addFirst(new Node(matrix2));
        queue.addFirst(new Node(matrix1));
        queue.addLast(new Node(matrix3));
        queue.addLast(new Node(matrix4));
        System.out.println(queue);
    }

    public static int parseForIntWithDefaultValue(String str) {
        if(Integer.decode(str) < 1) {
            return 3;
        } else {
            return Integer.decode(str);
        }
    }
}
