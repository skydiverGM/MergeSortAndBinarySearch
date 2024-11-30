package com.imaks;

import java.util.Arrays;

public class ArrayUtils {
    public <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length <= 1) {
            System.out.println("Base case worked out.");
            return;
        }
        int middle = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, middle);
        T[] right = Arrays.copyOfRange(array, middle, array.length);//to – the final index of the range to be copied, exclusive. (This index may lie outside the array.)

        System.out.println("Ділимо: " + Arrays.toString(array) + " -> " +
                Arrays.toString(left) + " | " + Arrays.toString(right));

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);

        System.out.println("Зливаємо: " + Arrays.toString(left) + " + " + Arrays.toString(right) +
                " -> " + Arrays.toString(array));
    }

    private <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0;//current index of left
        int j = 0;//current index of right
        int k = 0;//current index of array

        //в цикл входять лише вже відсортовані масиви
        while (i < left.length && j < right.length) {//після циклу залишиться лише один масив з двох
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {//якщо лівий, то цей цикл його перекине в основний масив
            array[k++] = left[i++];
        }
        while (j < right.length) {//або якщо правий - теж саме
            array[k++] = right[j++];
        }
    }

    public <T extends Comparable<T>> int binarySearch(T[] array, T target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle].compareTo(target) == 0) {
                System.out.println("Binary search: " + target + " found in position " + middle);
                return middle;
            }
            if (target.compareTo(array[middle]) < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        System.out.println("Binary search: " + target + " not fount");
        return -1;
    }
}
