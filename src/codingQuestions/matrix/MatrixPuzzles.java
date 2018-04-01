package codingQuestions.matrix;

/**
 * Created by dravi on 3/30/2018.
 * This is a n x m sorted matrix.
 * Sorted means all rows are sorted in ascending order
 * And all columns are sorted in ascending order.
 * 1   2    3    4    5
 * 6   7    8    9    10
 * 11  12   13   14   15
 * 14  17   18   19   20
 */
public class MatrixPuzzles {

    /**
     * This is to find element in a n x m sorted matrix.
     * Steps :
     * 1 : Choose top right element (e) e = 5
     * 2 : if elementToFind == e : return index
     * 3 : if elementToFind < e : Shift e to left i.e e = 4
     * 4 : if elementToFind > e : shift e to down i.e e = 15
     * 5 : repeat 2, 3 & 4th step
     *
     * @param matrix        Which is to be searched
     * @param matrixRows    No of rows in matrix
     * @param matrixColumns No of columns in matrix
     * @param elementToFind Element to Search
     */
    public void searchElement(int[][] matrix, int matrixRows, int matrixColumns, int elementToFind) {
        int i = 0, j = matrixColumns - 1; //This will fetch top right element
        /**
         * Looping till i is less than total no of rows, as i started from first row
         * j is less than or equals first column, as j started from last column
         */
        while (i < matrixRows && j >= 0) {
            if (matrix[i][j] == elementToFind) {
                System.out.println("Element is present at Row : " + i + " and Column :" + j);
                return;
            } else if (matrix[i][j] > elementToFind) {
                j--;
            } else if (matrix[i][j] < elementToFind) {
                i++;
            }
        }
        System.out.println("Element not Found !!");
    }

    /**
     * Find second index of element.
     * Logic is same as searchElement Function, just return when matchCount == 2;
     *
     * @param matrix        Which is to be searched
     * @param matrixRows    No of rows in matrix
     * @param matrixColumns No of columns in matrix
     * @param elementToFind Element to Search
     */
    public void searchSecondMatchElement(int[][] matrix, int matrixRows, int matrixColumns, int elementToFind) {
        int i = 0, j = matrixColumns - 1; //This will fetch top right element
        int matchCount = 0;
        /**
         * Looping till i is less than total no of rows, as i started from first row
         * j is less than or equals first column, as j started from last column
         */
        while (i < matrixRows && j >= 0) {
            if (matrix[i][j] == elementToFind) {
                matchCount++;
                if (matchCount == 2) {
                    System.out.println("Second time Element is present at Row : " + i + " and Column :" + j);
                    return;
                } else {
                    i++;
                }

            } else if (matrix[i][j] > elementToFind) {
                j--;
            } else if (matrix[i][j] < elementToFind) {
                i++;
            }
        }
        System.out.println("Element not Found !!");
    }

