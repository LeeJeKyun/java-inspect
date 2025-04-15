package programmers.matrixmultiplication;

public class MatrixMultiplication {
    //행렬의 곱셈
}


class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int a = arr1.length;
        int b = arr2[0].length;
        int c = arr1[0].length;

        int[][] result = new int[a][b];

        for(int i=0; i<a; i++) {
            for(int j=0; j<b; j++) {
                for(int k=0; k<c; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;

    }
}