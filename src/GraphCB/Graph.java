package GraphCB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    public static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (DFS(adj, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean DFS(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, int parent) {
        visited[src] = true;
        for (int v : adj.get(src)) {
            if (!visited[v]) {
                if (DFS(adj, src, visited, src)) {
                    return true;
                }
            } else if (v != parent) {
                return true;
            }
        }
        return false;
    }

    public static void printHelperBFS(int[][] adj_mat, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        int v = adj_mat.length;
        while (!q.isEmpty()) {
            int front = q.poll();
            System.out.print(front + " ");
            for (int i = 0; i < v; i++) {
                if (adj_mat[front][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void printBFS(int[][] adj_mat, int sv) {
        boolean[] visited = new boolean[adj_mat.length];
        for (int i = sv; i < adj_mat.length; i++) {
            if (!visited[i]) {
                System.out.println();
                printHelperBFS(adj_mat, i, visited);
            }
        }
    }

    public static void printHelperDFS(int[][] adj_mat, int sv, boolean[] visited) {
        System.out.print(sv + " ");
        visited[sv] = true;
        int v = adj_mat.length;
        for (int i = 0; i < v; i++) {
            if (adj_mat[sv][i] == 1 && !visited[i]) {
                printHelperDFS(adj_mat, i, visited);
            }
        }
    }

    public static void printDFS(int[][] adj_mat, int sv) {
        boolean[] visited = new boolean[adj_mat.length];
        for (int i = sv; i < adj_mat.length; i++) {
            if (!visited[i]) {
                System.out.println();
                printHelperDFS(adj_mat, i, visited);
            }
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter no of vertex");
//        int v = sc.nextInt();
//        System.out.println("Enter no of edges");
//        int e = sc.nextInt();
//        int[][] adj_mat = new int[v][v];
//        for (int i = 0; i < e; i++) {
//            int sv = sc.nextInt();
//            int ev = sc.nextInt();
//            adj_mat[sv][ev] = 1;
//            adj_mat[ev][sv] = 1;
//        }
//        System.out.println("DFS:-");
//        printDFS(adj_mat, 0);
//        System.out.println();
//        System.out.println("BFS:-");
//        printBFS(adj_mat, 0);
        int[] ans=tcs(new int[]{100,80,60,70,60,85,75});
        for (int i:ans
             ) {
            System.out.print(i+" ");
        }
        System.out.println();

        int[] ans1=tcs(new int[]{150,90,80,85,65,70,75});
        for (int i:ans1
             ) {
            System.out.print(i+" ");
        }
    }
    public static int[] tcs(int[] arr){
        int len=arr.length;
        int[] ans=new int[len];
        for(int i=0;i<len;i++){
            int count=0;
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    count++;
                }else{
                    break;
                }
            }
            ans[i]=count+1;
        }
        return ans;
    }
}
