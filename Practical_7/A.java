package Practical_7;

import java.util.Arrays;

public class A {
    public static void main(String[] args) {
        // Create an instance of MyArray
        MyArray<Integer> myArray = new MyArray<>();

        // Add elements to the array
        myArray.add(10);
        myArray.add(20);
        myArray.add(30);

        // Display the array
        System.out.println("Array elements:");
        for (int i = 0; i < myArray.size; i++) {
            System.out.println(myArray.get(i));
        }

        // Swap elements at indices 0 and 2
        myArray.swap(0, 2);

        // Display the modified array
        System.out.println("\nArray elements after swap:");
        for (int i = 0; i < myArray.size; i++) {
            System.out.println(myArray.get(i));
        }
    }
}

class MyArray<T> {
    int size;
    private int capacity;
    private Object[] array;

    public MyArray() {
        this.size = 0;
        this.capacity = 4;
        this.array = new Object[capacity];
    }

    public void add(T element) {
        if (size == capacity) {
            grow();
        }
        array[size] = element;
        size++;
    }

    private void grow() {
        capacity = (int) (capacity * 1.5);
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return (T) array[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        array[index] = element;
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "size=" + size +
                ", capacity=" + capacity +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
