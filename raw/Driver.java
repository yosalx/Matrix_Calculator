package Tubes1.matriksgeming.raw;

import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) throws IOException {
        Matriks m = new Matriks();
        m.createMatriks(4, 4);
        m.readMatrix();
        //m.polynomRead();
        m.writeMatrix();
        System.out.println("\n");
        m.adjoint_invers();
        //m.findSPLwithInv();
        // m.polynomInterpolate(true);
    }
}
