package OnlineQuestions;

public class LeetcodeRomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("MDCDLXI"));
        System.out.println(romanToInt("CM"));
    }

    public static int romanToInt(String s) {
        int ans = 0;
        int i;
        for (i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'I' && s.charAt(i + 1) != 'V' && s.charAt(i + 1) != 'X') {
                ans += 1;
            } else if (s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                ans += s.charAt(i + 1) == 'V' ? 4 : 9;
                i++;
            } else if (s.charAt(i) == 'V') {
                ans += 5;
            } else if (s.charAt(i) == 'X' && s.charAt(i + 1) != 'L' && s.charAt(i + 1) != 'C') {
                ans += 10;
            } else if (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                ans += s.charAt(i + 1) == 'L' ? 40 : 90;
                i++;
            } else if (s.charAt(i) == 'L') {
                ans += 50;
            } else if (s.charAt(i) == 'C' && s.charAt(i + 1) != 'D' && s.charAt(i + 1) != 'M') {
                ans += 100;
            } else if (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                ans += s.charAt(i + 1) == 'D' ? 400 : 900;
                i++;
            } else if (s.charAt(i) == 'D') {
                ans += 500;
            } else if (s.charAt(i) == 'M') {
                ans += 1000;
            }
        }

        if (i != (s.length())) {
            if (s.charAt(i) == 'I') {
                ans += 1;
            } else if (s.charAt(i) == 'V') {
                ans += 5;
            } else if (s.charAt(i) == 'X') {
                ans += 10;
            } else if (s.charAt(i) == 'L') {
                ans += 50;
            } else if (s.charAt(i) == 'C') {
                ans += 100;
            } else if (s.charAt(i) == 'D') {
                ans += 500;
            } else if (s.charAt(i) == 'M') {
                ans += 1000;
            }
        }

        return ans;
    }
}
