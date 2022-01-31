package OnlineQuestions;

public class LeetcodeRichestCustomerWealth {
    public static int maximumWealth(int[][] arr) {
        int max=0;
        for (int[] ints : arr) {
            int tempMax = 0;
            int j = 0;
            while (j < ints.length) {
                tempMax += ints[j++];
            }
            if (tempMax > max) {
                max = tempMax;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [][] arr={{1,2,3},{3,2,1}};
        System.out.println(maximumWealth(arr));
    }
}
