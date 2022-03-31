package OnlineQuestions;

public class GFGString {

    public static void printAllTheDuplicatesInTheInputString(String s) {
        int len = 256;
        int[] chars = new int[len];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        for (int i = 0; i < len; i++) {
            if (chars[i] > 1) System.out.print((char) (i) + " ");
        }
    }

    public static void main(String[] args) {
        printAllTheDuplicatesInTheInputString("Mohit Chauhan");
        printAllTheDuplicatesInTheInputString("Mohit Rohit Sohit");
    }
}
