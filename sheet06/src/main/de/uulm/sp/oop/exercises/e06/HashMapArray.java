package de.uulm.sp.oop.exercises.e06;

import java.util.HashMap;

public class HashMapArray<T> {

    private HashMap<Integer, T> m_Map;

    public HashMapArray(int size) {
        m_Map = new HashMap<>();
        length = size;
    }

    public void insert(int index, T data) {
        if(index > length) {
            throw new IndexOutOfBoundsException(index);
        }

        m_Map.put(index, data);
    }

    public T get(int index) {
        if(index > length) {
            throw new IndexOutOfBoundsException(index);
        }

        return m_Map.get(index);
    }

    public final int length;
}
