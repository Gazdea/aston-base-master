package com.iglaz.astonbase.astonwork.streams;

import java.util.Arrays;
import java.util.List;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000), 
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        System.out.println("1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).");

        List<Transaction> transactions2011  = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((t1, t2) -> t1.getValue() - t2.getValue())
                .toList();
        transactions2011.forEach(System.out::println);

        //2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        System.out.println("2. Вывести список неповторяющихся городов, в которых работают трейдеры.");

        List<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .toList();
        cities.forEach(System.out::println);

        //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        System.out.println("3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        
        List<String> names = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader().getName())
                .sorted()
                .toList();
        names.forEach(System.out::println);

        //4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        System.out.println("4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.");
        
        List<String> names2 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .toList();
        names2.forEach(System.out::println);

        //5. Выяснить, существует ли хоть один трейдер из Милана.
        System.out.println("5. Выяснить, существует ли хоть один трейдер из Милана.");
        
        Boolean names3 = transactions.stream()
                .map(t -> t.getTrader().getCity().equals("Milan"))
                .anyMatch(t -> t);
        System.out.println(names3);

        //6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        System.out.println("6. Вывести суммы всех транзакций трейдеров из Кембриджа.");

        int sum = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .mapToInt(t -> t.getValue())
                .sum();
        System.out.println(sum);
                
        //7. Какова максимальная сумма среди всех транзакций?
        System.out.println("7. Какова максимальная сумма среди всех транзакций?");

        int max = transactions.stream()
                .mapToInt(t -> t.getValue())
                .max()
                .getAsInt();
        System.out.println(max);

        //8. Найти транзакцию с минимальной суммой.
        System.out.println("8. Найти транзакцию с минимальной суммой.");
        
        int min = transactions.stream()
                .mapToInt(t -> t.getValue())
                .min()
                .getAsInt();
        System.out.println(min);
    }
}
