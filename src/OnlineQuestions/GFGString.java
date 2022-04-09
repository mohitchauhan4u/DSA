package OnlineQuestions;

import java.util.HashMap;

public class GFGString {

    public static boolean checkIfStringIsValidShuffleOfTwoDistinctStrings(String s1, String s2, String str) {
        if (str.length() != (s1.length() + s2.length())) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            map1.put(s2.charAt(i), map1.getOrDefault(s2.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map2.put(str.charAt(i), map2.getOrDefault(str.charAt(i), 0) + 1);
        }
        return map1.equals(map2);
    }

    public static boolean isOneStringRotationOfOther(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(s2.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void printAllTheDuplicatesInTheInputString(String s) {
        int len = 256;
        int[] chars = new int[len];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        for (int i = 0; i < len; i++) {
            if (chars[i] > 1) System.out.print((char) (i) + " ");
        }
        System.out.println();
    }

    public static String getPhoneNumber(String s) {
        StringBuilder str = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        map.put("zero", "0");
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder temp = new StringBuilder();
            while (i < s.length() && s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
                i++;
            }

            if (temp.toString().equals("double")) {
                count = 2;
            } else if (temp.toString().equals("triple")) {
                count = 3;
            } else {
                getNumberHelper(str, map.get(temp.toString()), count);
                count = 1;
            }
        }
        return str.toString();
    }

    private static void getNumberHelper(StringBuilder str, String temp, int n) {
        while (n > 0) {
            str.append(temp);
            n--;
        }
    }

    public static void main(String[] args) {
//        printAllTheDuplicatesInTheInputString("Mohit Chauhan");
//        printAllTheDuplicatesInTheInputString("Mohit Rohit Sohit");
//        System.out.println(getPhoneNumber("one one double zero"));
//        System.out.println(isOneStringRotationOfOther("", ""));
//        System.out.println(isOneStringRotationOfOther("abcd", "dcba"));
//        System.out.println(isOneStringRotationOfOther("ewfqejdb", "injfwnce"));
//        System.out.println(isOneStringRotationOfOther("mohit", "tihom"));
        System.out.println(checkIfStringIsValidShuffleOfTwoDistinctStrings("abc", "abc", "aabbcc"));
        System.out.println(checkIfStringIsValidShuffleOfTwoDistinctStrings("awabcc", "abbcc", "aabbbwacccc"));
        System.out.println(checkIfStringIsValidShuffleOfTwoDistinctStrings("abc", "abcc", "aabbc"));
        System.out.println(checkIfStringIsValidShuffleOfTwoDistinctStrings("", "", ""));
        System.out.println(checkIfStringIsValidShuffleOfTwoDistinctStrings("aa", "bb", "aaabbb"));
    }
}
