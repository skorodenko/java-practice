package com.kpi;

import java.util.Vector;

public class Matrix implements ProtoMatrix {
 
    static public <T extends Number> Vector<Vector<T>> oneMatrix(Integer size) { 
        Vector<Vector<T>> m = new Vector<Vector<T>>();
        m.ensureCapacity(size);
        m.forEach( (vec) -> vec.ensureCapacity(size));
        //m.replaceAll(operator);
    }

    private int h;
    private int w;
    private Vector<Vector<? extends Number>> data;

    /**
     * Create empty Matrix 
     */
    public Matrix() {
        this.h = 0;
        this.w = 0;

        data = null;
    }

    /**
     * Create Matrix filled with zeros of size h, w
     * @param int h
     * @param int w
     */
    public Matrix(int h, int w) {
        this.h = h;
        this.w = w;


    }

    /**
     * Create a copy of another Matrix
     * @param Matrix other
     */
    public Matrix(Matrix other) {
        this.h = other.h;
        this.w = other.w;
    }

}
