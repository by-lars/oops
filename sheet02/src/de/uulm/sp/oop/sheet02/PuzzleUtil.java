package de.uulm.sp.oop.sheet02;

import javax.imageio.ImageTranscoder;

import static java.lang.Math.min;

public class PuzzleUtil {
    public static void main(String[] args) {
        int[] arr1 = new int[]{25, 42, 69, 17};

        System.out.println("arr1: ");
        view(arr1);

        System.out.println("\narr1 shiftRight: ");
        shiftRight(arr1);
        view(arr1);

        System.out.println("\narr1 shiftLeft: ");
        shiftLeft(arr1);
        view(arr1);

        System.out.println("\narr1 shiftLeft: ");
        shiftLeft(arr1);
        view(arr1);

        System.out.println("\narr1 shiftRight: ");
        shiftRight(arr1);
        view(arr1);

        int[][] arr2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("\narr2t: ");
        view(arr2);

        System.out.println("\narr2 shiftRowsRight(1,3): ");
        shiftRows(arr2, 1, 3, false);
        view(arr2);

        System.out.println("\narr2 shiftRowsLeft(1,3): ");
        shiftRows(arr2, 1, 3, true);
        view(arr2);

        System.out.println("\narr2 shiftCols(1,3) down: ");
        shiftCols(arr2, 1, 3, true);
        view(arr2);

        System.out.println("\narr2 shiftCols(1,3) up: ");
        shiftCols(arr2, 1, 3, false);
        view(arr2);

        System.out.println("\narr2 extractSubarray(2,4,2,4): ");
        view(extractSubarray(arr2, 2, 4, 2, 4));

        System.out.println("\narr2 extractSubarray(1,3,1,2): ");
        view(extractSubarray(arr2, 1, 3, 1, 2));


        arr2 = new int[][]{{0, 12, 0}, {9, 69, 3}, {0, 6, 0}};
        System.out.println("\narr2 rotateClockwise: ");
        rotateClockwise(arr2);
        view(arr2);

        arr2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("\narr2 replaceInArray with zeros: ");
        replaceInArray(arr2, new int[][]{{0, 0}, {0, 0}}, 1, 1);
        view(arr2);

        arr2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("\narr2 partialRotateClockwise(0,2,0,2): ");
        partialRotateClockwise(arr2, 0, 2, 0, 2);
        view(arr2);
    }

    //a)
    public static void shiftRight(int[] array) {
        int end = array[array.length - 1];
        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = end;
    }

    //b)
    public static void shiftLeft(int[] array) {
        int start = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = start;
    }

    //c)
    public static void shiftRows(int[][] array, int rowStart, int rowEnd, boolean shiftLeft) {
        for(int i = rowStart; i < rowEnd; i++) {
            if (shiftLeft) {
                shiftLeft(array[i]);
            } else {
                shiftRight(array[i]);
            }
        }
    }

    //d)
    public static void shiftCols(int[][] array, int colStart, int colEnd, boolean shiftDown) {
        int n = array[0].length-1;

        for(int i = colStart; i < colEnd; i++) {
            if(shiftDown) {
                int end = array[n][i];

                for(int j = n; j > 0; j--) {
                    array[j][i] = array[j-1][i];
                }

                array[0][i] = end;
            } else {
                int start = array[0][i];

                for(int j = 0; j < n; j++) {
                    array[j][i] = array[j+1][i];
                }

                array[n][i] = start;
            }


        }
    }

    //e)
    public static int[][] extractSubarray(int[][] array, int rowStart, int rowEnd, int colStart, int colEnd) {
        rowEnd = Math.min(array[0].length, rowEnd);
        colEnd = Math.min(array.length, colEnd);

        int[][] result = new int[rowEnd - rowStart][colEnd - colStart];

        for(int i = rowStart; i < rowEnd; i++) {
            System.arraycopy(array[i], colStart, result[i-rowStart], 0, colEnd - colStart);
        }

        return result;
    }

    //f)
    public static void replaceInArray(int[][] array, int[][] delta, int rowIndex, int colIndex) {
        for(int i = 0; i < delta.length; i++) {
            for(int j = 0; j < delta[0].length; j++) {
                array[i + rowIndex][j + colIndex] = delta[i][j];
            }
        }
    }

    //g)
    public static void rotateClockwise(int[][] array) {
        int n = array.length;


        // 1. Transpose Matrix
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }

        // 2. Reverse rows
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n / 2; j++) {
                int temp = array[i][j];
                array[i][j] = array[i][n-j-1];
                array[i][n-j-1] = temp;
            }
        }

    }

    //h)
    public static void partialRotateClockwise(int[][] array, int rowStart, int rowEnd, int colStart, int colEnd) {
        int[][] subarray = extractSubarray(array, rowStart, rowEnd, colStart, colEnd);

        rotateClockwise(subarray);

        for(int i = 0; i < subarray.length; i++) {
            for(int j = 0; j < subarray[0].length; j++) {
                array[i+rowStart][j+colStart] = subarray[i][j];
            }
        }
    }


    //vvvvv Blackbox vvvvv
    public static void view(int[] array) {

        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    private static void view(int[][] array) {

        System.out.println("2d-Array:");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
