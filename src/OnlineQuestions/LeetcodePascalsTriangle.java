package OnlineQuestions;

import java.util.ArrayList;
import java.util.List;

public class LeetcodePascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        int size = 1;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> newList = new ArrayList<>(size);
        newList.add(1);
        list.add(0, newList);
        size++;
        if (numRows == 1) return list;
        newList = new ArrayList<>(size);
        newList.add(1);
        newList.add(1);
        list.add(1, newList);
        if (numRows == 2) return list;
        size++;
        List<Integer> prev = newList;
        while (size <= numRows) {
            newList = new ArrayList<>(size);
            newList.add(0, 1);
            newList.add(newList.size()-1, 1);
            int i = 1;
            while (i < size - 1) {
                newList.add(i, prev.get(i - 1) + prev.get(i));
                i++;
            }
            list.add(size - 1, newList);
            size++;
            prev = newList;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
    }
}
