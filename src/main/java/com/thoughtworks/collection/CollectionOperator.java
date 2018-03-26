package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionOperator {
    private boolean isEven(int num) {
        return num % 2==0 ? true : false;
    }
    private List<Integer> getEvensArray(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            if (isEven(num)) {
                result.add(num);
            }
        }
        return result;
    }
    private boolean isContainedIntArray(int num, int[] arr) {
        List list = new ArrayList<String>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        return list.contains(num);
    }
    private boolean isContainedIntegerArray(Integer num, Integer[] arr) {
        List list = new ArrayList<String>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        return list.contains(num);
    }

    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if (left < right) {
            for (int i = left; i <= right; i++) {
                result.add(i);
            }
        }else {
            for (int i = left; i >= right; i--) {
                result.add(i);
            }
        }
        return result;
    }
    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> listByInterval = getListByInterval(left, right);
        return getEvensArray(listByInterval);
    }
    public List<Integer> popEvenElments(int[] array) {
        List<Integer> result = new ArrayList<>();
        for (int num : array) {
            if (isEven(num)) {
                result.add(num);
            }
        }
        return result;
    }
    public int popLastElment(int[] array) {
        int index = array.length-1;
        return array[index];
    }
    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> result = new ArrayList<>();
        for (int num : firstArray) {
            if(isContainedIntArray(num,secondArray)){
                result.add(num);
            }
        }
        return result;
    }
    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> result = new ArrayList<>(Arrays.asList(firstArray));
        for (int num : secondArray) {
            if (!isContainedIntegerArray(num,firstArray)) {
                result.add(num);
            }
        }
        return result;
    }
}
