package OnlineQuestions;

import java.util.ArrayList;
import java.util.HashMap;

public class GFGArray {

    public static ArrayList<Integer> moreThanNbyK(int[] arr, int k) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : arr) {
            if (map.containsKey(i) && map.get(i) > (n / k)) {
                ans.add(i);
                map.remove(i);
            }
        }
        return ans;
    }

    public static int[] rearrangeArrayInAlternatingPositiveAndNegativeItems(int[] arr) {

        moveAllNegativeNumbersToBeginning(arr);
        int positiveIndex = 0;
        while (positiveIndex < arr.length && arr[positiveIndex] < 0) {
            positiveIndex++;
        }
        int negativeIndex = 1;
        while (negativeIndex < arr.length && arr[negativeIndex] < 0 && positiveIndex < arr.length) {
            int temp = arr[negativeIndex];
            arr[negativeIndex] = arr[positiveIndex];
            arr[positiveIndex] = temp;
            negativeIndex += 2;
            positiveIndex += 1;
        }
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
 /*       System.out.println((Arrays.toString(minAndMax(new int[]{1, 2, 5, 2, 9839, 8, 31, 3, 24, 35, 135, 24, 23, 234, 235, 1, 34, 124, 225, 235, 24, 62, 4, -123, 1, 3, -1, 2, 356, -24, 5, 12431, 142, 24}))));
        System.out.println(Arrays.toString(moveAllNegativeNumbersToBeginning(new int[]{1, -5, 2, -3, 4, 365, -1, -129, 5, 6, -7, 8})));
        System.out.println(Arrays.toString(rearrangeArrayInAlternatingPositiveAndNegativeItems(new int[]{1, -5, 2, -3, 4, 365, -1, -129, 5, 6, -7, 8, -2, 11, 56, 247, 12, -26})));
        System.out.println(Arrays.toString(rearrangeArrayInAlternatingPositiveAndNegativeItems(new int[]{1, -5, 2})));
        System.out.println(Arrays.toString(rearrangeArrayInAlternatingPositiveAndNegativeItems(new int[]{-129, 5, 6, -7, 8, -2, 11, 56, 247, 12, -26})));
        System.out.println(Arrays.toString(rearrangeArrayInAlternatingPositiveAndNegativeItems(new int[]{-129, 5, -6, -7, -8, -2, 11, -56, -247, 12, -26})));*/
        ArrayList<Integer> arr = moreThanNbyK(new int[]{-129, 5, 6, -7, 8, -2, -1, -1, 2, 2, 2, 2, -2, -2, 3, 3, -2, -3, 12, 1, 23, 23, 42, 4, 234, 224, 4, 5, 6, 7, 666, 6, 6, 6, 6, 4, 5, 4, 11, 56, 247, 12, -26}, 23);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        arr = moreThanNbyK(new int[]{1, 2, 3, 4, 4, 5, 4, 3, 2, 6, 8, 2, 3, 3, 4, 4, 42, 4, 4, 24, 7, 8, 8, 5, 6, 7, 9, 52, 2, 3, 3, 46, 7, 95, 2}, 23);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
