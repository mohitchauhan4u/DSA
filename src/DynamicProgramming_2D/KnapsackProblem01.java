package DynamicProgramming_2D;

public class KnapsackProblem01 {
    public static int knapsackProblem(int w, int[] wt, int[] val, int i) {
        if (i == wt.length) {
            return 0;
        }
        if (wt[i] <= w) {
            return Math.max(val[i] + knapsackProblem(w - wt[i], wt, val, i + 1), knapsackProblem(w, wt, val, i + 1));
        } else {
            return knapsackProblem(w, wt, val, i + 1);
        }
    }

    public static void main(String[] args) {
        int w1 = 5;
        int[] wt1 = {1, 2, 4, 5};
        int[] val1 = {5, 4, 8, 6};
        System.out.println(knapsackProblem(w1, wt1, val1, 0));
        int w2 = 26;
        int[] wt2 = {12, 7, 11, 8, 9};
        int[] val2 = {24, 13, 23, 15, 16};
        System.out.println(knapsackProblem(w2, wt2, val2, 0));
    }
}
