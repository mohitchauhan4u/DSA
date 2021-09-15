package Queue;

import java.util.Stack;

public class QueueUsingTwoStack<T> {
    private Stack<T> s1;
    private Stack<T> s2;
    private T top;

    public QueueUsingTwoStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enQueue(T data) {
        if (s1.isEmpty()) {
            top = data;
        }
        s1.push(data);
    }

    public T deQueue() {
        if (s1.isEmpty()) {
            return null;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        T r = s2.pop();
        while (!s2.isEmpty()) {
            if (s1.isEmpty()) {
                top = s2.peek();
            }
            s1.push(s2.pop());
        }
        if (s1.isEmpty()) {
            top = null;
        }
        return r;
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public T top() {
        return top;
    }

    public int size() {
        return s1.size();
    }

    public static void main(String[] args) {
        QueueUsingTwoStack<Integer> q = new QueueUsingTwoStack<Integer>();
        for (int i = 1; i <= 10; i++) {
            q.enQueue(i);
        }
        System.out.println(q.size());
        System.out.println(q.top);
        System.out.println(q.deQueue());
        System.out.println(q.size());
        System.out.println(q.top);
        for (int i = 1; i < 9; i++) {
            System.out.print(q.deQueue() + " ");
        }
        System.out.println();
        System.out.println(q.size());
        System.out.println(q.top);
    }
}