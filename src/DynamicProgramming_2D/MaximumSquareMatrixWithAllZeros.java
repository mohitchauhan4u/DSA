package DynamicProgramming_2D;

public class MaximumSquareMatrixWithAllZeros {
    public static int maximumSquareMatrixWithAllZeros(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 0) {
                dp[i][0] = 1;
                max=1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[0][i] == 0) {
                dp[0][i] = 1;
                max=1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 0) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
                if(dp[i][j]>max){
                    max=dp[i][j];
                }
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }

    public static void main(String[] args) {
        int[][] arr1 = {
                {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}
        };
        System.out.println(maximumSquareMatrixWithAllZeros(arr1));
        int[][] arr2 = {{1, 1, 0}, {1, 1, 1}, {1, 1, 1}
        };
        System.out.println(maximumSquareMatrixWithAllZeros(arr2));
        int[][] arr3 = {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}
        };
        System.out.println(maximumSquareMatrixWithAllZeros(arr3));
        int[][] arr4 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 0}
        };
        System.out.println(maximumSquareMatrixWithAllZeros(arr4));
    }
}
