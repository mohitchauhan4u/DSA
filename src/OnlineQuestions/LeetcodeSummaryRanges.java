package OnlineQuestions;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeSummaryRanges {
    public static void main(String[] args) {
        List<String> list=summaryRanges(new int[]{1,2,3,5,6,7,8,9,12,13,14,15,16,19,20});
        for(String i:list){
            System.out.print(i+" ");
        }
    }
    public static List<String> summaryRanges(int[] arr) {
        List<String> list= new ArrayList<>();
        int len=arr.length;
        for(int i=0;i<len;){
            int start=i,end=i;
            while(end+1<len && arr[end]+1==arr[end+1]){
                end++;
            }
            if(end>start){
                list.add(arr[start] +"->"+ arr[end]);
            }else{
                list.add(Integer.toString(arr[start]));
            }
            i=end+1;
        }
        return list;
    }
}
