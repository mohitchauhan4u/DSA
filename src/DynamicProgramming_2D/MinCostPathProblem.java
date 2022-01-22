package DynamicProgramming_2D;

public class MinCostPathProblem {

    public static int minCostPAthProblemIterative(int[][] path) {

        int m = path.length;
        int n = path[0].length;
        int[][] minAns = new int[m + 1][n + 1];
        for (int i = 0; i < minAns.length; i++) {
            for (int j = 0; j < minAns[0].length; j++) {
                minAns[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    minAns[i][j] = path[i][j];
                    continue;
                }
                    minAns[i][j] = path[i][j] + Math.min(minAns[i + 1][j], Math.min(minAns[i + 1][j + 1], minAns[i][j + 1]));
            }
        }
        return minAns[0][0];
    }

    public static int minCostPathProblemRecursivedp(int[][] path) {
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
        System.out.println(minCostPathProblemRecursivedp(path1));
        System.out.println(minCostPathProblemRecursivedp(path2));
        System.out.println(minCostPAthProblemIterative(path1));
        System.out.println(minCostPAthProblemIterative(path2));
    }
}
