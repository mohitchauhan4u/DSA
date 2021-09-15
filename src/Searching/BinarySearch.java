package Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8};
        System.out.println(findElementIndex(arr,10));
    }
    public static int findElementIndex(int[] arr, int ele){
        int s=0;
        int e=arr.length-1;
        while (s<=e){
            int m=(s+e)/2;
            if(arr[m]==ele){
                return m;
            }else if (arr[m]<ele){
                s=m+1;
            }else{
                e=m-1;
            }
        }
        return -1;


    }
}
