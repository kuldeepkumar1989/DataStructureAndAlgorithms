package com.kuldeep.problems.array;

public class RotateMatrixClockWise {

    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        rotateInplace(arr);

    }

    /**
     * 13 9 5 1
     * 14 10 6 2
     * 15 11 7 3
     * 16 12 8 4
     *
     *
     * 00 01 02 03
     * 10 11 12 13
     * 20 21 22 23
     * 30 31 32 33
     *
     *
     *
     * @param matrix
     */

    private static void rotateInplace(int[][] matrix) {
        int size = matrix.length;
        int layer = size/2;
        for(int i=0; i<layer; i++){
            for(int j=i; j<size-i-1; j++){
                int tmp = matrix[i][j];

                matrix[i][j] = matrix[size-j-1][i];
                matrix[size-1-j][i] = matrix[size-1-i][size-1-j];
                matrix[size-1-i][size-1-j] = matrix[j][size-1-i];
                matrix[j][size-1-i] = tmp;
            }
        }

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
