package OnlineQuestions;

public class ShortTheName {

    public static String shortTheName(String str){
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<str.length();i++){
            ans.append(namePart(str.substring(i)));
            while(i<str.length() && str.charAt(i)!=' '){
                i++;
            }
        }

        return ans.toString();
    }

    private static String namePart(String str){
        int i=0;
        while(i<str.length()){
            if(str.charAt(i)==' '){
                return  str.substring(0,1);
            }
            i++;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(shortTheName("Mohit Chauhan"));
        System.out.println(shortTheName("Koushal Kishor Garg"));
        System.out.println(shortTheName("Prem Narayan Pandey"));
        System.out.println(shortTheName("Krishan Chandra Pandey"));
        System.out.println(shortTheName("Kunal Sharma Baman"));
    }
}
