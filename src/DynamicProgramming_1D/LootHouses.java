package DynamicProgramming_1D;

import java.util.Scanner;

public class LootHouses {

    public static int lootHouses(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value of n");
        int n=sc.nextInt();
        int[] money=new int[n];
        System.out.println("Enter values of money in houses");
        for(int i=0;i<n;i++){
            money[i]=sc.nextInt();
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return money[0];
        }
        int[] maxAns=new int[n];
        maxAns[0]=money[0];
        maxAns[1]=Math.max(money[0],money[1]);
        for(int i=2;i<n;i++){
            maxAns[i]=Math.max(maxAns[i-1],money[i]+maxAns[i-2]);
            }
        return maxAns[n-1];
    }

    public static void main(String[] args) {
        System.out.println("Maximum loot is: "+lootHouses());
    }
}