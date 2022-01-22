package OnlineQuestions;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }

}
class LeetCodeAddTwoNumber {
    //my  code
   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2,false,null,null);
    }
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean carry,ListNode head,ListNode last) {
        if(!carry && l1==null && l2==null){
            return head;
        }else{
            if(head==null){
                head=new ListNode((( l1!=null?l1.val:0) + (l2!=null?l2.val:0) + (carry?1:0))%10);
                last=head;
            }else{
                last.next=new ListNode((( l1!=null?l1.val:0) +( l2!=null?l2.val:0) +( carry?1:0))%10);
                last=last.next;
            }
            carry=( (l1!=null?l1.val:0) + (l2!=null?l2.val:0)+ ((carry?1:0)) )>=10;
            return addTwoNumbers(l1!=null?l1.next:null,l2!=null?l2.next:null,carry,head,last);
        }
    }
    public static ListNode addTwoNumbersIterative(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        System.out.println(addTwoNumbers(null,null));
        System.out.println(addTwoNumbersIterative(null,null));
    }
}
