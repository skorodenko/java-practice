package com.kpi;

import java.util.Vector;

public interface ProtoMatrix {
    
    /**
     * Get size of a matrix
     * @return Integer
     */
    public Integer getSize();
    
    
    /**
     * If this and other matrices have are identical
     * Hash codes of this and other may be different
     * @param Matrix other
     * @return boolean
     */
    public boolean equals(Matrix other);

    
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
    public <T extends Number> T get(Integer y, Integer x);

    
    /**
     * Set an item at index y, x with number value 
     * @param <T> Number
     * @param Integer y
     * @param Integer x
     * @param T value
     */
    public <T extends Number> void set(Integer y, Integer x, T value);

    
    /**
     * Get a row (Vector) at index y
     * @param <T> Number
     * @param Integer y
     * @return Vector<T>
     */
    public <T extends Number> Vector<T> getRow(Integer y);
    
    
    /**
     * Get a column (Vector) at index x
     * @param <T> Number
     * @param Integer y
     * @return Vector<T>
     */
    public <T extends Number> Vector<T> getColumn(Integer x);
    
}     