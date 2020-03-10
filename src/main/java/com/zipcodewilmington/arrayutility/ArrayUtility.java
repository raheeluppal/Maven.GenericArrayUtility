package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    private E[] inputArray;

    public ArrayUtility(E[] inputArray) {
        this.inputArray = inputArray;
    }


    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        Integer ctr = 0;

        for (E e : arrayToMerge) {
            if (e.equals(valueToEvaluate)) {
                ctr++;
            }
        }
        for (E e : inputArray) {
            if (e.equals(valueToEvaluate)) {
                ctr++;
            }
        }
        return ctr;
    }


    public E getMostCommonFromMerge(E[] arrayToMerge) {
        HashMap<E, Integer> test = new HashMap<>();

        for (E e : arrayToMerge) {
            if (test.containsKey(e)) {
                test.put(e, test.get(e) + 1);
            } else {
                test.put(e, 1);
            }
        }
        for (E e : inputArray) {
            if (test.containsKey(e)) {
                test.put(e, test.get(e) + 1);
            } else {
                test.put(e, 1);
            }
        }

        return Collections.max(test.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {

        int count = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (valueToEvaluate == inputArray[i])
                count++;
        }
        return count;
    }

    public E[] removeValue(E valueToRemove) {
        E[] test = Arrays.copyOf(inputArray, 0);
        int ctr = 0;

        for (int i = 0; i < inputArray.length; i++) {

            if (inputArray[i] != (valueToRemove)) {
                test = Arrays.copyOf(inputArray, ctr + 1);
                test[ctr] = inputArray[i];
                ctr++;
            }
        }
        ctr = 0;
        E[] result = Arrays.copyOf(inputArray, test.length);

        for (int i = 0; i < inputArray.length; i++) {

            if (inputArray[i] != (valueToRemove)) {

                result[ctr] = inputArray[i];
                ctr++;
            }

        }
        return result;
    }
}
