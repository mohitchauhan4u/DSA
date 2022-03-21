package BitManipulationAndMaths;

public class BitMaskingAndBitManipulation {
    // left shift a<<b=a*2^b    number a left shifted b times
    //  right shift a>>b=a/2^b    number a right shifted b times

    //  distributive property that plus and multiply :
    //  (a1+a2)*(b1+b2) = a1*b1 + a1*b2 + a2*b1 + a2*b2
    //  Distributive property is similar for AND and XOR here:
    //  (a1^a2) & (b1^b2) = (a1&b1) ^ (a1&b2) ^ (a2&b1) ^ (a2&b2)

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

    /**
     * Given a number n, return the number of unique binary trees with n nodes
     *
     * @param n the number of rows in the triangle
     * @return The number of ways to choose k elements from a set of n elements.
     */
    public static int pascalTriangle(int n) {
        return 1 << (n - 1);
    }

    /**
     * Given an integer, return true if it is a power of two
     *
     * @param n The number to check.
     * @return The method returns true if the number is a power of two, and false otherwise.
     */
    public static boolean powerOfTwo(int n) {
        return (n & n - 1) == 0;
    }

    /**
     * Given a number n and a power p, return n^p
     *
     * @param n     the base
     * @param power The power to which the number is to be raised.
     * @return The answer to the question.
     */
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

    /**
     * Given an integer, count the number of set bits in the binary representation of that integer
     *
     * @param n The integer to be converted.
     * @return The number of set bits in the integer n.
     */
    public static int numberOfSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /**
     * Given a number, find the XOR of the number with all numbers less than it
     *
     * @param n The number to find the XOR of.
     * @return The XOR of the number.
     */
    private static int findXOROfNumber(int n) {
        int ans = 0;
        if (n % 4 == 0) {
            ans = n;
        } else if (n % 4 == 1) {
            ans = 1;
        } else if (n % 4 == 2) {
            ans = n + 1;
        }
        return ans;
    }

    /**
     * Find the XOR of all numbers from s to e
     *
     * @param s start index of the range
     * @param e The number whose XOR is to be found.
     * @return The XOR of the range.
     */
    public static int XORInRange(int s, int e) {
        return findXOROfNumber(e) ^ findXOROfNumber(s - 1);
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
        System.out.println(numberToThePower(3, 5));
        System.out.println(numberToThePower(30, 3));
        System.out.println(numberToThePower(4, 5));
        System.out.println(numberToThePower(2, 12));
        System.out.println();
        System.out.println(numberOfSetBits(2));
        System.out.println(numberOfSetBits(15));
        System.out.println(numberOfSetBits(21));
        System.out.println(numberOfSetBits(127));
        System.out.println();
        System.out.println(findXOROfNumber(4));
        System.out.println(findXOROfNumber(9));
        System.out.println(findXOROfNumber(15));
        System.out.println(findXOROfNumber(18));
        System.out.println();
        System.out.println(XORInRange(3, 9));
        System.out.println(XORInRange(7, 9028937));
    }


}
