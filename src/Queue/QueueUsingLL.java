package Queue;

import LinkedList.Node;

public class QueueUsingLL<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public T front() {
        if (head == null) {
            System.out.println("Queue is empty to show front");
            return null;
        } else {
            return head.data;
        }
    }

    public void enQueue(T element) {
        if (head == null) {
            Node<T> newNode = new Node<>(element);
            head = newNode;
            tail = newNode;
            size++;
        } else {
            Node<T> newNode = new Node<>(element);
            tail.next = newNode;
            tail=newNode;
            size++;
        }
    }

    public void deQueue() {
        if (head == null) {
            System.out.println("Queue is empty for deQueue");
        } else {
            System.out.println("Element deQueued from list is " + head.data);
            head = head.next;
            size--;
        }
    }
}
