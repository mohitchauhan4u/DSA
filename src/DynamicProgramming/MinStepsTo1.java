package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinStepsTo1 {
    //Without DP
    public static int minStepsTo1WithoutDP(int n) {
        if (n == 1) {
            return 0;
        }
        int subtractingByOne;
        int dividingByTwo = Integer.MAX_VALUE;
        int dividingByThree = Integer.MAX_VALUE;
        subtractingByOne = minStepsTo1WithoutDP(n - 1);
        if (n % 2 == 0) {
            dividingByTwo = minStepsTo1WithoutDP(n / 2);
        }
        if (n % 3 == 0) {
            dividingByThree = minStepsTo1WithoutDP(n / 3);
        }
        return 1 + Math.min(subtractingByOne, Math.min(dividingByThree, dividingByTwo));
    }

    //recursive
    public static int minStepsTo1WithDP(int n, int[] dp) {
        if (n == 1) {
            return 0;
        }
        int subtractingByOne;
        int dividingByTwo = Integer.MAX_VALUE;
        int dividingByThree = Integer.MAX_VALUE;
        if (dp[n - 1] == -1) {
            subtractingByOne = minStepsTo1WithDP(n - 1, dp);
            dp[n - 1] = subtractingByOne;
        } else {
            subtractingByOne = dp[n - 1];
        }
        if (n % 2 == 0) {
            if (dp[n / 2] == -1) {
                dividingByTwo = minStepsTo1WithDP(n / 2, dp);
                dp[n / 2] = dividingByTwo;
            } else {
                dividingByTwo = dp[n / 2];
            }
        }
        if (n % 3 == 0) {
            if (dp[n / 3] == -1) {
                dividingByThree = minStepsTo1WithDP(n / 3, dp);
                dp[n - 1] = dividingByThree;
            } else {
                dividingByThree = dp[n / 3];
            }
        }
        return 1 + Math.min(subtractingByOne, Math.min(dividingByThree, dividingByTwo));

    }

    public static int minStepIterative(int n){

        if(n==1){
            return 0;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n;i++){
            int sub1=dp[i-1];
            int div2=Integer.MAX_VALUE;
            if(i%2==0){
                div2=dp[i/2];
            }
            int div3=Integer.MAX_VALUE;
            if(i%3==0){
                div3=dp[i/3];
            }
            dp[i]=1+Math.min(sub1,Math.min(div2,div3));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n");
        int n = sc.nextInt();
        System.out.println(minStepsTo1WithoutDP(n));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(minStepsTo1WithDP(n, dp));
        System.out.println(minStepIterative(n));
    }
}
