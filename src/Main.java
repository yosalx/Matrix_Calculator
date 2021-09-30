package src;

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
        int choiceRead;
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
                    choiceRead = choice.nextInt();
                    if (choiceRead == 0) {
                        System.out.printf("Pilih 0 untuk membuat matriks hilbert atau 1 jika bukan :");
                        int choiceKind = choice.nextInt();
                        if (choiceKind == 0) {
                            int row, col, count;
                            System.out.printf("Masukkan jumlah n: ");
                            count = choice.nextInt();
                            row = count;
                            col = count + 1;
                            Matriks m = new Matriks();
                            m.createMatriks(row, col);
                            m.readMatrixHilbert(count);
                            System.out.println("Isi matriks hasil: ");
                            for (int i = 0; i < row; i++) {
                                m.setElmt(i, count);
                            }
                            System.out.printf("Pilih 0 untuk menyimpan di dalam file: ");
                            int choicePrint = choice.nextInt();
                            if (choicePrint == 0) {
                                m.findSPLwithInv(true); 
                            } else {
                                m.findSPLwithInv(false);
                            }
                        }
                        if (choiceKind == 1) {
                            int row, col;
                            System.out.printf("Masukkan ukuran baris: ");
                            row = choice.nextInt();
                            System.out.printf("Masukkan ukuran kolom: ");
                            col = choice.nextInt();
                            Matriks m = new Matriks();
                            m.createMatriks(row, col);
                            System.out.println("Isi matriks di bawah ini: ");
                            m.readMatrix();
                            System.out.printf("Pilih 0 untuk menyimpan di dalam file: ");
                            int choicePrint = choice.nextInt();
                            if (choicePrint == 0) {
                                m.findSPLwithInv(true); 
                            } else {
                                m.findSPLwithInv(false);
                            }
                        }
                    }
                    if (choiceRead == 1) {
                        Matriks m = new Matriks();
                        m.readMatrixfromFile(); 
                        m.writeMatrix();
                        System.out.printf("Pilih 0 untuk menyimpan di dalam file: ");
                        int choicePrint = choice.nextInt();
                        if (choicePrint == 0) {
                            m.findSPLwithInv(true); 
                        } else {
                            m.findSPLwithInv(false);
                        }
                    }
                }
                if (choiceMethod == 4) {
                    System.out.printf("Pilih 0 untuk memasukkan matriks secara langsung dan 1 untuk membaca dari file: ");
                    choiceRead = choice.nextInt();
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
                        System.out.printf("Pilih 0 untuk menyimpan di dalam file: ");
                        int choicePrint = choice.nextInt();
                        if (choicePrint == 0) {
                            m.kaidah_crammer(true); 
                        } else {
                            m.kaidah_crammer(false);
                        }
                    }
                    if (choiceRead == 1) {
                        Matriks m = new Matriks();
                        m.readMatrixfromFile(); 
                        System.out.printf("Pilih 0 untuk menyimpan di dalam file: ");
                        int choicePrint = choice.nextInt();
                        if (choicePrint == 0) {
                            m.kaidah_crammer(true); 
                        } else {
                            m.kaidah_crammer(false);
                        }
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
                    choiceRead = choice.nextInt();
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
                        System.out.printf("Pilih 0 untuk menyimpan di file: ");
                        int choicePrint = choice.nextInt();
                        if (choicePrint == 0) {
                            m.writeMatrixInvToFile();
                        }
                    }
                    if (choiceRead == 1) {
                        Matriks m = new Matriks();
                        m.readMatrixfromFile(); 
                        m.inversGaussWrite();
                        System.out.printf("Pilih 0 untuk menyimpan di file: ");
                        int choicePrint = choice.nextInt();
                        if (choicePrint == 0) {
                            m.writeMatrixInvToFile();
                        }
                    }
                }
                if (choiceMethod == 2) {
                    System.out.printf("Pilih 0 untuk memasukkan matriks secara langsung dan 1 untuk membaca dari file: ");
                    choiceRead = choice.nextInt();
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
                        System.out.printf("Pilih 0 untuk menyimpan di file: ");
                        int choicePrint = choice.nextInt();
                        if (choicePrint == 0) {
                            m.writeMatrixInvToFile();
                        }
                    }
                    if (choiceRead == 1) {
                        Matriks m = new Matriks();
                        m.readMatrixfromFile(); 
                        m.adjoint_invers();
                        System.out.printf("Pilih 0 untuk menyimpan di file: ");
                        int choicePrint = choice.nextInt();
                        if (choicePrint == 0) {
                            m.writeMatrixInvToFile();
                        }
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
                    choiceRead = choice.nextInt();
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
                        System.out.printf("Pilih 0 untuk menyimpan di file: ");
                        int choicePrint = choice.nextInt();
                        if (choicePrint == 0) {
                            m.writeMatrixDetToFile();
                        }
                    }
                    if (choiceRead == 1) {
                        Matriks m = new Matriks();
                        m.readMatrixfromFile(); 
                        m.getDeterminantOBE();
                        System.out.printf("Pilih 0 untuk menyimpan di file: ");
                        int choicePrint = choice.nextInt();
                        if (choicePrint == 0) {
                            m.writeMatrixDetToFile();
                        }
                    }
                }
                if (choiceMethod == 2) {
                    System.out.printf("Pilih 0 untuk memasukkan matriks secara langsung dan 1 untuk membaca dari file: ");
                    choiceRead = choice.nextInt();
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
                        System.out.printf("Pilih 0 untuk menyimpan di file: ");
                        int choicePrint = choice.nextInt();
                        if (choicePrint == 0) {
                            m.writeMatrixDetToFile();
                        }
                    }

                    if (choiceRead == 1) {
                        Matriks m = new Matriks();
                        m.readMatrixfromFile();
                        Matriks n = new Matriks();
                        n.createMatriks(m.Row, m.Col);
                        m.getDeterminantC(n);
                        System.out.printf("Pilih 0 untuk menyimpan di file: ");
                        int choicePrint = choice.nextInt();
                        if (choicePrint == 0) {
                            m.writeMatrixDetToFile();
                        }
                    }
                }
                break;
            case 4: 
                System.out.printf("Pilih 0 untuk memasukkan polinom secara langsung dan 1 untuk membaca dari file: ");
                choiceRead = choice.nextInt();
                if (choiceRead == 0) {
                    int row, col;
                    System.out.printf("Masukkan banyak data: ");
                    row = choice.nextInt();
                    col = row + 1;
                    Matriks m = new Matriks();
                    m.createMatriks(row, col);
                    System.out.println("Isi polinom di bawah ini: ");
                    m.polynomRead();
                    System.out.printf("Pilih 0 untuk menyimpan di dalam file: ");
                    int choicePrint = choice.nextInt();
                    if (choicePrint == 0) {
                        m.polynomInterpolate(true); 
                    } else {
                        m.polynomInterpolate(false);
                    }
                    
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
                System.out.printf("Pilih 0 untuk memasukkan data secara langsung dan 1 untuk membaca dari file: ");
                choiceRead = choice.nextInt();
                if (choiceRead == 0) {
                    Matriks m = new Matriks();
                    int n,p;
                    System.out.print("\nMasukkan banyak peubah: ");
                    n = choice.nextInt();
                    System.out.print("\nMasukkan banyak data per peubah: ");
                    p = choice.nextInt();
                    System.out.print("\nMasukkan data: \n");
                    m.createMatriks(p, n+1);
                    m.readMatrix();
                    System.out.println("\nMasukkan nilai yang ingin ditafsir:");
                    double[] est =  new double[1];
                    est = new double[n];
                    int i;
                    for(i = 0; i < n; i++){
                        est[i] = choice.nextDouble();
                    }
                    System.out.printf("Pilih 0 untuk menyimpan hasil di dalam file dan 1 untuk mencetak hasil ke layar: ");
                    int choicePrint = choice.nextInt();
                    if (choicePrint == 0) {
                        m.double_regression(m.Col-1, est, true ); 
                    } else {
                        m.double_regression(m.Col-1, est, false);
                    }
                }
                break;
            case 6:
                break; // keluar
        }
    }
}