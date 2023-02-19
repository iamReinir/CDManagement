/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CDHouse.model;

import java.io.Serializable;
import java.util.Comparator;

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

    public boolean remove(T item) {
        int target = -1;
        for (int i = 0; i < size; ++i) {
            if (item == get(i)) {
                target = i;
                break;
            }
        }
        if (target == -1) {
            return false;
        }
        return remove(target);
    }

    public boolean remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; ++i) {
            array[i] = array[i + 1];
        }
        size--;
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

    //A worse version of selection sort
    public void sort(Comparator<T> x) {
        for (int i = 0; i < size - 1; ++i) {
            for (int j = i + 1; j < size; ++j) {
                if (x.compare(get(i), get(j)) > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
