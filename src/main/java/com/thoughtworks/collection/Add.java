package com.thoughtworks.collection;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {

  private int smallerBetween(int leftBorder, int rightBorder) {
    return leftBorder < rightBorder ? leftBorder : rightBorder;
  }

  private int biggerBetween(int leftBorder, int rightBorder) {
    return leftBorder > rightBorder ? leftBorder : rightBorder;
  }

  private int multipliedByThreeAndAddedTwo(int num) {
    return num * 3 + 2;
  }

  private int multipliedByThreeAndAddedFive(int num) {
    return num * 3 + 5;
  }

  private int multipliedByThree(int num) {
    return num * 3;
  }

  private int addTwoNum(int num1, int num2) {
    return num1 + num2;
  }

  private boolean isOdd(int num) {
    return num % 2 != 0;
  }

  private boolean isEven(int num) {
    return num % 2 == 0;
  }

  private List<Integer> getEvenIndexArray(List<Integer> arr) {
    return arr.stream().filter(item -> this.isEven(arr.indexOf(item))).collect(Collectors.toList());
  }

  private List<Integer> getEvensArray(List<Integer> arr) {
    return arr.stream().filter(this::isEven).collect(Collectors.toList());
  }

  private List<Integer> getOddsArray(List<Integer> arr) {
    return arr.stream().filter(this::isOdd).collect(Collectors.toList());
  }

  private Integer getMedianOfArray(List<Integer> arr) {
    List<Integer> ascSortedArray = ascSortArray(arr);
    int len = ascSortedArray.size();
    return isEven(len) ?
        (ascSortedArray.get(len / 2) + ascSortedArray.get(ascSortedArray.get(len / 2) + 1)) / 2
        : ascSortedArray.get((len - 1) / 2);
  }

  private List<Integer> deDuplication(List<Integer> arr) {
    Set<Integer> collectionWithoutDuplicates = new HashSet<>(arr);
    return new ArrayList<>(collectionWithoutDuplicates);
  }

  private List<Integer> ascSortArray(List<Integer> arr) {
    return arr.stream().sorted().collect(Collectors.toList());
  }

  private List<Integer> descSortArray(List<Integer> arr) {
    return arr.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
  }

  private Integer getSum(int leftBorder, int rightBorder, IntPredicate operator) {
    IntStream intStream = IntStream.rangeClosed(smallerBetween(leftBorder, rightBorder),
        biggerBetween(leftBorder, rightBorder));
    return intStream.filter(operator).reduce(0, this::addTwoNum);
  }

  //  ???leftBorder???rightBorder??????????????????
  public int getSumOfEvens(int leftBorder, int rightBorder) {
    return getSum(leftBorder, rightBorder, this::isEven);
  }

  //  ???leftBorder???rightBorder??????????????????
  public int getSumOfOdds(int leftBorder, int rightBorder) {
    return getSum(leftBorder, rightBorder, this::isOdd);
  }

  //  ???????????????????????????????????????????????????
  public int getSumTripleAndAddTwo(List<Integer> arrayList) {
    return arrayList.stream().mapToInt(this::multipliedByThreeAndAddedTwo)
        .reduce(0, this::addTwoNum);
  }

  //  ???????????????????????????3??????2??????????????????????????????
  public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
    return arrayList.stream().map(item -> isOdd(item) ? Integer.valueOf(item * 3 + 2) : item)
        .collect(Collectors.toList());
  }

  //  ???????????????????????????3??????5??????
  public int getSumOfProcessedOdds(List<Integer> arrayList) {
    return arrayList.stream().filter(this::isOdd).mapToInt(this::multipliedByThreeAndAddedFive)
        .reduce(0, this::addTwoNum);
  }

  // ???????????????????????????????????????????????????3????????????
  public List<Integer> getProcessedList(List<Integer> arrayList) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < arrayList.size() - 1; i++) {
      int curNum = arrayList.get(i), nexNum = arrayList.get(i + 1);
      result.add(addTwoNum(multipliedByThree(curNum), multipliedByThree(nexNum)));
    }
    return result;
  }

  //  ???????????????????????????????????????????????????
  public double getMedianOfEvenIndex(List<Integer> arrayList) {
    List<Integer> evenIndexArray = getEvenIndexArray(arrayList);
    return (double) getMedianOfArray(evenIndexArray);
  }

  //  ????????????????????????????????????
  public double getAverageOfEvenIndex(List<Integer> arrayList) {
    List<Integer> evenIndexArray = getEvenIndexArray(arrayList);
    return evenIndexArray.stream().collect(Collectors.averagingInt(item -> item));
  }

  //  ??????????????????????????????????????????????????????????????????specialElment
  public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElement) {
    List<Integer> evenIndexArray = getEvensArray(arrayList);
    return evenIndexArray.contains(specialElement);
  }

  //  ??????????????????????????????????????????????????????
  public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
    List<Integer> evensArray = getEvensArray(arrayList);
    return deDuplication(evensArray);
  }

  public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
    List<Integer> result = new ArrayList<>();
    List<Integer> evensArray = getEvensArray(arrayList);
    List<Integer> oddsArray = getOddsArray(arrayList);
    List<Integer> ascSortedEvenArray = ascSortArray(evensArray);
    List<Integer> descSortedOddArray = descSortArray(oddsArray);
    result.addAll(ascSortedEvenArray);
    result.addAll(descSortedOddArray);
    return result;
  }

}
