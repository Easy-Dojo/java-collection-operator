package com.thoughtworks.collection;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    Filter(List<Integer> array) {
     this.array = array;
    }

    private boolean isEven(int num){
        return num % 2 == 0;
    }
    private boolean isTripleNum(int num){
        return num % 3 == 0;
    }


    public List<Integer> filterEven() {
      return array.stream().filter(this::isEven).collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return array.stream().filter(this::isTripleNum).collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        return firstList.stream().filter(secondList::contains).collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        return array.stream().distinct().collect(Collectors.toList());
    }
}