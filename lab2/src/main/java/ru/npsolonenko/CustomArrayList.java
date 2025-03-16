package ru.npsolonenko;

public class CustomArrayList {
    private int[] array;
    private int size;

    public CustomArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        }
        this.array = new int[initialCapacity];
        this.size = 0;
    }

    public void addToEnd(int element) {
        ensureCapacity();
        array[size] = element;
        ++size;
    }

    public void addAtIndex(int element, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        ++size;
    }

    public int getByIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        return array[index];
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            int[] newArray = new int[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; ++i) {
            sb.append(array[i]);
            if (i < size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList(15);
        list.size();
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        System.out.println("The list: " + list);

        list.addAtIndex(10, 1);
        System.out.println("After insert by index 1: " + list);

        int element = list.getByIndex(2);
        System.out.println("The elem by index 2: " + element);

    }
}
