package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberOfSquares {
//recursive
    public static int minNumOfSquares(int n,int[] dp){
        if(n==0){
            return 0;
        }
        int minAns=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int currentValue;
            if(dp[n-(i*i)]==-1){
                currentValue=minNumOfSquares(n-(i*i),dp);
            }else {
                currentValue=dp[n-(i*i)];
            }
            if(minAns>currentValue){
                minAns=currentValue;
            }
        }
        return 1+minAns;
    }

    //iterative
    public static int minSquareIterative(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int minAns=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                int currentValue=dp[i-(j*j)];
                if (minAns>currentValue){
                    minAns=currentValue;
                }
            }
            dp[i]=1+minAns;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value of n");
        int n=sc.nextInt();
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(minNumOfSquares(n,dp));
        System.out.println(minSquareIterative(n));
    }
}
