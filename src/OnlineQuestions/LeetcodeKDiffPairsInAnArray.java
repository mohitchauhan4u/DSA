package OnlineQuestions;

import java.util.*;

public class LeetcodeKDiffPairsInAnArray {
    public static void main(String[] args) {

    }

    public int findPairsFast(int[] arr, int k) {

        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            if (!map.containsKey(j)) {
                if (map.containsKey(j + k)) ans++;
                if (map.containsKey(j - k)) ans++;
                map.put(j, 1);
            } else if (k == 0) {
                if (map.get(j) == 1) {
                    ans++;
                }
                map.put(j, map.get(j) + 1);
            }
        }
        return ans;
    }

    public int findPairsSlow(int[] arr, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) == k) {
                    List<Integer> newList;
                    newList = new ArrayList<>();
                    newList.add(arr[i]);
                    newList.add(arr[j]);
                    Collections.sort(newList);
                    if (!list.contains(newList)) {
                        ans++;
                        list.add(newList);
                    }
                }
            }
        }
        return ans;
    }
}
