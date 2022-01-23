package DynamicProgramming_2D;

public class LCS {


    public static int problemLCS(String s1, String s2){
        if(s1.length()==0 || s2.length()==0){
            return 0;
        }
        return LCSHelper(s1,s2,0,0);
    }
    private static int LCSHelper(String s1,String s2,int i,int j){
        if(i>=s1.length()||j>=s2.length()){
            return 0;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+LCSHelper(s1,s2,i+1,j+1);
        }
        return Math.max(LCSHelper(s1,s2,i,j+1),LCSHelper(s1,s2,i+1,j));
    }

    public static void main(String[] args) {
        System.out.println(problemLCS("MohitChauhan4u","RohitChaudhary4u"));
        System.out.println(problemLCS("MohitChauhan4u","RohitSorout4u"));
        System.out.println(problemLCS("Mohit","Rohit"));
    }
}
