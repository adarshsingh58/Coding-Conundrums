package com.questions.scenarioBasedQues;

public class Temp {


    public static void main(String[] args) {
//        int[][] x = {{5, 1, 9, 11}, {2, 4, 8, 10}, {2, 4, 8, 10}, {2, 4, 8, 10}};
//        Temp.rotate90(x);
    }

    public static void rotate90(int[][] x) {
        for (int k = 0; k < x.length; k++) {
            for (int l = 0; l < x.length; l++) {
                System.out.print(" " + x[k][l]);
            }
            System.out.println();
        }
        System.out.println();

        int n = x.length;
        int[][] x1 = new int[x.length][x.length];
        int io = 0, jo = 0;
        int i = 0, j = 0;
        while (n > 1) {

            for (i = io, j = jo; i < n; i++) {
                addCurrValueInNewIndex(x, n, x1, i, j, io, jo);
            }
            for (i = io, j = n - 1; i < n; i++) {
                addCurrValueInNewIndex(x, n, x1, i, j, io, jo);
            }
            for (i = io, j = jo; j < n; j++) {
                addCurrValueInNewIndex(x, n, x1, i, j, io, jo);
            }
            for (i = n - 1, j = jo; j < n; j++) {
                addCurrValueInNewIndex(x, n, x1, i, j, io, jo);
            }

            ++io;
            ++jo;
            n--;
        }

        x = x1.clone();

        for (int k = 0; k < x1.length; k++) {
            for (int l = 0; l < x1.length; l++) {
                System.out.print(" " + x1[k][l]);
            }
            System.out.println();
        }
    }

    private static void addCurrValueInNewIndex(int[][] x, int n, int[][] x1, int i, int j, int io, int jo) {
        int inew = 0, jnew = 0;
        if ((i == io && j == 0)) {
            inew = i;
            jnew = (n - 1);
        } else if ((i == io && j == n - 1)) {
            inew = (n - 1);
            jnew = j;
        } else if (i == n - 1 && j == n - 1) {
            inew = j;
            jnew = jo;
        } else if ((i == n - 1 && j == jo)) {
            inew = io;
            jnew = j;
        } else if (i == io) {
            inew = j;
            jnew = n - 1;
        } else if (i == n - 1) {
            inew = j;
            jnew = io;
        } else if (j == jo) {
            inew = jo;
            jnew = i;
        } else if (j == n - 1) {
            inew = n - 1;
            jnew = n - 1 - i;
        }
        x1[inew][jnew] = x[i][j];
    }


}




