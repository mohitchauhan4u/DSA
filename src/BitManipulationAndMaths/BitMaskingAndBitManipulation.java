package BitManipulationAndMaths;

public class BitMaskingAndBitManipulation {
    // left shift a<<b=a*2^b    number a left shifted b times
    //right shift a>>b=a/2^b    number a right shifted b times

    /**
     * Given an integer, return true if it is odd, false otherwise
     *
     * @param n The number to check.
     * @return A boolean value.
     */
    public static boolean oddOrNot(int n) {
        return (n & 1) == 1;
    }

    /**
     * Given an integer, return true if it is even, false if it is odd
     *
     * @param n The number to check.
     * @return The boolean value of whether the number is even or not.
     */
    public static boolean evenOrNot(int n) {
        return (n & 1) == 0;
    }

    /**
     * Find the unique number in an array
     *
     * @param arr an array of integers
     * @return The unique number.
     */
    public static int findUniqueNumberInArray(int[] arr) {
        int unique = 0;
        for (int n : arr) {
            unique ^= n;
        }
        return unique;
    }

    /**
     * Given a number n and a position i, return the value of the bit at ith position in n
     *
     * @param n The number to be checked.
     * @param i The position of the bit to be retrieved.
     * @return The bit at the ith position of the number n.
     */
    public static int bitAtIthPosition(int n, int i) {
        return (n & 1 << (i - 1));
    }

    /**
     * Set the ith bit of n to 1
     *
     * @param n The number to set the ith bit of.
     * @param i The index of the bit to be set.
     * @return The number with the ith bit set to 1.
     */
    public static int setTheIthBit(int n, int i) {
        return n | (1 << (i - 1));
    }

    /**
     * Given a number n and an index i, reset the ith bit of n to 0
     *
     * @param n The number in which we want to reset the ith bit.
     * @param i The index of the bit to be reset.
     * @return The number with the ith bit reset.
     */
    public static int resetTheIthBit(int n, int i) {
        return n & (~(1 << (i - 1)));
    }

    /**
     * Given a number n, return the number of 5s in the number n!
     *
     * @param n the number to be converted to the base 5.
     * @return The number of 5s in the binary representation of n.
     */
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

    /**
     * Given a number and a base, return the number of digits in the number in that base
     *
     * @param n    The number to be converted.
     * @param base the base of the number system.
     * @return The number of digits in the number n in base base.
     */
    public static int numberOfDigits(int n, int base) {
        return (int) (Math.log(n) / Math.log(base)) + 1;
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
        System.out.println();
        System.out.println(numberOfDigits(3, 2));
        System.out.println(numberOfDigits(3, 10));
        System.out.println(numberOfDigits(127, 2));
        System.out.println(numberOfDigits(-128, 2));
        System.out.println(numberOfDigits(-127, 2));
        System.out.println(numberOfDigits(127, 10));
        System.out.println(numberOfDigits(127, 8));
        System.out.println(numberOfDigits(127, 16));
        System.out.println();
        System.out.println(pascalTriangle(1));
        System.out.println(pascalTriangle(2));
        System.out.println(pascalTriangle(3));
        System.out.println(pascalTriangle(4));
        System.out.println(pascalTriangle(5));
        System.out.println();
        System.out.println(powerOfTwo(1));
        System.out.println(powerOfTwo(2));
        System.out.println(powerOfTwo(256));
        System.out.println(powerOfTwo(12));
        System.out.println();
        System.out.println(numberToThePower(3,5));
        System.out.println(numberToThePower(30,3));
        System.out.println(numberToThePower(4,5));
        System.out.println(numberToThePower(2,12));
    }


    public static int pascalTriangle(int n) {
        return 1 << (n - 1);
    }

    public static boolean powerOfTwo(int n) {
        return (n & n - 1) == 0;
    }

    public static int numberToThePower(int n, int power) {
        int ans = 1;
        while (power > 0) {
            if ((power & 1) == 1) {
                ans *= n;
            }
            n *= n;
            power = power >> 1;
        }
        return ans;
    }
}
