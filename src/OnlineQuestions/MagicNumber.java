package OnlineQuestions;

public class MagicNumber {
    /**
     * If the sum of the digits of a number is 1, then the number is a magic number
     *
     * @param num The number to check.
     */
    public static void magicNumber(int num) {
        int sumOfDigits = 0;
        while (num > 0 || sumOfDigits > 9) {
            if (num == 0) {
                num = sumOfDigits;
                sumOfDigits = 0;
            }
            sumOfDigits += num % 10;
            num /= 10;
        }

        // If sum is 1, original number is magic number
        if (sumOfDigits == 1) {
            System.out.println("Magic number");
        } else {
            System.out.println("Not magic number");
        }
    }

    /**
     * Prints the magic number of a given number
     */
    public static void main(String[] args) {
        magicNumber(163);
        magicNumber(123);
        magicNumber(123456);
        magicNumber(1);
    }
}
