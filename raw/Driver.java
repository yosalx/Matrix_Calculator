package Tubes1.matriksgeming.raw;

import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) throws IOException {
        Matriks m = new Matriks();
        m.createMatriks(3, 3);
        m.readMatrix();
        //m.polynomRead();
        m.writeMatrix();
        m.inversGaussWrite();
        System.out.println();
        //m.findSPLwithInv();
        // m.polynomInterpolate(true);
    }
}
