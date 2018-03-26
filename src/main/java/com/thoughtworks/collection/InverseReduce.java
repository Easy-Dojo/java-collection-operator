package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        int randomNumber = random.nextInt(3);
        List<Integer> result = new ArrayList<>();
        for (int i = number-randomNumber; i >= 0; i-=randomNumber) {
            result.add(i);
        }
        return result;
    }
}
