package com.thoughtworks.collection;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    private boolean isEven(int num){
        return num % 2 == 0 ? true : false;
    }
    private boolean isTripleNum(int num){
        return num % 3 == 0 ? true : false;
    }


    public List<Integer> filterEven() {
        List<Integer> result = array.stream().filter( num -> isEven(num)).collect(Collectors.toList());
        return result;
    }

    public List<Integer> filterMultipleOfThree() {
        return array.stream().filter( num -> isTripleNum(num)).collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        return firstList.stream().filter(num->secondList.contains(num)).collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        return array.stream().distinct().collect(Collectors.toList());
    }
}