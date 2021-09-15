package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonaci {

    public static int fibb1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibb1(n - 1) + fibb1(n - 2);
    }
public static int fibb2(int n,int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        int ans1,ans2;
        if(dp[n-1]==-1){
            ans1=fibb2(n-1,dp);
            dp[n-1]=ans1;
        }else {
            ans1=dp[n-1];
        }if(dp[n-2]==-1){
            ans2=fibb2(n-2,dp);
            dp[n-2]=ans2;
        }else {
            ans2=dp[n-2];
        }
        return ans1+ans2;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fibb1(n));
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        System.out.println(fibb2(n,dp));
    }
}
