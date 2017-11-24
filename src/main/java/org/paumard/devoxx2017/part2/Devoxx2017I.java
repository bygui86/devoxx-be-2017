package org.paumard.devoxx2017.part2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Devoxx2017I {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");

        List<Integer> lengths1 =
                strings.stream()
                        .map(String::length)
                        .filter(length -> length > 3)
                        .collect(toList());
        System.out.println("lengths1 = " + lengths1);

        Collector<String, ?, List<Integer>> collector =
                Collectors.mapping(
                        String::length,
                        Collectors.filtering(
                                length -> length > 3,
                                toList()
                        )
                );

        List<Integer> lengths2 =
                strings.stream()
                        .collect(
                                collector
                        );
        System.out.println("lengths2 = " + lengths2);

        Collector<String, ?, Stream<Integer>> mapping = null;
        Collector<Integer, ?, Stream<Integer>> filtering = null;

        List<Integer> lengths3 =
        strings.stream()
                .collect(mapping)
                .collect(filtering)
                .collect(toList());
    }
}
