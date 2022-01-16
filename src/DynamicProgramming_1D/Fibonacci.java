package DynamicProgramming_1D;

import java.util.Scanner;

public class Fibonacci {
    // without dp O(2^n)
    public static long fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }
    // recursive dp O(n)
    public static long fib2(int n, long[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        /*long ans1, ans2;
        if (dp[n - 1] == 0) {
            ans1 = fib2(n - 1, dp);
            dp[n - 1] = ans1;
        } else {
            ans1 = dp[n - 1];
        }
        if (dp[n - 2] == 0) {
            ans2 = fib2(n - 2, dp);
            dp[n - 2] = ans2;
        } else {
            ans2 = dp[n - 2];
        }
        return ans1 + ans2;*/
        // or
        if (dp[n - 1] == 0) {
            dp[n - 1] = fib2(n - 1, dp);
        }
        if (dp[n - 2] == 0) {
            dp[n - 2] = fib2(n - 2, dp);
        }
        dp[n] = dp[n - 1] + dp[n - 2];
        return dp[n];
    }

    // iterative dp
    public static long fib3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib1(n));
        long[] dp = new long[n + 1];
        // Arrays.fill(dp, -1);
        System.out.println(fib2(n, dp));
        System.out.println(fib3(n));
    }
}
