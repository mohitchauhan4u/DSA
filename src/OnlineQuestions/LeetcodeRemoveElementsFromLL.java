package OnlineQuestions;

public class LeetcodeRemoveElementsFromLL {
    public static ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            head.next = removeElements1(head.next, val);
            return head.next;
        } else {
            head.next = removeElements1(head.next, val);
            return head;
        }
    }

    public static ListNode removeElements2(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null)
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(removeElements1(null, -1));
        System.out.println(removeElements2(null, -1));
    }


}

