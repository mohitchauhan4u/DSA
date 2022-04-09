package OnlineQuestions;

import java.util.HashMap;

public class GFGString {

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
                helper(str, map.get(temp.toString()), count);
                count = 1;
            }
        }
        return str.toString();
    }

    public static void helper(StringBuilder str, String temp, int n) {
        while (n > 0) {
            str.append(temp);
            n--;
        }
    }

    public static void main(String[] args) {
//        printAllTheDuplicatesInTheInputString("Mohit Chauhan");
//        printAllTheDuplicatesInTheInputString("Mohit Rohit Sohit");
//        System.out.println(getPhoneNumber("one one double zero"));
        System.out.println(isOneStringRotationOfOther("",""));
        System.out.println(isOneStringRotationOfOther("abcd","dcba"));
        System.out.println(isOneStringRotationOfOther("ewfqejdb","injfwnce"));
        System.out.println(isOneStringRotationOfOther("mohit","tihom"));
    }
}
