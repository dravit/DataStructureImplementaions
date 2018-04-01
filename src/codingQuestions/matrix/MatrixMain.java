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

        int[][] squareMatrixOf4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] squareMatrixOf5 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}

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
        System.out.println("Print matrix in Spiral Form");
        matrixPuzzles.printMatrixInSpiralForm(inputMatrix, 4, 5);
        System.out.println("Kth smallest element in Matrix");
        System.out.println(matrixPuzzles.kthSmallest(inputMatrix, 5));
        System.out.println("Rotate 4 x 4 matrix by 90 degree :");
        matrixPuzzles.rotateMatrix90(squareMatrixOf4, squareMatrixOf4.length, squareMatrixOf4[0].length);
        System.out.println("Rotate 5 x 5 matrix by 90 degree :");
        matrixPuzzles.rotateMatrix90(squareMatrixOf5, squareMatrixOf5.length, squareMatrixOf5[0].length);
    }
}
