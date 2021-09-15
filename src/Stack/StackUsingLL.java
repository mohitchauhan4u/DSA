package Stack;

import LinkedList.Node;
//every method in this class has time complexity id O(1)
public class StackUsingLL<T> {
    private Node<T> head;
    private int size;

    public StackUsingLL() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public T top() {
        if (size == 0) {
            System.out.println("Linked List is Empty");
        }
        return head.data;
    }

    public void push(T element) {
        if (head == null) {
            Node<T> newNode = new Node(element);
            head = newNode;
            size++;
        } else {
            Node<T> newNode = new Node(element);
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public T pop() {
        if (head == null) {
            System.out.println("Linked List is empty");
        }
        Node<T> temp = head;
        head = head.next;
        size--;
        return temp.data;
    }
}
