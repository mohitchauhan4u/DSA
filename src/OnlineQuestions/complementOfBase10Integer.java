package OnlineQuestions;

public class complementOfBase10Integer {

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

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(50));
        System.out.println(bitwiseComplement(5));
    }
}
