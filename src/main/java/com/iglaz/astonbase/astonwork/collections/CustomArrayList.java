package com.iglaz.astonbase.astonwork.collections;
import java.util.Arrays;

public class CustomArrayList {
    private int[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    //Вывод
    public void print(){
        for (int i = 0; i <= size - 1 ; i++){
            System.out.print(elements[i] + ", ");
        }
        System.out.println();
    }
    //Конструктор без параметров
    public CustomArrayList() {
        elements = new int[DEFAULT_CAPACITY];
    }

    //Конструктор с пеараметрами
    public CustomArrayList(int... elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
        size = this.elements.length;
    }
    
    //Добавить элемент
    public void add(int element) {
        if (size >= elements.length) {   
            resize();
        }
        elements[size++] = element;
    }

    //Добавить несколько элементов
    public void addall(int[] elements){
        int newSize = size + elements.length;
        this.elements = Arrays.copyOf(this.elements, newSize);
        System.arraycopy(elements, 0, this.elements, size, elements.length);
        size = newSize;
    }

    //Получить колличество элементов
    public int length() {
        return size;
    }

    //Получить количество зарезервированных элементов
    public int rezervedlenght() {
        return elements.length;
    }

    //сеттер
    public void set(int element, int index) {
        if (index >= size || index < 0) {
            System.err.println("Index: " + index + ", Size: " + size);
            return;
        }
        this.elements[index] = element;
    }

    //геттер
    public int get(int index) {
        if (index >= size || index < 0) {
            System.err.println("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    //Удалить элемент
    public void remove(int index) {
        if (index >= size || index < 0) {
            System.err.println("Index: " + index + ", Size: " + size);
            return;
        }
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = 0; // Уменьшаем размер и обнуляем последний элемент
    }

    //изначальный параметр для sort
    public void sort() {
        sort(true);
    }
    //Сортировка пузырьком с флагом
    public void sort(boolean reversed) {
        for (int i = 0; i <= size; i++) {
            boolean flag = false;
            for (int j = 0; j < size - i - 1; j++) {
                if ((elements[j] > elements[j+1] && reversed) || (elements[j] < elements[j+1] && !reversed)) {
                    int temp = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    //Обновление размера
     private void resize() {
        int newSize = elements.length / 2 + elements.length;
        elements = Arrays.copyOf(elements, newSize);
    }
}