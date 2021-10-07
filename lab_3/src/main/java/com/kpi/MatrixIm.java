package com.kpi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

final public class MatrixIm <T extends Number> implements ProtoMatrix<T> {

    final static public <T extends Number> MatrixIm<T> randomMatrix(Integer h, Integer w) {
        int y = h;
        int x = w;
        
        MatrixIm<T> m = new MatrixIm<>(y, x);
        
        Random rand = new Random();

        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                m.__set(i,j, (T) Integer.valueOf(rand.nextInt(100)));
            }
        }
        
        return m;
    }

    static public <T extends Number> MatrixIm<T> diagonalMatrix(MatrixIm<T> vector) 
    throws IndexOutOfBoundsException {
        
        if(Collections.min(vector.getSize()) != 1) {
            throw new IndexOutOfBoundsException("You should pass a valid vector to this method");
        }
        
        Integer size = Collections.max(vector.getSize()); 

        MatrixIm<T> m = new MatrixIm<>(size, size);

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(i == j) {
                    m.__set(i, j, vector.get(i));
                    continue;
                }
                m.__set(i,j, (T) Integer.valueOf(0));
            }
        }
        
        return m;
    }

    static public <T extends Number> MatrixIm<T> diagonalMatrix(Matrix<T> vector) 
    throws IndexOutOfBoundsException {
        
        if(Collections.min(vector.getSize()) != 1) {
            throw new IndexOutOfBoundsException("You should pass a valid vector to this method");
        }
        
        Integer size = Collections.max(vector.getSize()); 

        MatrixIm<T> m = new MatrixIm<>(size, size);

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(i == j) {
                    m.__set(i, j, vector.get(i));
                    continue;
                }
                m.__set(i,j, (T) Integer.valueOf(0));
            }
        }
        
        return m;
    }

    static public <T extends Number> MatrixIm<T> randomColumnVector(Integer size) {
        int y = size;
        int x = 1;
        
        MatrixIm<T> cv = new MatrixIm<>(y, x);
        
        Random rand = new Random();

        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                cv.__set(i,j, (T) Integer.valueOf(rand.nextInt(100)));
            }
        }
        
        return cv;
    }

    static public <T extends Number> MatrixIm<T> randomRawVector(Integer size) {
        int y = 1;
        int x = size;

        MatrixIm<T> rv = new MatrixIm<>(1, size);
        
        Random rand = new Random();

        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                rv.__set(i,j, (T) Integer.valueOf(rand.nextInt(100)));
            }
        }
        return rv;
    }

    static public <T extends Number> MatrixIm<T> onesMatrix(Integer size) { 
        
        MatrixIm<T> m = new MatrixIm<>(size, size);

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(i == j) {
                    m.__set(i, j, (T) Integer.valueOf(1));
                    continue;
                }
                m.__set(i,j, (T) Integer.valueOf(0));
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
    public MatrixIm() {
        this.h = 0;
        this.w = 0;

        this.data = new ArrayList<ArrayList<T>>();
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

        this.data = new ArrayList<ArrayList<T>>();
        other.getData().forEach( (arr) -> this.data.add((ArrayList<T>) arr.clone())); 
        //Iterator<ArrayList<T>> iter = other.getData().iterator(); 
        // FOR
        //this.data.add((ArrayList<T>) iter.next().clone());
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
    
    private void __set(Integer y, Integer x, T value) {
        this.data.get(y).set(x, value);
    }

    @Override
    public T get(Integer p)
    throws IndexOutOfBoundsException {
        if(this.w == 1) {
            __checkY(p);
            return this.data.get(p).get(this.w-1);
        } else if (this.h == 1) {
            __checkX(p);
            return this.data.get(this.h-1).get(p);
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<ArrayList<T>> getData() {
        return this.data;
    }

    @Override
    public String toString() {
        String tmp = String.join("]\n", this.data.toString().split("],"));
        return String.join("", tmp.split(","));
    }
    
    @Override
    public ArrayList<Integer> getSize() {
        ArrayList<Integer> size = new ArrayList<>(List.of(this.h, this.w));
        return size;
    }
    
    public MatrixIm<T> transponate() {

        MatrixIm<T> tmp = new MatrixIm<>(this.w, this.h);

        for(int i = 0; i < this.w; i++) {
            tmp.data.set(i, this.getColumn(i));
        }

        return tmp; 
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
        MatrixIm<T> other = (MatrixIm<T>) obj;
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
