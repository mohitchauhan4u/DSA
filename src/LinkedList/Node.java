package LinkedList;

public class Node<T> {
    public T data;
    // in next line <T> means that next will refer to that node who's data is also of T type
    public Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}
