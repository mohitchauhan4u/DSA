package BitManipulationAndMaths;

public class BitMaskingAndBitManipulation {
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
        System.out.println();
        System.out.println(findUniqueNumberInArray(new int[]{1, 2, 3, 1, 3, 5, 5, 6, 6, 7, 9, 7, 9, 8, 8}));
        System.out.println(findUniqueNumberInArray(new int[]{5, 5, 6, 6, 7, 9, 7, 9, 3, 8, 8}));
        System.out.println();
        System.out.println(bitAtIthPosition(127, 5));
        System.out.println(bitAtIthPosition(125, 1));
        System.out.println();
        System.out.println(setTheIthBit(121, 3));
        System.out.println(setTheIthBit(125, 2));
        System.out.println();
        System.out.println(resetTheIthBit(127, 1));
        System.out.println(resetTheIthBit(127, 2));
        System.out.println(resetTheIthBit(127, 3));
        System.out.println(resetTheIthBit(127, 4));
        System.out.println();
        System.out.println(magicNumberOf5(3));
        System.out.println(magicNumberOf5(7));
        System.out.println(magicNumberOf5(6));

    }

    public static int findUniqueNumberInArray(int[] arr) {
        int unique = 0;
        for (int n : arr) {
            unique ^= n;
        }
        return unique;
    }

    public static int bitAtIthPosition(int n, int i) {
        return (n & 1 << (i - 1));
    }

    public static int setTheIthBit(int n, int i) {
        return n | (1 << (i - 1));
    }

    public static int resetTheIthBit(int n, int i) {
        return n & (~(1 << (i - 1)));
    }

    public static int magicNumberOf5(int n) {
        int ans = 0, index = 1;
        while (n > 0) {
            if ((n & 1) == 1) ans += Math.pow(5, index);
            n = n >> 1;
            index++;
        }
        return ans;
        /*or
        int ans = 0, base = 5;
        while (n > 0) {
            int last = n & 1;
            n = n >> 1;
            ans += last * base;
            base = base * 5;
        }
        return ans;    */
    }
}
