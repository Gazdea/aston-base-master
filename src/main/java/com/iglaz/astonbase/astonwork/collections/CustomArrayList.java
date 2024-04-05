package com.iglaz.astonbase.astonwork.collections;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;

public class CustomArrayList<T extends Comparable<T>> {
    private T[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    //Вывод
    public void print(){
        for (int i = 0; i <= size - 1 ; i++){
            System.out.print(elements[i] + ", ");
        }
        System.out.println();
    }
    //Конструктор с параметром колекции
    public CustomArrayList(CustomArrayList<T> collection) {
        this.elements = collection.elements;
        this.size = collection.size;
    }
    
    //Конструктор без параметров
    public CustomArrayList() {
       elements = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    //Конструктор с параметрами
    public CustomArrayList(T... elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
        size = this.elements.length;
    }
    
    //Добавить элемент
    public void add(T element) {
        if (size >= elements.length) {   
            resize();
        }
        elements[size++] = element;
    }

    //Добавить несколько элементов
    public void addall(Collection<T> elements){
        int newSize = size + elements.size();
        T[] newArray = Arrays.copyOf(this.elements, newSize);
        
        int index = size;
        for (T element : elements) {
            newArray[index++] = element;
        }
        
        this.elements = newArray;
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
    public void set(T element, int index) {
        if (index >= size || index < 0) {
            System.err.println("Index: " + index + ", Size: " + size);
            return;
        }
        this.elements[index] = element;
    }

    //геттер элементов
    public T[] getelements() {
        return elements;
    }

    //геттер элемента
    public T getelement(int index) {
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
        elements[--size] = null; // Уменьшаем размер и обнуляем последний элемент
    }

    //изначальный параметр для sort
    public void sort() {
        sort(true);
    }
    //Сортировка пузырьком с флагом
    public void sort(boolean reversed) {
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < size - i - 1; j++) {
                if ((elements[j].compareTo(elements[j + 1]) > 0 && reversed) || (elements[j].compareTo(elements[j + 1]) < 0 && !reversed)) {
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
    
    ////Статический метод сортировки
    //public static <T extends Comparable<? super T>> void sort(Collection<T> collection, boolean reversed) {
    //    List<T> list = new ArrayList<>(collection);
    //    
    //    int size = list.size();
    //    for (int i = 0; i < size; i++) {
    //        boolean flag = false;
    //        for (int j = 0; j < size - i - 1; j++) {
    //            if ((list.get(j).compareTo(list.get(j + 1)) > 0 && reversed) || (list.get(j).compareTo(list.get(j + 1)) < 0 && !reversed)) {
    //                T temp = list.get(j);
    //                list.set(j, list.get(j + 1));
    //                list.set(j + 1, temp);
    //                flag = true;
    //            }
    //        }
    //        if (!flag) {
    //            break;
    //        }
    //    }
    //    
    //    collection.clear();
    //    collection.addAll(list);
    //}

    //Обновление размера
     private void resize() {
        int newSize = elements.length / 2 + elements.length;
        elements = Arrays.copyOf(elements, newSize);
    }
}