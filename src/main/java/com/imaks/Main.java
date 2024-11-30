package com.imaks;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayUtils arrayUtils = new ArrayUtils();
        int[] array = {12, 11, 13, 5, 6, 7, 34, 54, 24, 39, 90, 100, 91, 82, 45};

        System.out.println("До сортування: " + Arrays.toString(array));

        arrayUtils.mergeSort(array);

        System.out.println("Після сортування: " + Arrays.toString(array));

        arrayUtils.binarySearch(array, 24);
        arrayUtils.binarySearch(array, 0);
    }
}