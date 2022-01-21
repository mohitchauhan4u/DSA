package DynamicProgramming_2D;

public class MinCostPathProblem {


    public static int minCostPathProblem(int[][] path){
        int[][] minAns=new int[path.length][path[0].length];
        return minCostPathProblemHelper(path,minAns,0,0);
    }
    private static int minCostPathProblemHelper(int[][] path,int[][] minAns,int i,int j){



        return -1;
    }

    public static void main(String[] args) {
    
    }
}
