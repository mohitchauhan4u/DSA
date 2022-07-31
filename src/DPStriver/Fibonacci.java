package DPStriver;

public class Fibonacci {

    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static int fib_n_n(int n){

        int prev2=0;
        int prev1=1;
        for(int i=2;i<=n;i++){
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib(15));
        System.out.println(fib_n_n(5));
        System.out.println(fib_n_n(15));
    }
}
