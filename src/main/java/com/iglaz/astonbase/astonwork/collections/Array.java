package com.iglaz.astonbase.astonwork.collections;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {

        CustomArrayList<Integer> intarray = new CustomArrayList(new Integer[]{1,2,3,4,5});
        Integer[] array = {5,4,3,2,1};
        intarray.addAll(array);
        intarray.print();
        intarray.add(5);
        intarray.print();
        Integer[] array2 = {1,2,3,4,5};
        intarray.addAll(array2);
        intarray.print();
        intarray.set(5, 0);
        intarray.print();
        System.out.println(intarray.getElement(5));
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
        stringarray.addAll(new String[]{"5", "4", "3", "2", "1"});
        stringarray.print();
        stringarray.set("4", 0);
        stringarray.print();
        System.out.println(stringarray.getElement(5));
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
        System.out.println(intarray3.size());
        
        String[] strings = {"first", "второй", "third"};
        CustomArrayList.sort(Arrays.asList(strings), true);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
