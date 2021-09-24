package Tubes1.matriksgeming.raw;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Matriks m = new Matriks();
        m.createMatriks(3, 3);
        m.readMatrix();
        m.writeMatrix();
        System.out.println();
        m.elimGauss();
        m.writeMatrix();
        System.out.println();
        double n = 0;
        n = m.determinantReduksiBaris();
        System.out.println(n);
    }
}
