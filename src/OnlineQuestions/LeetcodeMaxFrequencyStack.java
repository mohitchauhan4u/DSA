package OnlineQuestions;

import java.util.HashMap;
import java.util.Stack;


//solution
//https://assets.leetcode.com/users/images/1797d431-8a02-4336-b940-176d9f692286_1644674393.7227256.jpeg
//https://assets.leetcode.com/users/images/4d9cdedd-51a9-4958-bac4-f404a0182765_1644674401.2711964.jpeg
public class LeetcodeMaxFrequencyStack {
    public static void main(String[] args) {

    }
}

class FreqStack {
    HashMap<Integer, Stack<Integer>> fstmap;
    HashMap<Integer, Integer> fmap;
    int high;

    public FreqStack() {
        fstmap = new HashMap<>();
        fmap = new HashMap<>();
        high = 0;
    }

    public void push(int val) {
        int freq = fmap.getOrDefault(val, 0) + 1;
        fmap.put(val, freq);
        high = Math.max(high, freq);
        Stack<Integer> st = fstmap.getOrDefault(freq, new Stack<>());
        st.push(val);
        fstmap.put(freq, st);
    }

    public int pop() {
        int val = fstmap.get(high).pop();
        if (fstmap.get(high).size() == 0)
            high = high - 1;
        fmap.put(val, fmap.get(val) - 1);
        return val;
    }

}