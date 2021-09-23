package com.kpi;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<ArrayList<Number>> m = Matrix.onesMatrix(3);
        System.out.println( m );

        Matrix<Double> t = new Matrix<>(2,3);
        t.set(0,0,1.0);
        //t.set(1,1,1.0);

        System.out.println(t);
    }
}
