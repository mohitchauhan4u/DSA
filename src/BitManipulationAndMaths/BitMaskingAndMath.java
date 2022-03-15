package BitManipulationAndMaths;

public class BitMaskingAndMath {
    // left shift a<<b=a*2^b    number a left shifted b times
    //right shift a>>b=a/2^b    number a right shifted b times

    public static boolean oddOrNot(int n) {
        return (n & 1) == 1;
    }

    public static boolean evenOrNot(int n) {
        return (n & 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(oddOrNot(13) + " " + evenOrNot(13));
        System.out.println(oddOrNot(136) + " " + evenOrNot(136));
        System.out.println(findUniqueNumberInArray(new int[]{1, 2, 3, 1, 3, 5, 5, 6, 6, 7, 9, 7, 9, 8, 8}));
        System.out.println(findUniqueNumberInArray(new int[]{5, 5, 6, 6, 7, 9, 7, 9, 3, 8, 8}));
    }

    private static int findUniqueNumberInArray(int[] arr) {
        int unique = 0;
        for (int n : arr) {
            unique ^= n;
        }
        return unique;
    }
}
