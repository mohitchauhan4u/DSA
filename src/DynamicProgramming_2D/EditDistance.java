package DynamicProgramming_2D;

public class EditDistance {
    //wrong code
    /*public static int editDistanceProblemIterative(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0]=i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }

        return dp[m][n];
    }*/

    public static int editDistanceProblemRecursive(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return editDistanceProblemRecursiveHelper(s1, s2, dp);
    }

    private static int editDistanceProblemRecursiveHelper(String s1, String s2, int[][] dp) {
        int m = s1.length();
        int n = s2.length();
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s1.charAt(0) == s2.charAt(0)) {
            int smallAns = editDistanceProblemRecursiveHelper(s1.substring(1), s2.substring(1), dp);
            dp[m - 1][n - 1] = smallAns;
            dp[m][n] = smallAns;
        } else {
            int substitute = editDistanceProblemRecursiveHelper(s1.substring(1), s2.substring(1), dp);
            dp[m - 1][n - 1] = substitute;
            int insert = editDistanceProblemRecursiveHelper(s1, s2.substring(1), dp);
            dp[m][n - 1] = insert;
            int remove = editDistanceProblemRecursiveHelper(s1.substring(1), s2, dp);
            dp[m - 1][n] = remove;
            dp[m][n] = 1 + Math.min(substitute, Math.min(insert, remove));
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        System.out.println(editDistanceProblemRecursive("mohit", "rohit"));
        System.out.println(editDistanceProblemRecursive("ab", "adc"));
        System.out.println(editDistanceProblemRecursive("whgtdwhgtdg", "aswcfg"));
//        System.out.println(editDistanceProblemIterative("mohit", "rohit"));
//        System.out.println(editDistanceProblemIterative("ab", "adc"));
//        System.out.println(editDistanceProblemIterative("whgtdwhgtdg", "aswcfg"));
    }
}
