package OnlineQuestions;

import java.util.HashMap;
import java.util.Map;

public class LeetcodeCopyListwithRandomPointer {
    public static void main(String[] args) {
        copyRandomList(new Node(1));
    }
    private static Map<Node,Node> map = new HashMap<>();

    public static Node copyRandomList(Node head) {
        if(head == null) return null;
        Node temp = new Node(head.val);
        map.put(head,temp);
        temp.next = copyRandomList(head.next);
        temp.random = map.get(head.random);
        return temp;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}