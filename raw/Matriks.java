package Tubes1.matriksgeming.raw;

import java.util.*;

public class Matriks {
    public int RowMin = 0, RowMax = 100;
    public int ColMin = 0, ColMax = 100;
    public int Row, Col;
    public double[][] Mtrx;
    Scanner scanner = new Scanner(System.in);

    public Matriks(int row, int col) {
        this.Row = row;
        this.Col = col;
        this.Mtrx = new double[row][col];
    }

    public int getFirstIdxRow() {
        return RowMin;
    }

    public int getFirstIdxCol() {
        return ColMin;
    }

    public int getLastIdxRow() {
        return this.Row - 1;
    }

    public int getLastIdxCol() {
        return this.Col - 1;
    }

    public int countElmt() {
        return this.Row * this.Col;
    }

    public double getElmt(int row, int col) {
        return this.Mtrx[row][col];
    }

    public void rowSwap(int row1, int row2) {
        double[] temp = Mtrx[row1];
        Mtrx[row1] = Mtrx[row2];
        Mtrx[row2] = temp;
    }

    public boolean isSquare() {
        return (this.Row == this.Col);
    }

    public void writeMatrix() {
        int i, j;
        for (i = 0; i < this.Row; i++) {
            for (j = 0; j < this.Col; j++) {
                if (j == this.Col - 1) {
                    System.out.println(getElmt(i, j));
                } else {
                    System.out.println(getElmt(i, j) + " ");
                }
            }
            if (i != this.Row - 1) {
                System.out.println("\n");
            }
        }
    }

    public void multiplyRow(int row, double x) {
        int j;
        for (j = 0; j < this.Col; j++) {
            Mtrx[row][j] = x*Mtrx[row][j];
        }
    }

    public void multiplyCol(int col, double x) {
        int i;
        for (i = 0; i < this.Row; i++) {
            Mtrx[i][col] = x*Mtrx[i][col];
        }
    }

    public void plusRow(int row1, int row2, double x) {
        int j;
        for (j = 0; j < this.Col; j++) {
            Mtrx[row1][j] += x*Mtrx[row2][j];
        }
    }

    public void minusRow(int row1, int row2, double x) {
        plusRow(row1, row2, -x);
    }

    
}