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
     */
    public T get(Integer y, Integer x) 
    throws IndexOutOfBoundsException;

    
    /**
     * Set an item at index y, x with number value 
     * @param <T> Number
     * @param Integer y
     * @param Integer x
     * @param T value
     */
    public void set(Integer y, Integer x, T value) 
    throws IndexOutOfBoundsException;

    
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