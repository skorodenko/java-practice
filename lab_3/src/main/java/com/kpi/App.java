package com.kpi;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        Matrix<Double> m = Matrix.onesMatrix(3);
        System.out.println( m );

        Matrix<Integer> t = new Matrix<>(2,3);
        t.set(0,0,15);
        //t.set(1,1,1.0);

        System.out.println(t.getSize());

        System.out.println(t);
    }
}
