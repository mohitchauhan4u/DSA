package BitManipulationAndMaths;

public class BitMaskingAndMath {
    // left shift a<<b=a*2^b    number a left shifted b times
    //right shift a>>b=a/2^b    number a right shifted b times

    public static boolean oddOrNot(int n) {
        return (n & 1) == 1;
    }

    public static boolean evenOrNot(int n) {
        return (n & 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(oddOrNot(13) + " " + evenOrNot(13));
        System.out.println(oddOrNot(136) + " " + evenOrNot(136));
    }
}
