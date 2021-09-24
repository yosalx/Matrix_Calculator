package Tubes1.matriksgeming.raw;

import java.util.*;

class Matriks {
    int RowMin = 0, RowMax = 100;
    int ColMin = 0, ColMax = 100;
    int Row, Col;
    double[][] Mtrx;
    Scanner scanner = new Scanner(System.in);

    void createMatriks(int row, int col) {
        this.Row = row;
        this.Col = col;
        Mtrx = new double[row][col];
    }

    int getFirstIdxRow() {
        return RowMin;
    }

    int getFirstIdxCol() {
        return ColMin;
    }

    int getLastIdxRow() {
        return this.Row - 1;
    }

    int getLastIdxCol() {
        return this.Col - 1;
    }

    int countElmt() {
        return this.Row * this.Col;
    }

    double getElmt(int row, int col) {
        return this.Mtrx[row][col];
    }

    void readMatrix() {
        int i, j;
        for (i = 0; i < this.Row; i++) {
            for (j = 0; j < this.Col; j++) {
                this.Mtrx[i][j] = scanner.nextDouble();
            }
        }
    }

    void writeMatrix() {
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

    boolean isSquare() {
        return (this.Row == this.Col);
    }

    boolean isIdentity(Matriks m) {
        int i, j;
        boolean ident = true;
        for (i = 0; i < this.Row; i++) {
            for (j = 0; j < this.Col; j++) {
                if ((i == j) && (m.Mtrx[i][j] != 1)) {
                    return false;
                }
                if ((i != j) && (m.Mtrx[i][j] != 0)) {
                    return false;
                }
            }
        }
        return ident;
    }
    
    void multiplyRow(int row, double x) {
        int j;
        for (j = 0; j < this.Col; j++) {
            Mtrx[row][j] = x*Mtrx[row][j];
        }
    }

    void multiplyCol(int col, double x) {
        int i;
        for (i = 0; i < this.Row; i++) {
            Mtrx[i][col] = x*Mtrx[i][col];
        }
    }

    void plusRow(int row1, int row2, double x) {
        int j;
        for (j = 0; j < this.Col; j++) {
            Mtrx[row1][j] += x*Mtrx[row2][j];
        }
    }

    void minusRow(int row1, int row2, double x) {
        plusRow(row1, row2, -x);
    }

    void rowSwap(int row1, int row2) {
        double[] temp = Mtrx[row1];
        Mtrx[row1] = Mtrx[row2];
        Mtrx[row2] = temp;
    }
}