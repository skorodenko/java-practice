package com.kpi;

public interface ProtoMutMatrix <T extends Number> {
    
    /**
     * Set an item at index y, x with number value }
     * @param <T> Number
     * @param Integer y
     * @param Integer x
     * @param T value
     */
    public void set(Integer y, Integer x, T value) 
    throws IndexOutOfBoundsException;
}