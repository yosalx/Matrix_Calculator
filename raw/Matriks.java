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
}