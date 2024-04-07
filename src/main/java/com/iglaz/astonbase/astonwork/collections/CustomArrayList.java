package com.iglaz.astonbase.astonwork.collections;

import java.util.Arrays;
import java.util.Collection;
public class CustomArrayList<T extends Comparable<T>> {
    private T[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    // Вывод
    public void print() {
        for (int i = 0; i <= size - 1; i++) {
            System.out.print(elements[i] + ", ");
        }
        System.out.println();
    }

    // Конструктор с параметром колекции
    public CustomArrayList(Collection<T> collection) {
        elements = collection.toArray((T[]) new Comparable[collection.size()]);
        size = collection.size();
    }

    // Конструктор без параметров
    public CustomArrayList() {
        elements = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    // Конструктор с параметрами
    public CustomArrayList(T... elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
        size = this.elements.length;
    }

    // Добавить элемент
    public void add(T element) {
        if (size >= elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    // Добавить колекцию
    public void addAll(Collection<T> collection) {
        int newSize = size + collection.size();
        T[] newArray = Arrays.copyOf(this.elements, newSize);

        int index = size;
        for (T element : collection) {
            newArray[index++] = element;
        }

        this.elements = newArray;
        size = newSize;
    }

    // Добавить несколько элементов
    public void addAll(T... elements) {
        int newSize = size + elements.length;
        T[] newArray = Arrays.copyOf(this.elements, newSize);

        int index = size;
        for (T element : elements) {
            newArray[index++] = element;
        }

        this.elements = newArray;
        size = newSize;
    }

    // Получить колличество элементов
    public int size() {
        return size;
    }

    // Получить количество зарезервированных элементов
    public int rezervedLenght() {
        return elements.length;
    }

    // сеттер
    public void set(T element, int index) {
        if (index >= size || index < 0) {
            System.err.println("Index: " + index + ", Size: " + size);
            return;
        }
        this.elements[index] = element;
    }

    // геттер элементов
    public T[] getElements() {
        return elements;
    }

    // геттер элемента
    public T getElement(int index) {
        if (index >= size || index < 0) {
            System.err.println("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    // Удалить элемент
    public void remove(int index) {
        if (index >= size || index < 0) {
            System.err.println("Index: " + index + ", Size: " + size);
            return;
        }
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Уменьшаем размер и обнуляем последний элемент
    }

    // изначальный параметр для sort
    public void sort() {
        sort(true);
    }

    // Сортировка пузырьком с флагом
    public void sort(boolean reversed) {
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < size - i - 1; j++) {
                if ((elements[j]).compareTo(elements[j + 1]) > 0 && reversed
                        || (elements[j]).compareTo(elements[j + 1]) < 0 && !reversed) {
                    T temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    // изначальный параметр для sort
    public static <T extends Comparable<T>> void sort(Collection<T> elements) {
        sort(elements, true);
    }

    // Сортировка пузырьком с флагом статическая 
    public static <T extends Comparable<? super T>> void sort(Collection<T> elements, boolean reversed) {
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable) elements.toArray()[j]).compareTo(elements.toArray()[j + 1]) > 0 && reversed
                        || (((Comparable) elements.toArray()[j]).compareTo(elements.toArray()[j + 1]) < 0 && !reversed)) {
                    T temp = (T) elements.toArray()[j];
                    elements.toArray()[j] = elements.toArray()[j + 1];
                    elements.toArray()[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
    
    // Обновление размера
    private void resize() {
        int newSize = elements.length / 2 + elements.length;
        elements = Arrays.copyOf(elements, newSize);
    }
}