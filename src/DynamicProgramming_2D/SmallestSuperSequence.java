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
            if(map1.containsKey(s2.charAt(i)) && map2.containsKey(s2.charAt(i))){
                if(map1.get(s2.charAt(i))>map2.get(s2.charAt(i))){
                    map2.remove(s2.charAt(i));
                }else{
                    map1.remove(s2.charAt(i));
                }
            }
        }
        int ans=0;
        for (int i = 0; i < s1.length(); i++) {
            if (map1.containsKey(s1.charAt(i))) {
                ans+= map1.get(s1.charAt(i));
                map1.remove(s1.charAt(i));
            }
        } for (int i = 0; i < s2.length(); i++) {
            if (map2.containsKey(s2.charAt(i))) {
                ans+= map2.get(s2.charAt(i));
                map2.remove(s2.charAt(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(smallestSuperSequence("ab", "ac"));//3
        System.out.println(smallestSuperSequence("qerepct", "pqqrpt"));//9
        System.out.println(smallestSuperSequence("ab", "qerepct"));//9
        System.out.println(smallestSuperSequence("ac", "qerepct"));//8
        System.out.println(smallestSuperSequence("rohit", "mohit"));//6
        System.out.println(smallestSuperSequence("rohit", ""));//5
        System.out.println(smallestSuperSequence("rahul", "mohit"));//9
    }
}
