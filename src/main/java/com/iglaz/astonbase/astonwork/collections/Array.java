package com.iglaz.astonbase.astonwork.collections;

import java.util.Arrays;
import java.util.Collection;

public class Array {
    public static void main(String[] args) {
        CustomArrayList<Integer> intarray = new CustomArrayList(12,5,1,6,7);
        intarray.print();
        intarray.add(5);
        intarray.print();
        Collection<Integer> collection = Arrays.asList(1,2,3,4,5);
        intarray.addall(collection);
        intarray.print();
        intarray.set(5, 0);
        intarray.print();
        System.out.println(intarray.getelement(5));
        intarray.remove(5);
        intarray.print();
        System.out.println(intarray.rezervedlenght());
        intarray.add(5);
        intarray.add(5);
        System.out.println(intarray.rezervedlenght());
        intarray.sort();
        intarray.print();
        intarray.sort(false);
        intarray.print();

        CustomArrayList stringarray = new CustomArrayList<>();
        stringarray.add("first");
        stringarray.add("второй");
        stringarray.add("third");
        stringarray.print();
        stringarray.add("");
        stringarray.print();
        Collection<String> collection2 = Arrays.asList("g","d","r");
        stringarray.addall(collection2);
        stringarray.print();
        stringarray.set("4", 0);
        stringarray.print();
        System.out.println(stringarray.getelement(5));
        stringarray.remove(5);
        stringarray.print();
        System.out.println(stringarray.rezervedlenght());
        stringarray.add("g");
        stringarray.add("r");
        System.out.println(stringarray.rezervedlenght());
        stringarray.sort();
        stringarray.print();
        stringarray.sort(false);
        stringarray.print();
    }
}
