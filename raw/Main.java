package Tubes1.matriksgeming.raw;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner choice = new Scanner(System.in);
        System.out.println("Selamat Datang di Program Matriks");
        System.out.println("Pilih Menu di Bawah ini:");
        System.out.println("1. Cari solusi SPL");
        System.out.println("2. Cari invers matriks");
        System.out.println("3. Cari determinan");
        System.out.println("4. Cari solusi interpolasi polinom");
        System.out.println("5. Cari hasil regresi berganda");
        System.out.println("6. Keluar");
        System.out.printf("Masukkan pilihan: ");
        int choiceMenu = choice.nextInt();
        int choiceMethod;
        switch (choiceMenu) {
            case 1:
                System.out.println("Daftar metode yang dapat digunakan:");
                System.out.println("1. Metode Gauss");
                System.out.println("2. Metode Gauss-Jordan");
                System.out.println("3. Metode Invers");
                System.out.println("4. Metode Kaidah Cramer");
                System.out.printf("Masukkan pilihan metode: ");
                choiceMethod = choice.nextInt();
                if (choiceMethod == 1) {
                    break; // belom ada fungsinya
                }
                if (choiceMethod == 2) {
                    break; // belom ada fungsinya
                }
                if (choiceMethod == 3) {
                    System.out.printf("Pilih 0 untuk memasukkan matriks secara langsung dan 1 untuk membaca dari file: ");
                    int choiceRead = choice.nextInt();
                    if (choiceRead == 0) {
                        int row, col;
                        System.out.printf("Masukkan ukuran baris: ");
                        row = choice.nextInt();
                        System.out.printf("Masukkan ukuran kolom: ");
                        col = choice.nextInt();
                        Matriks m = new Matriks();
                        m.createMatriks(row, col);
                        System.out.println("Isi matriks di bawah ini: ");
                        m.readMatrix();
                        m.findSPLwithInv();
                    }
                    if (choiceRead == 1) {
                        int row, col;
                        System.out.printf("Masukkan ukuran baris: ");
                        row = choice.nextInt();
                        System.out.printf("Masukkan ukuran kolom: ");
                        col = choice.nextInt();
                        Matriks m = new Matriks();
                        m.createMatriks(row, col);
                        m.readMatrixfromFile(); 
                        // ini nanti kasih func solusi trus tulis ke file
                    }
                }
                if (choiceMethod == 4) {
                    System.out.printf("Pilih 0 untuk memasukkan matriks secara langsung dan 1 untuk membaca dari file: ");
                    int choiceRead = choice.nextInt();
                    if (choiceRead == 0) {
                        int row, col;
                        System.out.printf("Masukkan ukuran baris: ");
                        row = choice.nextInt();
                        System.out.printf("Masukkan ukuran kolom: ");
                        col = choice.nextInt();
                        Matriks m = new Matriks();
                        m.createMatriks(row, col);
                        System.out.println("Isi matriks di bawah ini: ");
                        m.readMatrix();
                        m.kaidah_crammer();
                    }
                    if (choiceRead == 1) {
                        int row, col;
                        System.out.printf("Masukkan ukuran baris: ");
                        row = choice.nextInt();
                        System.out.printf("Masukkan ukuran kolom: ");
                        col = choice.nextInt();
                        Matriks m = new Matriks();
                        m.createMatriks(row, col);
                        m.readMatrixfromFile(); 
                        // ini nanti kasih func solusi trus tulis ke file
                    }
                }
                break;
            case 2: 
                System.out.println("Daftar metode yang dapat digunakan:");
                System.out.println("1. Metode Gauss-Jordan");
                System.out.println("2. Metode Matriks Adjoin");
                System.out.printf("Masukkan pilihan metode: ");
                choiceMethod = choice.nextInt();
                if (choiceMethod == 1) {
                    System.out.printf("Pilih 0 untuk memasukkan matriks secara langsung dan 1 untuk membaca dari file: ");
                    int choiceRead = choice.nextInt();
                    if (choiceRead == 0) {
                        int row, col;
                        System.out.printf("Masukkan ukuran baris: ");
                        row = choice.nextInt();
                        System.out.printf("Masukkan ukuran kolom: ");
                        col = choice.nextInt();
                        Matriks m = new Matriks();
                        m.createMatriks(row, col);
                        System.out.println("Isi matriks di bawah ini: ");
                        m.readMatrix();
                        m.inversGaussWrite();
                    }
                    if (choiceRead == 1) {
                        int row, col;
                        System.out.printf("Masukkan ukuran baris: ");
                        row = choice.nextInt();
                        System.out.printf("Masukkan ukuran kolom: ");
                        col = choice.nextInt();
                        Matriks m = new Matriks();
                        m.createMatriks(row, col);
                        m.readMatrixfromFile(); 
                        // ini nanti kasih func solusi trus tulis ke file
                    }
                }
                if (choiceMethod == 2) {
                    System.out.printf("Pilih 0 untuk memasukkan matriks secara langsung dan 1 untuk membaca dari file: ");
                    int choiceRead = choice.nextInt();
                    if (choiceRead == 0) {
                        int row, col;
                        System.out.printf("Masukkan ukuran baris: ");
                        row = choice.nextInt();
                        System.out.printf("Masukkan ukuran kolom: ");
                        col = choice.nextInt();
                        Matriks m = new Matriks();
                        m.createMatriks(row, col);
                        System.out.println("Isi matriks di bawah ini: ");
                        m.readMatrix();
                        m.adjoint_invers();
                    }
                }
                break;
            case 3:
                System.out.println("Daftar metode yang dapat digunakan:");
                System.out.println("1. Metode OBE");
                System.out.println("2. Metode Matriks Kofaktor");
                System.out.printf("Masukkan pilihan metode: ");
                choiceMethod = choice.nextInt();
                if (choiceMethod == 1) {
                    System.out.printf("Pilih 0 untuk memasukkan matriks secara langsung dan 1 untuk membaca dari file: ");
                    int choiceRead = choice.nextInt();
                    if (choiceRead == 0) {
                        int row, col;
                        System.out.printf("Masukkan ukuran baris: ");
                        row = choice.nextInt();
                        System.out.printf("Masukkan ukuran kolom: ");
                        col = choice.nextInt();
                        Matriks m = new Matriks();
                        m.createMatriks(row, col);
                        System.out.println("Isi matriks di bawah ini: ");
                        m.readMatrix();
                        m.getDeterminantOBE();
                    }
                    if (choiceRead == 1) {
                        int row, col;
                        System.out.printf("Masukkan ukuran baris: ");
                        row = choice.nextInt();
                        System.out.printf("Masukkan ukuran kolom: ");
                        col = choice.nextInt();
                        Matriks m = new Matriks();
                        m.createMatriks(row, col);
                        m.readMatrixfromFile(); 
                        // ini nanti kasih func solusi trus tulis ke file
                    }
                }
                if (choiceMethod == 2) {
                    System.out.printf("Pilih 0 untuk memasukkan matriks secara langsung dan 1 untuk membaca dari file: ");
                    int choiceRead = choice.nextInt();
                    if (choiceRead == 0) {
                        int row, col;
                        System.out.printf("Masukkan ukuran baris: ");
                        row = choice.nextInt();
                        System.out.printf("Masukkan ukuran kolom: ");
                        col = choice.nextInt();
                        Matriks m = new Matriks();
                        m.createMatriks(row, col);
                        System.out.println("Isi matriks di bawah ini: ");
                        m.readMatrix();
                        Matriks n = new Matriks();
                        n.createMatriks(row, col);
                        m.getDeterminantC(n);
                    }

                    if (choiceRead == 1) {
                        int row, col;
                        System.out.printf("Masukkan ukuran baris: ");
                        row = choice.nextInt();
                        System.out.printf("Masukkan ukuran kolom: ");
                        col = choice.nextInt();
                        Matriks m = new Matriks();
                        m.createMatriks(row, col);
                        m.readMatrixfromFile(); 
                        // ini nanti kasih func solusi trus tulis ke file
                    }
                }
                break;
            case 4: 
                System.out.printf("Pilih 0 untuk memasukkan polinom secara langsung dan 1 untuk membaca dari file: ");
                int choiceRead = choice.nextInt();
                if (choiceRead == 0) {
                    int row, col;
                    System.out.printf("Masukkan ukuran baris: ");
                    row = choice.nextInt();
                    System.out.printf("Masukkan ukuran kolom: ");
                    col = choice.nextInt();
                    Matriks m = new Matriks();
                    m.createMatriks(row, col);
                    System.out.println("Isi polinom di bawah ini: ");
                    m.polynomRead();
                    m.polynomInterpolate(true);
                }
                if (choiceRead == 1) {
                    int row, col;
                    System.out.printf("Masukkan ukuran baris: ");
                    row = choice.nextInt();
                    System.out.printf("Masukkan ukuran kolom: ");
                    col = choice.nextInt();
                    Matriks m = new Matriks();
                    m.createMatriks(row, col);
                    m.readMatrixfromFile(); 
                    // ini nanti kasih func solusi trus tulis ke file
                }
                break;
            case 5:
                // belom ada fungsinya
                break;
            case 6:
                break; // keluar
        }
    }
}
