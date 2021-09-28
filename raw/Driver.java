package Tubes1.matriksgeming.raw;

import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);        
        Matriks m = new Matriks();
        int n;
        System.out.print("\nMasukkan banyak peubah: ");
        n = input.nextInt();
        int p;
        System.out.print("Masukkan banyak data per peubah: ");
        p = input.nextInt();
        m.createMatriks(p, n+1);
        m.readMatrix();
        System.out.println("\nMasukkan nilai yang ingin ditafsir:");
        double[] est =  new double[1];
        est = new double[n];
        int i;
        for(i = 0; i < n; i++){
            est[i] = input.nextDouble();
        }
        m.double_regression(m.Col-1, est );
        //m.findSPLwithInv();
        // m.polynomInterpolate(true);
    }
}
