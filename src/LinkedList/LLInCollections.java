package LinkedList;

import java.util.LinkedList;

public class LLInCollections {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(33);
        list.add(0,3);
        for (int i:list){
            System.out.println(i);
        }
    }
}
