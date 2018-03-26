package com.thoughtworks.collection;

import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().max(Integer::compare).get();
    }

    public double getMinimum() {
        return arrayList.stream().min(Integer::compare).get();
    }

    public double getAverage() {
        double sum = arrayList.stream().reduce(0, (pre, cur) -> pre + cur);
        return sum/arrayList.size();
    }

    public double getOrderedMedian() {
        double result;
        List<Integer> arr  = arrayList.stream().sorted().collect(Collectors.toList());
        int len = arr.size();
        if (len % 2 == 0) {
            int left = arr.get(len/2-1);
            int right = arr.get(len/2);
            result = (double) (left+right)/2;
        }else {
            result = arr.get((len-1)/2);
        }
        return result;
    }

    public int getFirstEven() {
        return arrayList.stream().filter(num->num%2==0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        int firstEven =  arrayList.stream().filter(num->num%2==0).findFirst().get();
        return arrayList.indexOf(firstEven);
    }

    public boolean isEqual(List<Integer> arrayList) {
        return arrayList.containsAll(this.arrayList) && this.arrayList.containsAll(arrayList);
    }

    public int getLastOdd() {
        List<Integer> oddList =  arrayList.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
        return oddList.get(oddList.size() - 1);
    }

    public int getIndexOfLastOdd() {
        int num = getLastOdd();
        return arrayList.indexOf(num);
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        for(int num : arrayList){
            singleLink.addTailPointer(num);
        }
        int index = arrayList.size()/2;
        if(arrayList.size()%2 == 0) {
            int left = (int) singleLink.getNode(index);
            int right = (int) singleLink.getNode(index + 1);
            return (left + right) / 2.0;
        } else{
            return (Double) singleLink.getNode(index + 1);
        }
    }
}
