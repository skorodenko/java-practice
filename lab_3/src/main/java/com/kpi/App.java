package com.kpi;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<ArrayList<Number>> m = Matrix.onesMatrix(2);
        System.out.println( m );
    }
}
