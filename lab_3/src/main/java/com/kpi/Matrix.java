package com.kpi;

import java.util.ArrayList;

public class Matrix implements ProtoMatrix {
 
    static public <T extends Number> ArrayList<ArrayList<T>> onesMatrix(Integer size) { 
        ArrayList<ArrayList<T>> m = new ArrayList<ArrayList<T>>();
        m.ensureCapacity(size);
        m.forEach( (vec) -> vec.ensureCapacity(size) );
        
        return m;
    }

    private int h;
    private int w;
    private ArrayList<ArrayList<? extends Number>> data;

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

    @Override
    public <T extends Number> ArrayList<T> getRow(Integer y) 
    throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public <T extends Number> ArrayList<T> getColumn(Integer x)
    throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public int[] getSize() {
        return null;
    }

    @Override
    public <T extends Number> void set(Integer y, Integer x, T value)
    throws IndexOutOfBoundsException {

    }
    
    @Override
    public <T extends Number> T get(Integer y, Integer x)
    throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + h;
        result = prime * result + w;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Matrix other = (Matrix) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (h != other.h)
            return false;
        if (w != other.w)
            return false;
        return true;
    }
}
