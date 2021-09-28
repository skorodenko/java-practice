package com.kpi;

import java.util.ArrayList;

public interface ProtoMatrix <T extends Number> {
    
    /**
     * Get size of a matrix
     * @return Integer
     */
    public ArrayList<Integer> getSize();
    
    
    /**
     * If this and other matrices have are identical
     * Hash codes of this and other may be different
     * @param Object obj
     * @return boolean
     */
    public boolean equals(Object obj);

    
    /**
     * Returns hash code of this Matrix instance
     * @return int
     */
    public int hashCode();

    
    /**
     * Get an item at y, x
     * @param <T> Number
     * @param Integer y
     * @param Integer x
     * @return T Number
     * @throws IndexOutOfBoundsException
     */
    public T get(Integer y, Integer x) 
    throws IndexOutOfBoundsException;
    

    /**
     * Get an item at position p for Vectors
     * @param p
     * @return T
     * @throws IndexOutOfBoundsException
     */
    public T get(Integer p)
    throws IndexOutOfBoundsException;


    /**
     * Get data from Matrix
     * @return ArrayList<ArrayList<T>>
     */
    public ArrayList<ArrayList<T>> getData();

    
    /**
     * Get a row (Vector) at index y
     * @param <T> Number
     * @param Integer y
     * @return ArrayList<T>
     */
    public ArrayList<T> getRow(Integer y)
    throws IndexOutOfBoundsException;
    
    
    /**
     * Get a column (Vector) at index x
     * @param <T> Number
     * @param Integer y
     * @return ArrayList<T>
     */
    public ArrayList<T> getColumn(Integer x)
    throws IndexOutOfBoundsException;
    

    /**
     * Returns string interpretation of Matrix
     * @return String
     */
    public String toString();
}     