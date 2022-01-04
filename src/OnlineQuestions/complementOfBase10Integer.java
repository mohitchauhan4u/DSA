package OnlineQuestions;

public class complementOfBase10Integer {

    //wrong solution
    public static int bitwiseComplement(int n) {
        String str=Integer.toBinaryString(n);
        String comp="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                str+='0';
            }else{
                str+='1';
            }
        }
        return Integer.parseInt(str, 2);
    }

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));
    }
}
