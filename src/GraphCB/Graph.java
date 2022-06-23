package GraphCB;

import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of vertex");
        int v=sc.nextInt();
        System.out.println("Enter no of edges");
        int e=sc.nextInt();
        int[][] adj_mat=new int[v][v];
        for(int i=0;i<e;i++){
            int sv=sc.nextInt();
            int ev=sc.nextInt();
            adj_mat[sv][ev]=1;
            adj_mat[ev][sv]=1;
        }
    }
}
