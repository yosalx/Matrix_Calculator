package Tubes1.matriksgeming.raw;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Matriks m = new Matriks();
        m.createMatriks(3, 4);
        m.readMatrix();
        m.writeMatrix();
        System.out.println();
        m.kaidah_crammer();
    }
}
