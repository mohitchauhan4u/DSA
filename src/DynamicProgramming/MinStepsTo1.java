package DynamicProgramming;

import java.util.Scanner;

public class MinStepsTo1 {
    //Without DP
    public static int minStepsTo1WithoutDP(int n) {
        if (n == 1) {
            return 0;
        }
        int subtractingByOne;
        int dividingByTwo = Integer.MAX_VALUE;
        int dividingByThree = Integer.MAX_VALUE;
        subtractingByOne = minStepsTo1WithoutDP(n - 1);
        if (n % 2 == 0) {
            dividingByTwo = minStepsTo1WithoutDP(n / 2);
        }
        if (n % 3 == 0) {
            dividingByThree = minStepsTo1WithoutDP(n / 3);
        }
        return 1 + Math.min(subtractingByOne, Math.min(dividingByThree, dividingByTwo));
    }

    public static int minStepsTo1WithDP(int n) {


        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n");
        int n = sc.nextInt();
        System.out.println(minStepsTo1WithoutDP(n));
    }
}
