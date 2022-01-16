package DynamicProgramming_1D;

import java.util.Scanner;

public class ByteLandian {

    //iterative solution
    public static int byteLandian(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            dp[i] = Math.max(dp[i], dp[i / 2] + dp[i / 3] + dp[i / 4]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n");
        int n = sc.nextInt();
        System.out.println(byteLandian(n));
    }
}
