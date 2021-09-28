package com.kpi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class MatrixTest 
{
    @Test
    public void constructorTest1() {
        Matrix<Integer> m = new Matrix<>();
        assertEquals("[]", m.toString());
    }

    @Test
    public void constructorTest2() {
        Matrix<Integer> m = new Matrix<>(1,2);
        assertEquals("[[0, 0]]", m.toString());
    }

    @Test
    public void constructorTest3() {
        Matrix<Integer> ones = Matrix.onesMatrix(3);
        Matrix<Integer> m = new Matrix<>(ones);

        assertEquals(ones.toString(), m.toString());
    }



    @Test
    public void setTest1() {
        Matrix<Integer> m = Matrix.onesMatrix(4);
        m.set(0,0,23);
        m.set(1,2,-29);
        assertEquals("[[23, 0, 0, 0]\n"+" [0, 1, -29, 0]\n"+" [0, 0, 1, 0]\n"+" [0, 0, 0, 1]]", m.toString());
    }

    @Test
    public void setTest2() {
        Matrix<Integer> v = Matrix.randomColumnVector(4);
        v.set(0, 101);
        assertEquals(Integer.valueOf(101), v.get(0));
    }
}
