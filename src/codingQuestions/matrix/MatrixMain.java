package codingQuestions.matrix;

/**
 * Created by dravi on 3/30/2018.
 */
public class MatrixMain {
    public static void main(String[] args) {
        MatrixPuzzles matrixPuzzles = new MatrixPuzzles();

        int[][] inputMatrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {14, 17, 18, 19, 20}
        };
        System.out.println("Length of Matrix : " + inputMatrix.length);
        matrixPuzzles.searchElement(inputMatrix, 4, 5, 14);
        matrixPuzzles.searchSecondMatchElement(inputMatrix, 4, 5, 14);
        int[][] booleanMatrix = {
                {1, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };
        matrixPuzzles.changeBooleanMatrix(booleanMatrix, 5, 4);
        matrixPuzzles.printMatrixInSpiralForm(inputMatrix, 4, 5);
        System.out.println();
        System.out.println(matrixPuzzles.kthSmallest(inputMatrix, 5));
        ;
    }
}