    /**
     * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true)
     * then make all the cells of ith row and jth column as 1
     * E.g The Matrix
     * 1 0 0 1
     * 0 0 1 0
     * 0 0 0 0
     * should be changed to following
     * 1 1 1 1
     * 1 1 1 1
     * 1 0 1 1
     * Steps :
     * 1. Take an array of size equal to number of rows - tempRow
     * 2. Take another array of size equal to number of columns - tempColumn
     * 3. Mark all positions as 0 in both arrays
     * 4. Iterate over input matrix and check if a position i.e matrix[i][j] == 1;
     * 5. If true, mark tempRow[i] = 1 & tempColumn[j] = 1
     * 6. Modify input matrix for the values of tempRow[i] == 1 or tempColumn[j] == 1
     *
     * @param matrix        input boolean matrix that is to be changed
     * @param matrixRows    No of rows in a Matrix
     * @param matrixColumns No of columns in a Matrix
     */
    public void changeBooleanMatrix(int[][] matrix, int matrixRows, int matrixColumns) {
        int[] tempRow = new int[matrixRows];
        int[] tempColumns = new int[matrixColumns];
        for (int i = 0; i < matrixRows; i++) {
            tempRow[i] = 0;
        }
        for (int i = 0; i < matrixColumns; i++) {
            tempColumns[i] = 0;
        }
        //Changing tempRow and tempColumn Array
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                if (matrix[i][j] == 1) {
                    tempRow[i] = 1;
                    tempColumns[j] = 1;
                }
            }
        }
        //Modifying input matrix
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                if (tempRow[i] == 1 || tempColumns[j] == 1) {
                    matrix[i][j] = 1;
                }
            }
        }
        printMatrix(matrix, matrixRows, matrixColumns);
    }

    /**
     * Print a given matrix in spiral form
     * E.g For this Matrix :
     * 1   2    3    4    5
     * 6   7    8    9    10
     * 11  12   13   14   15
     * 14  17   18   19   20
     * Spiral form will be :
     * 1,2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 14, 11, 6, 7, 8, 9, 14, 13, 12
     */
    public void printMatrixInSpiralForm(int[][] matrix, int matrixRows, int matrixColumns) {
        int rowStartingIndex = 0;
        int columnStartingIndex = 0;
        int iterator = 0;
        while (rowStartingIndex < matrixRows && columnStartingIndex < matrixColumns) {
            //Print first row from the remaining rows
            for (iterator = columnStartingIndex; iterator < matrixColumns; iterator++) {
                System.out.print(matrix[rowStartingIndex][iterator] + ", ");
            }
            rowStartingIndex++;
            //Print the last column from remaining columns
            for (iterator = rowStartingIndex; iterator < matrixRows; iterator++) {
                System.out.print(matrix[iterator][matrixColumns - 1] + ", ");
            }
            matrixColumns--;
            //Print last row from remaining rows
            if (rowStartingIndex < matrixRows) {
                for (iterator = matrixColumns - 1; iterator >= columnStartingIndex; iterator--) {
                    System.out.print(matrix[matrixRows - 1][iterator] + ", ");
                }
                matrixRows--;
            }
            //Print first column from remaining columns
            if (columnStartingIndex < matrixColumns) {
                for (iterator = matrixRows - 1; iterator >= rowStartingIndex; iterator--) {
                    System.out.print(matrix[iterator][columnStartingIndex] + ", ");
                }
                columnStartingIndex++;
            }
        }
    }

    /**
     * Rotate a <b>square</b> matrix by 90 degree without using any extra space
     * Steps :
     * 1. Find transpose of matrix.
     * 2. Reverse rows of the transpose.
     *
     * @param matrix
     */
    public void rotateMatrix90(int[][] matrix, int matrixRows, int matrixColumns) {
        transpose(matrix, matrixRows, matrixColumns);
        reverseColumns(matrix, matrixRows, matrixColumns);

    }

    /**
     * For input
     * 1,   2,  3,  4
     * 6,   7,  8,  9
     * 11, 12, 13, 14
     * 14, 17, 18, 19
     * output will be :
     * 1,   6,   11,   14
     * 2,   7,   12,   17
     * 3,   8,   13,   18
     * 4,   9,   14,   19
     *
     * @param matrix        Input matrix
     * @param matrixRows    No of rows in Matrix
     * @param matrixColumns No of columns in Matrix
     */
    public void transpose(int[][] matrix, int matrixRows, int matrixColumns) {
        for (int i = 0; i < matrixRows; i++) {
            for (int j = i; j < matrixColumns; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // printMatrix(matrix, matrixRows, matrixColumns);
    }

    /**
     * For input
     * 1,   6,   11,   14
     * 2,   7,   12,   17
     * 3,   8,   13,   18
     * 4,   9,   14,   19
     * output will be
     * 4,   9,   14,   19
     * 3,   8,   13,   18
     * 2,   7,   12,   17
     * 1,   6,   11,   14
     *
     * @param matrix
     * @param matrixRows
     * @param matrixColumns
     */
    public void reverseColumns(int[][] matrix, int matrixRows, int matrixColumns) {
        for (int i = 0; i < matrixRows / 2; i++) {
            int[] temp = matrix[matrixRows - i - 1];
            matrix[matrixRows - i - 1] = matrix[i];
            matrix[i] = temp;
        }
        printMatrix(matrix, matrixRows, matrixColumns);
    }

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;

        int lower = matrix[0][0];
        int upper = matrix[m - 1][m - 1];

        while (lower < upper) {
            int mid = lower + ((upper - lower) >> 1);
            int count = count(matrix, mid);
            if (count < k) {
                lower = mid + 1;
            } else {
                upper = mid;
            }
        }

        return upper;
    }

    private int count(int[][] matrix, int target) {
        int m = matrix.length;
        int i = m - 1;
        int j = 0;
        int count = 0;

        while (i >= 0 && j < m) {
            if (matrix[i][j] <= target) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return count;
    }

    public void printMatrix(int[][] matrix, int matrixRows, int matrixColumns) {
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
