package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
    public static void printHelperDFS(int[][] edges, int sv, boolean[] visited) {
        System.out.println(sv);
        visited[sv] = true;
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                printHelperDFS(edges, i, visited);
            }
        }
    }

    public static void printDFS(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printHelperDFS(edges, i, visited);
            }
        }
    }

    private static void hasPathHelper(int[][] edges, int sv, boolean[] visited) {
        visited[sv] = true;
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                hasPathHelper(edges, i,visited);
            }
        }
    }

    public static boolean hasPath(int[][] edges, int sv, int ev) {
        boolean[] visited = new boolean[edges.length];
        hasPathHelper(edges, sv,visited);
        return visited[ev];
    }

    public static void isConnectedHelper(int[][] edges, int sv, boolean[] visited) {
        visited[sv] = true;
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                isConnectedHelper(edges, i, visited);
            }
        }
    }

    public static boolean isConnected(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        isConnectedHelper(edges, 0, visited);
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printHelperBFS(int[][] edges, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        int n = edges.length;
        visited[sv] = true;
        while (!q.isEmpty()) {
            int front = q.poll();
            System.out.println(front);
            for (int i = 0; i < n; i++) {
                if (edges[front][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void printBFS(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printHelperBFS(edges, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no. of vertices or nodes");
        int n = sc.nextInt();
        System.out.println("enter no. of edges");
        int e = sc.nextInt();
        int[][] edges = new int[n][n];
        System.out.println("enter edges");
        for (int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        System.out.println("DFS:");
        printDFS(edges);
        System.out.println("BFS:");
        printBFS(edges);
        System.out.println();
        System.out.println(isConnected(edges));

        /*
        //this is for hasPath function;*/
        System.out.println("enter starting vertex for checking has path");
        int sv=sc.nextInt();
        System.out.println("enter ending vertex for checking has path");
        int ev=sc.nextInt();
        System.out.println(hasPath(edges,sv,ev));
    }
}
