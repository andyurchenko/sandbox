package src.main.it.sevenbits.matrix;

import java.util.Random;

public class Matrix {
    public final int MAX_RANDOM_VALUE_FOR_CELL;
    private Cell[][] matrix;

    public Matrix(int rowsCount, int columnsCount, int maxCellsValue) {
        this.matrix = new Cell[rowsCount][columnsCount];
        this.MAX_RANDOM_VALUE_FOR_CELL = maxCellsValue;
        fillMatrixWithRandomValues();
    }

    private void fillMatrixWithRandomValues() {
        Random rand = new Random();
        for(int row = 0; row < matrix.length; row++) {
            for(int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = new Cell(row, column, rand.nextInt(MAX_RANDOM_VALUE_FOR_CELL));
            }
        }
    }

    public void inverseMatrixValue() {
        for(int row = 0; row < matrix.length; row++) {
            for(int column = 0; column < matrix[row].length; column++) {
                matrix[row][column].inverseValue();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < matrix.length; row++) {
            for(int column = 0; column < matrix[row].length; column++) {
                sb.append(this.matrix[row][column].getValue()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
