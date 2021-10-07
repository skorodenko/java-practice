package com.kpi;

public class App 
{
    public static void main( String[] args )
    {
        // Task 1 incapsulated Matrix

        /*
        // Task 2 Constructors + copy
        Matrix<Integer> c1 = new Matrix<>();
        System.out.println(c1 + "\n");

        Matrix<Integer> c2 = new Matrix<>(3,2);
        //System.out.println(c2 + "\n");

        Matrix<Integer> c3 = new Matrix<>(c2);
        //c2.set(0,0,1);
        c3.set(0,0,9);
        System.out.println(c2 + "\n");
        System.out.println(c3 + "\n");
        */    

        /*
        // Task 3 setter
        Matrix<Integer> m = new Matrix<>(3,5);
        m.set(0,0,1);
        m.set(0,1,2);
        m.set(1,0,3);
        System.out.println(m + "\n");
        */

        /*
        // Task 4 getters
        Matrix<Integer> m = Matrix.randomMatrix(3, 4);
        System.out.println(m + "\n");
        Matrix<Integer> mm = new Matrix<>(m);
        m.set(1,2,5);
        System.out.println(m + "\n");
        System.out.println(mm + "\n");
        //System.out.println("Element at 0,0: " + m.get(0,0) + "\n");
        //System.out.println("2nd column of matrix: " + m.getColumn(1) + "\n");
        //System.out.println("3rd row of matrix: " + m.getRow(2));
        */

        /*
        // Task 5 getSize
        Matrix<Integer> m = new Matrix<>(13,23);
        System.out.println(m.getSize());
        */

        // Task 6 equals & hashCode

        // Task 7 immutable Matrix
        
        /*
        // Task 8 Diagonal Matrix
        Matrix<Double> cv = Matrix.randomColumnVector(4);
        cv.set(0, 5.0);
        System.out.println(cv + "\n");
        Matrix<Double> m = Matrix.diagonalMatrix(cv);
        System.out.println(m);
        */
        
        /*
        // Task 9 Triangular Matrix
        Matrix<Integer> m = Matrix.randomMatrix(4, 4);
        System.out.println(m + "\n");
        m.upperTriangular();
        System.out.println(m);
        */
    }
}
