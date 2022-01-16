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


        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Answer is: "+lootHouses());
    }
}
