/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CDHouse.model;

import java.io.Serializable;

/**
 *
 * @author Giga P34
 */
public class DynamicArray<T> implements Serializable {
    private T[] array;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean add(T item) {
        if (size == capacity) {
            resize(2 * capacity);
        }
        array[size++] = item;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public T set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T oldItem = array[index];
        array[index] = item;
        return oldItem;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        capacity = newCapacity;
    }

    public boolean shallowCopy(DynamicArray x) {
        this.array = (T[]) x.array;
        this.capacity = x.capacity;
        this.size = x.size;
        return true;
    }
}
