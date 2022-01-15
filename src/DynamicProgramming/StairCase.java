package DynamicProgramming;

public class StairCase {
    public static int stairCase(int n){
        if(n==0){
            return 1;
        }
        if(n==1 || n==2){
            return n;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
         return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(stairCase(10));
    }
}
