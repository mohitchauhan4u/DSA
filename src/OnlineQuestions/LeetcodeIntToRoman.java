package OnlineQuestions;

public class LeetcodeIntToRoman {
    public static String intToRoman(int num) {
        StringBuilder str= new StringBuilder();
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] symbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        while(num > 0){
            for (int i = 12; i >= 0; i--) {
                if(num >= values[i]){
                    num -= values[i];
                    str.append(symbols[i]);
                    break;
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(10));
        System.out.println(intToRoman(1112));
        System.out.println(intToRoman(2340));
        System.out.println(intToRoman(3210));
        System.out.println(intToRoman(1120));
    }
}
