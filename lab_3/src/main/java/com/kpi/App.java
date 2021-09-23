package com.kpi;

public class App 
{
    public static void main( String[] args )
    {
        Matrix<Double> m = Matrix.onesMatrix(3);
        System.out.println( m );

        Matrix<Float> t = new Matrix<>(1,5);
        System.out.println(t);
        t.set(2, (float)24);

        MatrixIm<Integer> k = MatrixIm.randomColumnVector(5);
        System.out.println(k);
    }
}
