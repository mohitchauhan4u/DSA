package DynamicProgramming_2D;

public class LCS {

    public static int LCSIterative(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
    public static int problemLCS(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return LCSHelper(s1, s2, 0, 0, dp);
    }

    private static int LCSHelper(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + LCSHelper(s1, s2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(LCSHelper(s1, s2, i, j + 1, dp), LCSHelper(s1, s2, i + 1, j, dp));
        }
    }

    public static void main(String[] args) {
        System.out.println(problemLCS("MohitChauhan4u", "RohitChaudhary4u"));
        System.out.println(problemLCS("MohitChauhan4u", "RohitSorout4u"));
        System.out.println(problemLCS("Mohit", "Rohit"));
        System.out.println(problemLCS("MohitChauhan4u", "RohitChaudhary4u"));
        System.out.println(LCSIterative("MohitChauhan4u", "RohitSorout4u"));
        System.out.println(LCSIterative("Mohit", "Rohit"));
    }
}
