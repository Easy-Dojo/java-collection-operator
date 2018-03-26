package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    private String transNumToStr(int num) {
        String result = null;
        if(num>=1&&num<=26){
            return letterList.get(num-1);
        } else if (num > 26) {
            int merchant = num/26;
            int remainder = num%26;
            if(remainder == 0){
                return transNumToStr(merchant-1) + transNumToStr(26);
            }else {
                return transNumToStr(merchant) + transNumToStr(remainder);}
        }
        return result;
    }

    public List<Integer> getTriple() {
        return array.stream().map(num -> num * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(num -> letterList.get(num-1)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream().map(num -> transNumToStr(num)).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
