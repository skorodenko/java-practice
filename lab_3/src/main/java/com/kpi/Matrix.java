package com.kpi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Matrix<T extends Number> implements ProtoMatrix<T> {

    static public <T extends Number> Matrix<T> onesMatrix(Integer size) { 
        
        Matrix<T> m = new Matrix<>(size, size);

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(i == j) {
                    m.set(i, j, (T) Integer.valueOf(1));
                    continue;
                }
                m.set(i,j, (T) Integer.valueOf(0));
            }
        }
        
        return m;
    }

    private int h;
    private int w;
    private ArrayList<ArrayList<T>> data;

    /**
     * Create empty Matrix 
     */
    public Matrix() {
        this.h = 0;
        this.w = 0;

        data = null;
    }

    /**
     * Create Matrix filled with nulls of size h, w
     * @param int h
     * @param int w
     */
    public Matrix(int h, int w) {
        this.h = h;
        this.w = w;

        this.data = new ArrayList<ArrayList<T>>();
        //this.data = new ArrayList<ArrayList<T>>(IntStream.range(0, h).mapToObj(i -> new ArrayList<String>(Collections.nCopies(this.w, null))).forEach(keys::add));
        //this.data = new ArrayList<ArrayList<T>>(Collections.nCopies(this.h, new ArrayList<T>(Collections.nCopies(this.w, null))));
        for(int i = 0; i < this.h; i++) {
            this.data.add(new ArrayList<T>(Collections.nCopies(this.w, (T) Integer.valueOf(0))));
        }
    }

    /**
     * Create a copy of another Matrix
     * @param Matrix other
     */
    public Matrix(Matrix<T> other) {
        this.h = other.h;
        this.w = other.w;

        this.data = other.data;
    }

    @Override
    public ArrayList<T> getRow(Integer y) 
    throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public ArrayList<T> getColumn(Integer x)
    throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public ArrayList<Integer> getSize() {
        ArrayList<Integer> size = new ArrayList<>(List.of(this.h, this.w));
        return size;
    }

    @Override
    public void set(Integer y, Integer x, T value) 
    throws IndexOutOfBoundsException {
        if(x > this.w - 1) {
            throw new IndexOutOfBoundsException("x index " + x + " is out of range");
        } if(x < 0) {
            throw new IndexOutOfBoundsException("x index " + x + " is out of range");
        } if(y > this.h - 1) {
            throw new IndexOutOfBoundsException("y index " + y + " is out of range");
        } if(y < 0) {
            throw new IndexOutOfBoundsException("y index " + y + " is out of range");
        }
        
        this.data.get(y).set(x, value);
    }
    
    @Override
    public T get(Integer y, Integer x)
    throws IndexOutOfBoundsException {
        if(x > this.w - 1) {
            throw new IndexOutOfBoundsException("x index " + x + " is out of range");
        } if(x < 0) {
            throw new IndexOutOfBoundsException("x index " + x + " is out of range");
        } if(y > this.h - 1) {
            throw new IndexOutOfBoundsException("y index " + y + " is out of range");
        } if(y < 0) {
            throw new IndexOutOfBoundsException("y index " + y + " is out of range");
        }

        return this.data.get(y).get(x);
    }

    @Override
    public String toString() {
        return String.join("]\n", this.data.toString().split("],"));
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
        Matrix<T> other = (Matrix<T>) obj;
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
