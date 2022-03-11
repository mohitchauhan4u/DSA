package OnlineQuestions;

public class LeetcodePermutationAndCombination {
    public static void main(String[] args) {
        stringCombinations("abc", "");
    }

    public static void stringCombinations(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        for (int i = 0; i < ques.length(); i++) {
            stringCombinations(ques.substring(i + 1), ans + ques.charAt(i));
        }
    }
}
