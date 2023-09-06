package pro.sky.hwbaseofalgoritmspart2;

import pro.sky.hwbaseofalgoritmspart2.sort.SortMethods;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = generateRandomArray();
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr2, arr2.length);

        long start = System.currentTimeMillis();
        SortMethods.sortBubble(arr1);
        System.out.printf("Sort bubble = %d\n", System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        SortMethods.sortSelection(arr2);
        System.out.printf("Sort selection = %d\n", System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        SortMethods.sortInsertion(arr3);
        System.out.printf("Sort insertion = %d\n", System.currentTimeMillis() - start);
    }

    private static Integer[] generateRandomArray() {
        Random random = new Random();
        Integer[] arr = new Integer[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000);
        }
        return arr;
    }
}