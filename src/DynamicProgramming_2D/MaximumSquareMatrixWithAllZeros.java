package DynamicProgramming_2D;

public class MaximumSquareMatrixWithAllZeros {
    public static int maximumSquareMatrixWithAllZeros(int[][] arr){
        return -1;
    }
    public static void main(String[] args) {
        int[][] arr1={
                {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}
        };
        System.out.println(maximumSquareMatrixWithAllZeros(arr1));
        int[][] arr2={{1,1,0},{1,1,1},{1,1,1}
        };
        System.out.println(maximumSquareMatrixWithAllZeros(arr2));
    }
}
