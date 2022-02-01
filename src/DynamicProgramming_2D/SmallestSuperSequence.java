package DynamicProgramming_2D;

import java.util.HashMap;

public class SmallestSuperSequence {
    public static int smallestSuperSequence(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map1.containsKey(s1.charAt(i))) {
                int temp = map1.get(s1.charAt(i));
                map1.put(s1.charAt(i), temp + 1);
            } else {
                map1.put(s1.charAt(i), 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (map2.containsKey(s2.charAt(i))) {
                int temp = map2.get(s2.charAt(i));
                map2.put(s2.charAt(i), temp + 1);
            } else {
                map2.put(s2.charAt(i), 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {

        }


        return -1;
    }

    public static void main(String[] args) {
        System.out.println(smallestSuperSequence("ab", "ac"));//3
        System.out.println(smallestSuperSequence("qerepct", "pqqrpt"));//9
        System.out.println(smallestSuperSequence("ab", "qerepct"));//8
    }
}
