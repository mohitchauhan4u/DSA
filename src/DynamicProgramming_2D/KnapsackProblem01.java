package DynamicProgramming_2D;

public class KnapsackProblem01 {

    public static int knapsackProblemIterative(int W, int[] wt, int[] val){
        int n=val.length;
        int[][] dp=new int[n+1][W +1];
        for (int i=n-1;i>=0;i--){
            for (int w=0;w<=W;w++){
                int ans;
                if(wt[i]<=w){
                    int ans1=val[i]+dp[i+1][w-wt[i]];
                    int ans2=dp[i+1][w];
                    ans=Math.max(ans1,ans2);
                }else {
                    ans=dp[i+1][w];
                }
                dp[i][w]=ans;
            }
        }
        return dp[0][W];
    }
    public static int knapsackProblemRecursive(int w, int[] wt, int[] val, int i) {
        if (i == wt.length) {
            return 0;
        }
        if (wt[i] <= w) {
            return Math.max(val[i] + knapsackProblemRecursive(w - wt[i], wt, val, i + 1), knapsackProblemRecursive(w, wt, val, i + 1));
        } else {
            return knapsackProblemRecursive(w, wt, val, i + 1);
        }
    }

    public static void main(String[] args) {
        int w1 = 5;
        int[] wt1 = {1, 2, 4, 5};
        int[] val1 = {5, 4, 8, 6};
        System.out.println(knapsackProblemRecursive(w1, wt1, val1, 0));
        System.out.println(knapsackProblemIterative(w1, wt1, val1));
        int w2 = 26;
        int[] wt2 = {12, 7, 11, 8, 9};
        int[] val2 = {24, 13, 23, 15, 16};
        System.out.println(knapsackProblemRecursive(w2, wt2, val2, 0));
        System.out.println(knapsackProblemIterative(w2, wt2, val2));
    }
}
