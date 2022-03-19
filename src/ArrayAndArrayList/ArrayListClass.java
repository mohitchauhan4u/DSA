package ArrayAndArrayList;

import java.util.ArrayList;

public class ArrayListClass {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(5);
        arr.add(7);
        arr.add(5);
        arr.add(7);
        arr.add(4);
        arr.add(5);
        System.out.println(arr.toString());
        arr.remove(5);

    }
}
