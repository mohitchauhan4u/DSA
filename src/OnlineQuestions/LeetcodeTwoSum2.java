package OnlineQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetcodeTwoSum2 {

//    Solution 1 : BinarySearch
//    Time : O(nlogn)
//    space : O(1)

    public static void main(String[] args) {

    }
//    Solution 2: HashMap
//    Time : O(n)
//    space : O(n)

    public int[] twoSum1(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            int pos = Arrays.binarySearch(numbers, i + 1, n, target - numbers[i]);
            if (pos > 0) return new int[]{i + 1, pos + 1};
        }
        return null;
    }
//    Solution 3 : Two pointers
//    Time : O(n)
//    space : O(1)

    public int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length;
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < n; i++) seen.put(numbers[i], i);

        for (int i = 0; i < n - 1; i++)
            if (seen.containsKey(target - numbers[i]))
                return new int[]{i + 1, seen.get(target - numbers[i]) + 1};

        return null;
    }

    public int[] twoSum3(int[] numbers, int target) {
        int n = numbers.length, i = 0, j = n - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) return new int[]{i + 1, j + 1};
            if (sum > target) j--;
            else i++;
        }
        return null;
    }
}
