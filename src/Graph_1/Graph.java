// A package declaration. It is a way to organize classes in a package.
package Graph_1;

// Importing the java.util package.

import java.util.*;

/**
 * Given a graph represented as an adjacency matrix, and two vertices, find the shortest path between the two vertices
 * <p>
 * # **Q2. (10 points)** Given a graph represented as an adjacency matrix, and two vertices, find the shortest path between
 * the two vertices
 * #
 * # **Q3. (10 points)** Given a graph represented as an adjacency matrix, check if the graph is connected
 * #
 * # **Q4. (10 points)** Given a graph represented by an adjacency matrix, print all nodes in DFS order
 * #
 * # **Q5. (10 points)** Given a graph represented by an adjacency matrix, print all nodes in BFS order
 * #
 * # **Q6. (10 points)** Given a graph represented by an adjacency matrix, find out if all the vertices are connected to
 * the starting vertex
 * #
 * #
 */
public class Graph {
    /**
     * Given a graph represented as an adjacency matrix, and two vertices, find the shortest path between the two vertices
     *
     * @param adjMatrix the adjacency matrix of the graph
     * @param s         The starting vertex.
     * @param e         The end vertex.
     * @return An ArrayList of integers.
     */
    public static ArrayList<Integer> getPathBFS(int[][] adjMatrix, int s, int e) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[adjMatrix.length];
        visited[s] = true;
        pendingVertices.add(s);
        map.put(s, -1);
        boolean pathFound = false;
        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.poll();
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                    pendingVertices.add(i);
                    visited[i] = true;
                    map.put(i, currentVertex);
                    if (i == e) {
                        pathFound = true;
                        break;
                    }
                }
            }
        }
        if (pathFound) {
            ArrayList<Integer> path = new ArrayList<>();
            int currentVertex = e;
            while (currentVertex != -1) {
                path.add(currentVertex);
                int parent = map.get(currentVertex);
                currentVertex = parent;
            }
            return path;
        } else {
            return null;
        }
    }

    /**
     * Given a graph represented by an adjacency matrix, and a starting vertex,
     * find if there is a path from the starting vertex to any other vertex in the graph
     *
     * @param edges   the graph represented as an adjacency matrix
     * @param sv      The starting vertex.
     * @param visited A boolean array that keeps track of whether a node has been visited or not.
     */
    private static void hasPathHelper(int[][] edges, int sv, boolean[] visited) {
        visited[sv] = true;
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                hasPathHelper(edges, i, visited);
            }
        }
    }

    // A helper function for hasPath function.
    public static boolean hasPath(int[][] edges, int sv, int ev) {
        boolean[] visited = new boolean[edges.length];
        hasPathHelper(edges, sv, visited);
        return visited[ev];
    }

    /**
     * Given a graph represented by an adjacency matrix, and a starting vertex,
     * find out if all the vertices are connected to the starting vertex
     *
     * @param edges   the graph represented as an adjacency matrix
     * @param sv      The starting vertex.
     * @param visited A boolean array that keeps track of whether a node has been visited or not.
     */
    public static void isConnectedHelper(int[][] edges, int sv, boolean[] visited) {
        visited[sv] = true;
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                isConnectedHelper(edges, i, visited);
            }
        }
    }

    /**
     * Given a graph represented by a 2D array, check if the graph is connected
     *
     * @param edges the graph represented as an adjacency matrix
     * @return The boolean value of whether the graph is connected or not.
     */
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

    /**
     * Prints all vertices in the graph reachable from the given vertex
     *
     * @param edges   the adjacency matrix of the graph
     * @param sv      The starting vertex.
     * @param visited A boolean array that keeps track of whether a node has been visited or not.
     */
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

    /**
     * Given a graph represented by a 2D array, print all nodes in DFS order
     *
     * @param edges the adjacency matrix of the graph
     */
    public static void printDFS(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printHelperDFS(edges, i, visited);
            }
        }
    }

    /**
     * Print all the vertices in the graph using BFS
     *
     * @param edges   2D array of integers. edges[i][j] = 1 means there is a directed edge from i to j.
     * @param sv      The starting vertex.
     * @param visited A boolean array that keeps track of whether a node has been visited or not.
     */
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

    /**
     * Print all nodes in the graph in breadth-first order
     *
     * @param edges the adjacency matrix of the graph
     */
    public static void printBFS(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printHelperBFS(edges, i, visited);
            }
        }
    }

    /**
     * Given a graph represented as an adjacency matrix,
     * print the DFS traversal of the graph.
     */
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
        // Printing the DFS and BFS traversal of the graph.
        System.out.println("DFS:");
        printDFS(edges);
        System.out.println("BFS:");
        printBFS(edges);
        System.out.println();
        System.out.println(isConnected(edges));

        /*
        //this is for hasPath function;*/
        System.out.println("enter starting vertex for checking has path");
        int sv = sc.nextInt();
        System.out.println("enter ending vertex for checking has path");
        int ev = sc.nextInt();
        System.out.println(hasPath(edges, sv, ev));
    }
}
