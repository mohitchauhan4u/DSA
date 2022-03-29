package OnlineQuestions;

import java.util.Arrays;

public class GFGArray {

    public static int[] rearrangeArrayInAlternatingPositiveAndNegativeItems(int[] arr){

        return arr;
    }
    public static int[] moveAllNegativeNumbersToBeginning(int[] arr) {
        int positiveIndex = 0;
        while (positiveIndex < arr.length && arr[positiveIndex] < 0) {
            positiveIndex++;
        }
        for (int i = positiveIndex + 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = arr[i];
                arr[i] = arr[positiveIndex];
                arr[positiveIndex] = temp;
                positiveIndex++;
            }
        }
        return arr;
    }

    public static int[] minAndMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }

        return new int[]{min, max};
    }

    public static void main(String[] args) {
        //System.out.println((Arrays.toString(minAndMax(new int[]{1, 2, 5, 2, 9839, 8, 31, 3, 24, 35, 135, 24, 23, 234, 235, 1, 34, 124, 225, 235, 24, 62, 4, -123, 1, 3, -1, 2, 356, -24, 5, 12431, 142, 24}))));
        //System.out.println(Arrays.toString(moveAllNegativeNumbersToBeginning(new int[]{1, -5, 2, -3, 4, 365, -1, -129, 5, 6, -7, 8})));
        System.out.println(Arrays.toString(rearrangeArrayInAlternatingPositiveAndNegativeItems(new int[]{1, -5, 2, -3, 4, 365, -1, -129, 5, 6, -7, 8,-2,11,56,247,12,-26})));
    }
}
