package com.kpi;

public class App 
{
    public static void main( String[] args )
    {
        Matrix<Integer> v = Matrix.randomColumnVector(4);
        v.set(0, 101);

        System.out.println(v);
    }
}
