package GraphCB;

import java.util.Scanner;

public class Graph {

    public static void printHelperDFS(int[][] adj_mat, int sv, boolean[] visited){
        System.out.print(sv+" ");
        visited[sv]=true;
        int v= adj_mat.length;
        for(int i=0;i<v;i++){
            if(adj_mat[sv][i]==1 && !visited[i]){
                printHelperDFS(adj_mat, i,visited);
            }
        }
    }
    public  static void printDFS(int[][] adj_mat, int sv){
        boolean[] visited=new boolean[adj_mat.length];
        for(int i=sv;i< adj_mat.length;i++) {
            if(!visited[i]){
                System.out.println();
                printHelperDFS(adj_mat, i, visited);
            }
        }
    }

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
        printDFS(adj_mat,0);
    }
}
