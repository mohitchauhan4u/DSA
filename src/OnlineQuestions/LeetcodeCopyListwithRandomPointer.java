package OnlineQuestions;

public class LeetcodeCopyListwithRandomPointer {
    public static void main(String[] args) {
        copyLLWithRandomPointer(null);
    }
    public static Node copyLLWithRandomPointer(Node head){

        return null;
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