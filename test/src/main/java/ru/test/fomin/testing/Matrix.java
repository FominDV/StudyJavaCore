package ru.test.fomin.testing;

import java.util.Scanner;
import java.util.Random;

public class Matrix {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrixStart = createSquareMatrix();
        printMatrix(matrixStart);
        System.out.println("Determine of matrix = " + determine(matrixStart));
    }

    static int[][] createSquareMatrix() {
        int order = inputInteger();
        int[][] matrixSquare = new int[order][order];
        Random random = new Random();
        for (int i = 0; i < matrixSquare.length; i++) {
            for (int j = 0; j < matrixSquare.length; j++) {
                matrixSquare[i][j] = random.nextInt(10);
            }
        }
        return matrixSquare;
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int value : matrix[i]) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    static int determine(int[][] matrix) {
        int det = 0;
        switch (matrix.length) {
            case 1:
                return matrix[0][0];
            case 2: {
                return (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);
            }
            default: {
                for (int i = 0; i < matrix.length; i++) {
                    det += Math.pow(-1.0, i) * determine(getMinor(matrix, i)) * matrix[0][i];
                }
                return det;
            }
        }
    }


    static int[][] getMinor(int[][] matrix, int i) {
        int[][] minor = new int[matrix.length - 1][matrix.length - 1];
        for (int j = 0, j1 = 0; j < matrix.length; j++, j1++) {
            if (j == i) {
                j1--;
                continue;
            }
            for (int k = 0; k < minor.length; k++) {
                minor[k][j1] = matrix[k + 1][j];
            }
        }
        return minor;
    }

    static int inputInteger() {
        while (true) {
            int value;
            System.out.println("Input the order of square matrix:");
            if (read.hasNextInt()) {
                value = read.nextInt();
                if (value>0){
                    return value;
                }else{
                    System.out.println("Order of square matrix must be greater zero!");
                }
            } else {
                read.nextLine();
                System.out.println("It isn't integer number!");
            }
        }
    }
}
