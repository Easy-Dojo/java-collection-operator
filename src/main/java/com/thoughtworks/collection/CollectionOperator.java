package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {

  private boolean isEven(int num) {
    return num % 2 == 0;
  }

  private boolean isContainedIntArray(int num, int[] arr) {
    List<Integer> list = new ArrayList<>();
    for (int anArr : arr) {
      list.add(anArr);
    }
    return list.contains(num);
  }

  private boolean isContainedIntegerArray(Integer num, Integer[] arr) {
    List<Integer> list = new ArrayList<>(Arrays.asList(arr));
    return list.contains(num);
  }

  //  选出给定区间中所有的数字
  public List<Integer> getListByInterval(int left, int right) {
    Stream<Integer> integerStream = IntStream
        .rangeClosed(smallerOf(left, right), biggerOf(left, right)).boxed();
    return (left < right ? integerStream
        : integerStream.sorted(Comparator.reverseOrder()))
        .collect(Collectors.toList());
  }

  private Integer biggerOf(int left, int right) {
    return right > left ? right : left;
  }

  private Integer smallerOf(int left, int right) {
    return left < right ? left : right;
  }

  //  选出给定区间中所有的偶数
  public List<Integer> getEvenListByIntervals(int left, int right) {
    Stream<Integer> integerStream = IntStream
        .rangeClosed(smallerOf(left, right), biggerOf(left, right)).filter(this::isEven).boxed();
    return (left < right ? integerStream
        : integerStream.sorted(Comparator.reverseOrder()))
        .collect(Collectors.toList());
  }

  //  选出给定区间中所有的偶数
  public List<Integer> popEvenElements(int[] array) {
    return Arrays.stream(array).filter(this::isEven).boxed().collect(Collectors.toList());
  }

  //  弹出集合最后一个元素
  public int popLastElement(int[] array) {
    return array[array.length - 1];
  }

  //  弹出两个集合的交集
  public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
    List<Integer> result = new ArrayList<>();
    for (int num : firstArray) {
      if (isContainedIntArray(num, secondArray)) {
        result.add(num);
      }
    }
    return result;
  }

  public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
    List<Integer> result = new ArrayList<>(Arrays.asList(firstArray));
    for (int num : secondArray) {
      if (!isContainedIntegerArray(num, firstArray)) {
        result.add(num);
      }
    }
    return result;
  }
}
