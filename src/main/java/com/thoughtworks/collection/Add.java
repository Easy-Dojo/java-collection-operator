package com.thoughtworks.collection;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Add {

  private static final int DILATANCY_NUMBER = 1;

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
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < arr.size(); i++) {
      if (i % 2 == 0) {
        result.add(arr.get(i));
      }
    }
    return result;
  }

  private List<Integer> getEvensArray(List<Integer> arr) {
    List<Integer> result = new ArrayList<>();
    for (int sum : arr) {
      if (isEven(sum)) {
        result.add(sum);
      }
    }
    return result;
  }

  private List<Integer> getOddsArray(List<Integer> arr) {
    List<Integer> result = new ArrayList<>();
    for (int sum : arr) {
      if (isOdd(sum)) {
        result.add(sum);
      }
    }
    return result;
  }

  private int getMedianOfArray(List<Integer> arr) {
    int result;
    Collections.sort(arr);
    int len = arr.size();
    if (len % 2 == 0) {
      int left = arr.get(len / 2);
      int right = arr.get(left + 1);
      result = (left + right) / 2;
    } else {
      result = arr.get((len - 1) / 2);
    }
    return result;
  }

  private List<Integer> deDuplication(List<Integer> arr) {
    List<Integer> result = new ArrayList<>();
    for (int num : arr) {
      if (!result.contains(num)) {
        result.add(num);
      }
    }
    return result;
  }

  private List<Integer> ascSortArray(List<Integer> arr) {
    Collections.sort(arr);
    return arr;
  }

  private List<Integer> descSortArray(List<Integer> arr) {
    Collections.sort(arr, Comparator.reverseOrder());
    return arr;
  }

  private Integer getSum(int leftBorder, int rightBorder, IntPredicate operator) {
    IntStream intStream = IntStream.range(smallerBetween(leftBorder, rightBorder),
        biggerBetween(leftBorder, rightBorder) + DILATANCY_NUMBER);
    return intStream.filter(operator).reduce(0, this::addTwoNum);
  }

  //  求leftBorder到rightBorder之间的偶数和
  public int getSumOfEvens(int leftBorder, int rightBorder) {
    return getSum(leftBorder, rightBorder, this::isEven);
  }

  //  求leftBorder到rightBorder之间的基数和
  public int getSumOfOdds(int leftBorder, int rightBorder) {
    return getSum(leftBorder, rightBorder, this::isOdd);
  }

  public int getSumTripleAndAddTwo(List<Integer> arrayList) {
    int result = 0;
    for (int num : arrayList) {
      result += multipliedByThreeAndAddedTwo(num);
    }
    return result;
  }

  public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
    List<Integer> result = new ArrayList<>();
    for (int num : arrayList) {
      if (isOdd(num)) {
        result.add(multipliedByThreeAndAddedTwo(num));
      } else {
        result.add(num);
      }
    }
    return result;
  }

  public int getSumOfProcessedOdds(List<Integer> arrayList) {
    int result = 0;
    for (int num : arrayList) {
      if (isOdd(num)) {
        result += multipliedByThreeAndAddedFive(num);
      }
    }
    return result;
  }

  public List<Integer> getProcessedList(List<Integer> arrayList) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < arrayList.size() - 1; i++) {
      int curNum = arrayList.get(i);
      int nexNum = arrayList.get(i + 1);
      int sum = addTwoNum(multipliedByThree(curNum), multipliedByThree(nexNum));
      result.add(sum);
    }
    return result;
  }

  public double getMedianOfEvenIndex(List<Integer> arrayList) {
    List<Integer> evenIndexArray = getEvenIndexArray(arrayList);
    return (double) getMedianOfArray(evenIndexArray);
  }

  public double getAverageOfEvenIndex(List<Integer> arrayList) {
    List<Integer> evenIndexArray = getEvenIndexArray(arrayList);
    int sum = 0;
    int count = evenIndexArray.size();
    for (int num : evenIndexArray) {
      sum += num;
    }
    return sum / count;
  }

  public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElement) {
    List<Integer> evenIndexArray = getEvensArray(arrayList);
    return evenIndexArray.contains(specialElement);
  }

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
