package com.kpi;

public class App 
{
    public static void main( String[] args )
    {
        Matrix<Double> m = Matrix.onesMatrix(3);
        System.out.println( m );

        Matrix<Integer> t = new Matrix<>(5,1);
        System.out.println(t);

        MatrixIm<Integer> k = new MatrixIm<>(t);
        System.out.println(k);
    }
}
