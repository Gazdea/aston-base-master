package com.iglaz.astonbase.astonwork.collections;

public class Array {
    public static void main(String[] args) {
        CustomArrayList array = new CustomArrayList(12,5,1,6,7);
        array.print();
        
        array.add(5);
        array.print();
        
        int[] list = {5,4,3,2,1};
        array.addall(list);
        array.print();

        array.set(5, 0);
        array.print();
        
        System.out.println(array.get(5));

        array.remove(5);
        array.print();

        System.out.println(array.rezervedlenght());

        array.add(5);
        array.add(5);
        System.out.println(array.rezervedlenght());

        array.sort();
        array.print();

        array.sort(false);
        array.print();
    }
}
