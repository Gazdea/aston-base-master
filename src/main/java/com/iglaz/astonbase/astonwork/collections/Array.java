package com.iglaz.astonbase.astonwork.collections;

import java.util.Arrays;
import java.util.Collection;

import com.iglaz.astonbase.lesson4.CollectionsDemo;

import java.util.ArrayList;

public class Array {
    public static void main(String[] args) {
        CustomArrayList<Integer> intarray = new CustomArrayList(12,5,1,6,7);
        intarray.print();
        intarray.add(5);
        intarray.print();
        Collection<Integer> collection = Arrays.asList(1,2,3,4,5);
        intarray.addAll(collection);
        intarray.print();
        intarray.set(5, 0);
        intarray.print();
        System.out.println(intarray.getelement(5));
        intarray.remove(5);
        intarray.print();
        System.out.println(intarray.rezervedLenght());
        intarray.add(5);
        intarray.add(5);
        System.out.println(intarray.rezervedLenght());
        intarray.sort();
        intarray.print();
        intarray.sort(false);
        intarray.print();

        CustomArrayList stringarray = new CustomArrayList<>();
        stringarray.add("first");
        stringarray.add("второй");
        stringarray.add("third");
        stringarray.print();
        stringarray.add("f");
        stringarray.print();
        Collection<String> collection2 = Arrays.asList("g","d","r");
        stringarray.addAll(collection2);
        stringarray.print();
        stringarray.set("4", 0);
        stringarray.print();
        System.out.println(stringarray.getelement(5));
        stringarray.remove(5);
        stringarray.print();
        System.out.println(stringarray.rezervedLenght());
        stringarray.add("g");
        stringarray.add("r");
        System.out.println(stringarray.rezervedLenght());
        stringarray.sort();
        stringarray.print();
        stringarray.sort(false);
        stringarray.print();
        CustomArrayList intarray3 = new CustomArrayList<>(new Integer[]{1,2,3,4,5});
        intarray3.print();

        
        //intarray2.sort(intarray2, false);
    }
}
