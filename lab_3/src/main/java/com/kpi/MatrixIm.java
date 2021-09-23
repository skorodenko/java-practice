package com.kpi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixIm <T extends Number> implements ProtoMatrix<T> {

    private int h;
    private int w;
    private ArrayList<ArrayList<T>> data;

    /**
     * Create empty Matrix 
     */
    public MatrixIm() {
        this.h = 0;
        this.w = 0;

        data = null;
    }

    /**
     * Create Matrix filled with nulls of size h, w
     * @param int h
     * @param int w
     */
    public MatrixIm(int h, int w) {
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
    public MatrixIm(Matrix<T> other) {
        ArrayList<Integer> coords = other.getSize();
        this.h = coords.get(0);
        this.w = coords.get(1);

        this.data = other.getData();
    }

    /**
     * Create a copy of another MatrixIm
     * @param Matrix other
     */
    public MatrixIm(MatrixIm<T> other) {
        ArrayList<Integer> coords = other.getSize();
        this.h = coords.get(0);
        this.w = coords.get(1);

        this.data = other.getData();
    }

    private void __checkX(Integer x)
    throws IndexOutOfBoundsException {
        if(x > this.w - 1) {
            throw new IndexOutOfBoundsException("x index " + x + " is out of range");
        } if(x < 0) {
            throw new IndexOutOfBoundsException("x index " + x + " is out of range");
        }       
    }

    private void __checkY(Integer y)
    throws IndexOutOfBoundsException {
        if(y > this.h - 1) {
            throw new IndexOutOfBoundsException("y index " + y + " is out of range");
        } if(y < 0) {
            throw new IndexOutOfBoundsException("y index " + y + " is out of range");
        }
    }

    @Override
    public ArrayList<T> getRow(Integer y) 
    throws IndexOutOfBoundsException {
        __checkY(y);

        return this.data.get(y);
    }

    @Override
    public ArrayList<T> getColumn(Integer x)
    throws IndexOutOfBoundsException {
        __checkX(x);

        ArrayList<T> column = new ArrayList<>();
        
        for(int i = 0; i < this.h; i++) {
            column.add(this.get(i, x));
        }

        return column;
    }

    @Override
    public T get(Integer y, Integer x)
    throws IndexOutOfBoundsException {
        __checkY(y);
        __checkX(x);

        return this.data.get(y).get(x);
    }

    @Override
    public ArrayList<ArrayList<T>> getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return String.join("]\n", this.data.toString().split("],"));
    }
    
    @Override
    public ArrayList<Integer> getSize() {
        ArrayList<Integer> size = new ArrayList<>(List.of(this.h, this.w));
        return size;
    }
}
