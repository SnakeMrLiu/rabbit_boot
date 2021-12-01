package com.rabbit.boot.rabbit_boot.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
public class Dish {
    private String name;
    private  boolean vegetarian;
    private int calories;
}
class Demo{
    public static void main(String[] args) {
        System.out.println("asd");
        jdk8();
        lenStream();
        turnUpperCase();
        distinctStream();
        sortStream();
    }
    public static void sortStream() {
        Stream<Integer> sortedStream = Stream.of(1,3,7,4,5,8,6,2).sorted();
        sortedStream.collect(Collectors.toList()).forEach(System.out::print);
        System.out.println("==============");
        Stream<Integer> sortedReverseStreamV2 = Stream.of(1,3,7,4,5,8,6,2).sorted((o1,o2) -> o2 - o1);
        sortedReverseStreamV2.collect(Collectors.toList()).forEach(System.out::print);
    }

    public static void distinctStream() {
        Stream<String> distinctStream = Stream.of("bj","shanghai","tianjin","bj","shanghai").distinct();
        Stream<String> sortedStream = distinctStream.sorted(Comparator.comparing(String::length));
        sortedStream.forEach(System.out::println);
    }



    public static void lenStream() {
        List<String> list = Arrays.asList("java", "scala", "python", "shell", "ruby");
        long num = list.parallelStream().filter(x -> x.length() < 5).count();
        System.out.println(num);
    }

    public static void turnUpperCase() {
        List<String> list = Arrays.asList("a", "b", "c");
        List<String> result = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        result.forEach(x -> System.out.print(x + " "));
        result.forEach(System.out::println);
    }

    private static List<String> jdk8(){
        Dish dish = new Dish("烧茄子", false, 14);
        Dish dish2 = new Dish("火烧", true, 800);
        List<Dish> arr = new ArrayList<>();
        arr.add(dish);
        arr.add(dish2);
        List<String> collect = arr.stream().filter((d) -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        for (String string : collect) {
            System.out.println(string);
        }
        return collect;


    }
}