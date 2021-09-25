package Tubes1.matriksgeming.raw;

import java.util.*;
import java.io.*;

class Matriks {
    int RowMin = 0, RowMax = 100;
    int ColMin = 0, ColMax = 100;
    int Row, Col, countSwap;
    double saveDividers = 1;
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

    void writeMatrixfromFile(String filename) {
        
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
        int i, count;
        count = 0;
        for (i = row + 1; i < this.Row; i++) {
            if (!isZero(i, col)) {
                Swap(row, i);
                break;
            }
        }
        count++;
        this.countSwap = count;
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
            while (divide == 0) {
                j++;
                divide = this.Mtrx[i][j];
            }
            this.saveDividers *= divide;
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
            while (divide == 0) {
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

    double determinantOBE() {
        double determinant = 1;
        elimGauss();
        for (int i = 0; i < this.Row; i++) {
            determinant *= this.Mtrx[i][i];
        }
        if (this.countSwap % 2 == 1) {
            determinant = -(determinant);
        }
        determinant *= this.saveDividers;
        return determinant;
    }

    void kaidah_crammer () {
        double det;
        double subdet;
        Matriks m1 = new Matriks();
        Matriks m2 = new Matriks();

        m1.createMatriks(this.Row, this.Col-1);
        for (int i = 0; i < this.Row; i++) {
            for (int j = 0; j < this.Col-1; j++) {
                m1.Mtrx[i][j] = this.Mtrx[i][j];
            }
        }
        m2.createMatriks(this.Row, 1);
        for (int k = 0; k < this.Row; k++) {
            m2.Mtrx[k][0] = this.Mtrx[k][this.Col-1];
        }
        det = determinantOBE();
        if (det == 0) {
            System.out.printf("determinan = 0, tidak bisa digunakan kaidah cramer");
        }
        else {
            double sol;
            for (int a = 0; a < this.Col-1; a++) {
                Matriks submatrix = new Matriks();
                submatrix.createMatriks(this.Row, this.Col-1);
                for (int b = 0; b < this.Col-1; b++) {
                    for (int c = 0; c < this.Row; c++) {
                        if (a==b) {
                            submatrix.Mtrx[c][b] = m2.Mtrx[c][0];
                        }
                        else {
                            submatrix.Mtrx[c][b] = m1.Mtrx[c][b];
                        }
                    }
                }
                subdet = submatrix.determinantOBE();
                sol = (subdet/det);
                System.out.printf("solusi X%d = ", a+1);
                System.out.printf("%.2f ", sol);
            }
        }
    }

    void DeterminantC(){
        System.out.println(this.getDeterminantC());
    }

    double getDeterminantC() {
        if(this.Row == 1) return this.getElmt(0, 0); 

        if(this.Row == 2) {                             
            return this.getElmt(0, 0)*this.getElmt(1, 1) - this.getElmt(0, 1)*this.getElmt(1, 0);
        }

        double det;
        det = 0;
        for (int i = 0; i < this.Col; i++) {
 
            Matriks m = new Matriks();
            m = subMatriks(0, i);

            det+= Math.pow(-1, i) * m.getDeterminantC();
            
        }
        return det;
    }

    Matriks subMatriks (int i, int j) {

        Matriks m = new Matriks();
        m.createMatriks(this.Row - 1, this.Col - 1); 

        int row =0 ,col=0;
        for (int j2 = 0; j2 < this.Row; j2++) {
            if(j2 == i) continue; 
            for (int k = 0; k < this.Col; k++) {
                if(k == j) continue;
                m.Mtrx[row][col] = this.Mtrx[j2][k];
                col++;
                if(col >= m.Col) {
                    col = 0;
                    row++;
                }
            }
        }
        return m;
    }

    void writeMatrixfromFile() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("tes.txt"));
        String data = input.readLine();

        int i, j;
        for (i = 0; i < this.Row; i++) {
            StringTokenizer string = new StringTokenizer(data, " ");
            for (j = 0; j < this.Col; j++) {
                this.Mtrx[i][j] = Double.valueOf(string.nextToken()).doubleValue();
            }
            data = input.readLine();
        }
        this.writeMatrix();
    }

    void polynomRead() {
        double an, bn;
        int i, j;
        j = 0;

        for (i = 0; i < this.Row; i++) {
            this.Mtrx[i][j] = 1;
        }
        for (i = 0; i < this.Col; i++) {
            System.out.printf("Masukkan nilai untuk titik ke-%d : ", i + 1);
            an = scanner.nextDouble();
            bn = scanner.nextDouble();
            for (j = 1; j < this.Col - 1; j++) {
                this.Mtrx[i][j] = (double) Math.pow(an, j);
            }
            this.Mtrx[i][this.Col - 1] = bn;
        }
    }

    void inversGauss() {
        Matriks inv = new Matriks();
        inv.createMatriks(this.Row, this.Col);
        int i, j;
        for (i = 0; i < this.Row; i++) {
            inv.Mtrx[i][i] = 1;
        }
        double divide, multiply;
        int zeroCol = 0;
        for (i = 0; i < this.Row; i++) {
            for (j = i + zeroCol; j < this.Col; j++) {
                if (isZero(i, i+zeroCol)) {
                    if (isBelowRowZero(i, i)) {
                        zeroCol++;
                    } else {
                        int a;
                        for (a = i + 1; a < this.Row; a++) {
                            if (!isZero(a, i)) {
                                double temp;
                                for (j = 0; j < this.Col; j++) {
                                    temp = this.Mtrx[a][j];
                                    this.Mtrx[a][j] = this.Mtrx[i][j];
                                    this.Mtrx[i][j] = temp;
                                    temp = inv.Mtrx[a][j];
                                    inv.Mtrx[a][j] = inv.Mtrx[i][j];
                                    inv.Mtrx[i][j] = temp;
                                }
                                break;
                            }
                        }
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
            while (divide == 0) {
                j++;
                divide = this.Mtrx[i][j];
            }
            int k;
            for (k = j; k < this.Col; k++) {
                this.Mtrx[i][k] /= divide;
            }
            for (k = 0; k < this.Col; k++) {
                inv.Mtrx[i][k] /= divide;
            }
            for (k = i+1; k < this.Row; k++) {
                multiply = this.Mtrx[k][j];
                int subj;
                for (subj = j; subj < this.Col; subj++) {
                    this.Mtrx[k][subj] -= multiply*this.Mtrx[i][subj];
                }
                for (subj = 0; subj < this.Col; subj++) {
                    inv.Mtrx[k][subj] -= multiply*inv.Mtrx[i][subj];
                }
            } 
        }
        for (i = 0; i < this.Row; i++) {
            for (j = i; j < this.Col; j++) {
                if (this.Mtrx[i][j] == 1) {
                    int k;
                    for (k = 0; k < i; k++) {
                        if (!isZero(k, j)) {
                            multiply = this.Mtrx[k][j];
                            for (int subj = j; subj < this.Col; subj++) {
                                this.Mtrx[k][subj] -= this.Mtrx[i][subj]*multiply;
                            }
                            for (int subj = 0; subj < this.Col; subj++) {
                                inv.Mtrx[k][subj] -= inv.Mtrx[i][subj]*multiply;
                            }
                        }
                    }
                }
            }
        }
        if (!isIdentity(this)) {
            System.out.println("Matriks tidak mempunyai invers");
        } else {
            inv.writeMatrix();
        }
    }
}


