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
                System.out.printf("%.2f ", this.Mtrx[i][j]);
            }
            System.out.print("\n");
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

    boolean isZero(int row, int col) {
        return this.Mtrx[row][col] == 0;
    }

    boolean isBelowRowZero(int row, int col) {
        int i;
        if (row + 1 >= this.Row) {
            return true;
        }
        for (i = row + 1; i < this.Row; i++) {
            if (!isZero(i, col)) {
                return false;
            }
        }
        return true;
    }

    void Swap(int row1, int row2) {
        double temp;
        for (int j = 0; j < this.Col; j++) {
            temp = this.Mtrx[row2][j];
            this.Mtrx[row2][j] = this.Mtrx[row1][j];
            this.Mtrx[row1][j] = temp;
        }
    }

    void swapZero(int row, int col) {
        int i;
        for (i = row + 1; i < this.Row; i++) {
            if (!isZero(i, col)) {
                Swap(row, i);
                break;
            }
        }
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

    void elimGauss() {
        int i, j;
        double multiply, divide;
        int zeroCol = 0;
        for (i = 0; i < this.Row; i++) {
            for (j = i+zeroCol; j < this.Col; j++) {
                if (isZero(i, j)) {
                    if (isBelowRowZero(i, j)) {
                        zeroCol++;
                    } else {
                        swapZero(i, j);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j >= this.Col) {
                break;
            }
            divide = this.Mtrx[i][j];
            if (divide == 0) {
                j++;
                divide = this.Mtrx[i][j];
            }
            int k;
            for (k = j; k < this.Col; k++) {
                this.Mtrx[i][k] /= divide;
            }
            for (k = i+1; k < this.Row; k++) {
                multiply = this.Mtrx[k][j];
                for (int subj = j; subj < this.Col; subj++) {
                    this.Mtrx[k][subj] -= this.Mtrx[i][subj]*multiply;
                }
            }
        }
    }

    void elimGaussJordan() {
        int i, j;
        double multiply, divide;
        int zeroCol = 0;
        for (i = 0; i < this.Row; i++) {
            for (j = i+zeroCol; j < this.Col; j++) {
                if (isZero(i, j)) {
                    if (isBelowRowZero(i, j)) {
                        zeroCol++;
                    } else {
                        swapZero(i, j);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j >= this.Col) {
                break;
            }
            divide = this.Mtrx[i][j];
            if (divide == 0) {
                j++;
                divide = this.Mtrx[i][j];
            }
            int k;
            for (k = j; k < this.Col; k++) {
                this.Mtrx[i][k] /= divide;
            }
            for (k = 0; k < this.Row; k++) {
                if (k == i) {
                    continue;
                } else {
                    multiply = this.Mtrx[k][j];
                    for (int subj = j; subj < this.Col; subj++) {
                        this.Mtrx[k][subj] -= this.Mtrx[i][subj]*multiply;
                    } 
                }
            }
        }
    }

    double determinantReduksiBaris() { // returnnya belum bener
        int i, j;
        double multiply, divide;
        int zeroCol = 0;
        double det = 1d;
        double swap = -1d;
        for (i = 0; i < this.Col; i++) {
            for (j = i+zeroCol; j < this.Col; j++) {
                if (isZero(i, j)) {
                    if (isBelowRowZero(i, j)) {
                        zeroCol++;
                    } else {
                        swapZero(i, j);
                        det *= swap;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j >= this.Col) {
                break;
            }
            divide = this.Mtrx[i][j];
            if (divide == 0) {
                j++;
                divide = this.Mtrx[i][j];
            }
            int k;
            det *= divide;
            for (k = j; k < this.Col; k++) {
                this.Mtrx[i][k] /= divide;
            }
            for (k = i+1; k < this.Row; k++) {
                multiply = this.Mtrx[k][j];
                for (int subj = j; subj < this.Col; subj++) {
                    this.Mtrx[k][subj] -= this.Mtrx[i][subj]*multiply;
                }
            }
        }
        for (i = 0; i < this.Row; i++) {
            if (Mtrx[i][i] == 0) {
                det = 0d;
            }
        }
        return det;
    }
    /*
    Matriks Small_Matriks(Matriks m, int selected_row, int selected_col) { 
        Matriks small = new Matriks();
        small.createMatriks(m.Row-1, m.Col-1);
        int r = -1; 
        for (int i = 0;i < m.Row; i++) {
            if (i==selected_row) 
                continue; 
                r++; 
                int c = -1; 
            for (int j=0;j<m.Col;j++) {
                if (j == selected_col) 
                    continue; 
                small.setValueAt(r, ++c, m.getElmt(i, j)); 
            } 
        } 
        return small; 
    }

    double changeSign(int i){
        return(-1*i);
    }

    double determinant(Matriks m)  { 
        if (m.countElmt() == 2) {
            return (m.getElmt(0, 0) * m.getElmt(1, 1)) - (m.getElmt(0, 1) * m.getElmt(1, 0)); 
        }

        double det = 0.0; 
        for (int i=0; i < m.Col; i++) { 
            det += changeSign(i) * m.getElmt(0, i) * determinant(Small_Matriks(m, 0, i)); 
        } 
        return det; 
    }

    Matriks cofactor(Matriks m) { 
        Matriks kofaktor = new Matriks(); 
        kofaktor.createMatriks(m.Row, m.Col);
        for (int i=0;i<m.Row;i++) { 
            for (int j=0; j<m.Col;j++) {
                kofaktor.setValueAt(i, j, sign(i) * changeSign(j) * determinant(Small_Matriks(m, i, j))); 
            } 
        } 
        return kofaktor; 
    }

    double determinant_cofactor(Matriks m){
        Matriks kofaktor = cofactor(m);
        double determinant = 0.0;
        for(int j=0; j< m.Col; j++){
            determinant += m.getElmt(0,j)*kofaktor.getElmt(0, j);
        }
        return determinant;
    } */
}
