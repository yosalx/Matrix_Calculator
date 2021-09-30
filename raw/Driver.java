package Tubes1.matriksgeming.raw;

import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);        
        //Matriks m = new Matriks();
        //int n;
        //System.out.print("\nMasukkan banyak peubah: ");
        //n = input.nextInt();
        //int p;
        //System.out.print("Masukkan banyak data per peubah: ");
        //p = input.nextInt();
        //m.createMatriks(n, n);
        //m.readMatrixHilbert();
        //System.out.println("\nMasukkan nilai yang ingin ditafsir:");
        //double[] est =  new double[1];
        //est = new double[n];
        //int i;
        //for(i = 0; i < n; i++){
        //    est[i] = input.nextDouble();
        //}
        //m.double_regression(m.Col-1, est );
        //m.findSPLwithInv();
        // m.polynomInterpolate(true);
        //m.writeMatrix();
        //int row, col, count;
        //System.out.printf("Masukkan jumlah n: ");
        //count = input.nextInt();
        //row = count;
        //col = count + 1;
        Matriks m = new Matriks();
        m.readMatrixfromFile();
        //System.out.println("Isi matriks hasil: ");
        //for (int i = 0; i < row; i++) {
        //    m.setElmt(i, count);
        //}
        m.writeMatrix();
        //m.elimGaussJordan();
        //m.writeMatrix();
        m.inversGaussWrite();
        m.writeMatrixInvToFile();
    }
}
