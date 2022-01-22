package DynamicProgramming_2D;

public class MinCostPathProblem {


    public static int minCostPathProblem(int[][] path) {
        int[][] minAns = new int[path.length][path[0].length];
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                minAns[i][j] = Integer.MAX_VALUE;
            }
        }
        return minCostPathProblemHelper(path, minAns, 0, 0);
    }

    private static int minCostPathProblemHelper(int[][] path, int[][] minAns, int i, int j) {
        if (i == path.length - 1 && j == path[0].length - 1) {
            return path[i][j];
        }
        if (i == path.length || j == path[0].length) {
            return Integer.MAX_VALUE;
        }
        if (minAns[i][j] != Integer.MAX_VALUE) {
            return minAns[i][j];
        }
        return minAns[i][j] = path[i][j] + Math.min(minCostPathProblemHelper(path, minAns, i + 1, j), Math.min(minCostPathProblemHelper(path, minAns, i + 1, j + 1), minCostPathProblemHelper(path, minAns, i, j + 1)));
    }

    public static void main(String[] args) {
        int[][] path1 = {{3, 4, 1, 2,},
                {2, 1, 8, 9},
                {4, 7, 8, 1}};
        int[][] path2 = {{10, 6, 9, 0},
                {-23, 8, 9, 90},
                {-200, 0, 89, 200}};
        System.out.println(minCostPathProblem(path1));
        System.out.println(minCostPathProblem(path2));
    }
}
