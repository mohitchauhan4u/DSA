package DynamicProgramming;

public class StairCase {
    public static long numberOfStairCase(int numberOfStirs) {
        long[] ways = new long[numberOfStirs + 1];
        if (numberOfStirs == 0) {
            return 1;
        }
        if (numberOfStirs == 1 || numberOfStirs == 2) {
            return numberOfStirs;
        }
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i <= numberOfStirs; i++) {
            ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3];
        }
        return ways[numberOfStirs];
    }

    public static void main(String[] args) {
        System.out.println(numberOfStairCase(10));
    }
}
