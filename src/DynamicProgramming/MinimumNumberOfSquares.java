package DynamicProgramming;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int n=19;
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(minNumOfSquares(n,dp));
    }
}
