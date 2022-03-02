package OnlineQuestions;

public class complementOfBase10Integer {

    /**
     * Convert the binary representation of a number to its complement
     *
     * @param n the integer to be complemented
     * @return The bitwise complement of the given number.
     */
    public static int bitwiseComplement(int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder comp = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                comp.append('0');
            } else {
                comp.append('1');
            }
        }
        return Integer.parseInt(comp.toString(), 2);
    }

    /**
     * Given a positive integer, return its complement number. The complement strategy is to flip the bits of its binary
     * representation
     */
    public static void main(String[] args) {
        System.out.println(bitwiseComplement(50));
        System.out.println(bitwiseComplement(5));
    }
}
