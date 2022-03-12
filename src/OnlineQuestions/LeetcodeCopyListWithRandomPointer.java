package OnlineQuestions;

import java.util.HashMap;
import java.util.Map;

public class LeetcodeCopyListWithRandomPointer {
    private static Map<Node, Node> map = new HashMap<>();
    // Creating a map of Node to Node.

    /**
     * Given a linked list, copy the linked list and return the copied list
     */
    public static void main(String[] args) {
        copyRandomList(new Node(1));
    }

    /**
     * If the node is not in the map, copy the node and put it in the map.
     * <p>
     * If the node is in the map, return the node in the map.
     *
     * @param head the head of the linked list
     * @return The new head of the copied list.
     */
    public static Node copyRandomList(Node head) {
        if (head == null) return null;
        Node temp = new Node(head.val);
        map.put(head, temp);
        temp.next = copyRandomList(head.next);
        temp.random = map.get(head.random);
        return temp;
    }
}

/**
 * A node in a singly-linked list
 */
class Node {
    Node random;
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}