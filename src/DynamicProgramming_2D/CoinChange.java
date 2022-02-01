package DynamicProgramming_2D;

public class CoinChange {

    public static int coinChangeProblem(int target,int[] arr){
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i=0;i< arr.length;i++){
            for (int j=arr[i];j< dp.length;j++){
                dp[j]+=dp[j-arr[i]];
            }
        }
        return dp[target];
    }
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int target1=11;
        System.out.println(coinChangeProblem(target1,arr1));
        int[] arr2={2,3,5};
        int target2=7;
        System.out.println(coinChangeProblem(target2,arr2));
        int[] arr3={2,3};
        int target3=11;
        System.out.println(coinChangeProblem(target3,arr3));
    }
}
