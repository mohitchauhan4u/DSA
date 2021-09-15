package Hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class main {
    public static int longestSubsetZeroSum(){
        return 0;
    }
    public static int pairsWithDifferenceK(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        int n=sc.nextInt();
        System.out.println("Enter elements of array ");
        int [] arr=new int[n];
        System.out.println("Enter Number K");
        int k=sc.nextInt();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i]+1));
            }else{
                map.put(arr[i],1);
            }
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(Math.abs((arr[i]-arr[j]))==k){
                    count++;
                }
            }
        }
        return count;
    }
    public static String extractUniqueCharacters(String str) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int num = map.get(str.charAt(i));
                map.put(str.charAt(i), num + 1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        char[] arr=new char[map.size()];
        int j=0;
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                arr[j]=str.charAt(i);
                j++;
                map.remove(str.charAt(i));
            }
        }
        String str1=String.valueOf(arr);
        return str1;
    }

    public static void pairSumTo0(int[] arr1) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j : arr1) {
            if (map.containsKey(j)) {
                int num = map.get(j);
                map.put(j, num + 1);
            } else {
                map.put(j, 1);
            }
        }
        for (int j : arr1) {
            if (map.containsKey(-j) && map.containsKey(j)) {
                int val = map.get(-j);
                while (val != 0) {
                    int num = map.get(j);
                    while (num != 0) {
                        if (j >= 0) {
                            System.out.print(-j + " " + j);
                        } else {
                            System.out.print(j + " " + -j);
                        }
                        System.out.println();
                        num--;
                    }
                    val--;
                }
                map.remove(j);
                map.remove(-j);
            }
        }
    }

    public static void arrayIntersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                int num = map.get(arr1[i]);
                // map.remove(arr1[i]);
                map.put(arr1[i], num + 1);
            } else {
                map.put(arr1[i], 1);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                System.out.print(arr2[i] + " ");
                if (map.containsKey(arr2[i])) {
                    int num = map.get(arr2[i]);
                    //map.remove(arr2[i]);
                    map.put(arr2[i], num + 1);
                }
            }
        }
    }

    public static int maxFrequencyNumber(int[] arr) {
        if (arr == null) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int key = map.get(arr[i]);
                map.remove(arr[i]);
                map.put(arr[i], key + 1);
            } else {
                map.put(arr[i], 1);
                arrayList.add(arr[i]);
            }
        }

        int max = arr[0];
        for (int i : arrayList) {
            if (map.get(i) > map.get(max)) {
                max = i;
            }
        }
        return max;
    }

    public static ArrayList<Integer> removeDuplicates(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                arrayList.add(arr[i]);
                map.put(arr[i], true);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
       /* Map<String,Integer> map=new Map<>();
        map.insert("abc5",5);
        map.insert("abc2",2);
        map.insert("abc4",4);
        map.insert("abc3",3);
        map.insert("abc1",1);
        System.out.println(map.size());
        System.out.println(map.search("abc1"));
//        Set<String> key=map.keySet();
//        for(String s:key){
//            System.out.print(s+" ");
//        }
        //System.out.println(map.get("abc4"));
        map.delete("abc1");
        System.out.println(map.size());
//        key=map.keySet();
//        for(String s:key){
//            System.out.print(s+" ");
//        }
        int[] arr = {3, 1, 1, 4, 4};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        ArrayList<Integer> arrayList = removeDuplicates(arr);
        for (int i : arrayList) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(maxFrequencyNumber(arr));
        int[] arr1 = {2, 6, 8, 5, 4, 3};
        int[] arr2 = {2, 3, 4, 7};
        arrayIntersection(arr1, arr2);
          //arr1 = {0, 1, 2, 3, 4, -2, 1, -1, -3, -2, -4, -4, 0};
        pairSumTo0(arr1);
//        Map map=new Map();
//        System.out.println(map.search("112"));
//        map.insert("112",5);
//        System.out.println(map.search("112"));
//        map.delete("112");
//        System.out.println(map.search("112"));
        HashMap<String,Integer> map=new HashMap<String, Integer>();
        map.put("abc5",5);
        map.put("abc2",2);
        map.put("abc4",4);
        map.put("abc3",3);
        map.put("abc1",1);
        Set<String> key=map.keySet();
        for(String s:key ){
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println(extractUniqueCharacters(""));*/
        System.out.println(pairsWithDifferenceK());

    }
}
