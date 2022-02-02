package OnlineQuestions;

public class IntersectionOfTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode newp1;
        ListNode newp2;
        if (p1 == null) {
            p1 = head2;
            while (p2 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            newp1 = p1;
            newp2 = head1;
        } else {
            p2 = head1;
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            newp1 = p2;
            newp2 = head2;
        }
        while (newp1 != null && newp2 != null) {
            if (newp1 == newp2) {
                return newp1;
            }
            newp1 = newp1.next;
            newp2 = newp2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getIntersectionNode(null, null));
        System.out.println(getIntersectionNodeAll(null, null));
    }

    public static ListNode getIntersectionNodeAll(ListNode headA, ListNode headB) {
        //takes o(n) extra space
        /* HashSet<ListNode> hs=new HashSet<>();
         while(headB!=null){
             hs.add(headB);
             headB=headB.next;
         }
         while(headA!=null){
             if(hs.contains(headA)){
                 return headA;
             }
             headA=headA.next;
         }
         return null;*/

        // O(n^2)-> worst solution
        /* while(headA!=null){
             ListNode temp=headB;
             while(temp!=null){
                 if(headA==temp){
                     return temp;
                 }
                 temp=temp.next;
             }
             headA=headA.next;
         }
         return null;*/

        //code reduced in coding blocks class question
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
