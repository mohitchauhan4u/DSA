package Stack;

import java.util.Stack;

public class StackCollections {
    private static Stack<Integer> stackHelper = new Stack<>();

    public static boolean balancedParenthesisBetter(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                if (c == ')') {
                    if ('(' != stack.pop())
                        return false;
                } else if (c == ']') {
                    if ('[' != stack.pop())
                        return false;
                } else if (c == '}') {
                    if ('{' != stack.pop())
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean balancedParenthesis(String str) {
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ('{')) {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ('[')) {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ('(')) {
                stack.push(str.charAt(i));
            } else {
                if (str.charAt(i) == ('}')) {
                    if (stack.isEmpty() || !stack.peek().equals('{')) {
                        return false;
                    }
                    if (stack.peek().equals('{')) {
                        stack.pop();
                    }
                } else if (str.charAt(i) == (']')) {
                    if (stack.isEmpty() || !stack.peek().equals('[')) {
                        return false;
                    }
                    if (stack.peek().equals('[')) {
                        stack.pop();
                    }
                } else if (str.charAt(i) == (')')) {
                    if (stack.isEmpty() || !stack.peek().equals('(')) {
                        return false;
                    }
                    if (stack.peek().equals('(')) {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void reverseStack(Stack<Integer> stack) {
        recursionHelper(stack);
        while (!stackHelper.isEmpty()) {
            stack.push(stackHelper.pop());
        }
    }

    private static void recursionHelper(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int data = stack.pop();
        recursionHelper(stack);
        stackHelper.push(data);
    }

    public static void main(String[] args) {
       /* System.out.println(balancedParenthesis("{{[][]()()}"));
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        while (!stack.isEmpty()){
            System.out.printDFS(stack.pop()+" ");
        }
        System.out.println();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        reverseStack(stack);
        while (!stack.isEmpty()){
            System.out.printDFS(stack.pop()+" ");
        }*/
        System.out.println(balancedParenthesis("(])"));
        System.out.println(balancedParenthesisBetter("(])"));
    }
}
