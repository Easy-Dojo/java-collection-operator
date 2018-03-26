package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> result = new ArrayList<>();
        for (Integer[] integers : array) {
            for (Integer integer : integers) {
                result.add(integer);
            }
        }
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> oneDimesionalArray = transformToOneDimesional();
        return oneDimesionalArray.stream().distinct().collect(Collectors.toList());
    }
}
