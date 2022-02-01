package OnlineQuestions;

import java.util.Arrays;

public class LeetcodeConvert1DArrayInto2DArray {
    //wrong code
    public static int[][] construct2DArray(int[] arr, int m, int n) {
        int[][] ans=new int[m][n];
        int i=0;
        int j=0;
        for (int value : arr) {
            if (j + 1 == n) {
                i++;
                j = 0;
            }
            ans[i][j] = value;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{1, 2, 3, 4}, 2,2)));
    }
}
