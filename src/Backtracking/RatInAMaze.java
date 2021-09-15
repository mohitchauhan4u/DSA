package Backtracking;

import java.util.Scanner;

public class RatInAMaze {
    private static void printAllPaths(int[][] maze, int i, int j, int[][] path) {
        int n = maze.length;
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return;
        }//include the cell in current path
        path[i][j] = 1;
        if (i == n - 1 && j == n - 1) {
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    System.out.print(path[k][l] + " ");
                }
            }
            System.out.println();
            path[i][j]=0;
            return;
        }
        //explore further in different directions
        //top
        printAllPaths(maze, i - 1, j, path);
        //right
        printAllPaths(maze, i, j + 1, path);
        //down
        printAllPaths(maze, i + 1, j, path);
        //left
        printAllPaths(maze, i, j - 1, path);
        path[i][j]=0;
    }

    private static boolean ratInAMazeHelper(int[][] maze, int i, int j, int[][] path) {
        int n = maze.length;
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return false;
        }//include the cell in current path
        path[i][j] = 1;
        if (i == n - 1 && j == n - 1) {
            return true;
        }
        //explore further in different directions
        //top
        if (ratInAMazeHelper(maze, i - 1, j, path)) {
            return true;
        }
        //right
        if (ratInAMazeHelper(maze, i, j + 1, path)) {
            return true;
        }
        //down
        if (ratInAMazeHelper(maze, i + 1, j, path)) {
            return true;
        }
        //left
        if (ratInAMazeHelper(maze, i, j - 1, path)) {
            return true;
        }
        return false;
    }

    public static boolean ratInAMaze(int[][] maze) {
        int n = maze.length;
        int[][] path = new int[n][n];
        printAllPaths(maze,0,0,path);
        path = new int[n][n];
        return ratInAMazeHelper(maze, 0, 0, path);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of maze");
        int n = sc.nextInt();
        int[][] maze = new int[n][n];
        System.out.println("Enter paths of maze");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        System.out.println(ratInAMaze(maze));
    }
}