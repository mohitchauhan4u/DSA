package OnlineQuestions;
import java.util.Stack;
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


    public static  ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        Stack<Integer> s2=new Stack<>();
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode head=null;
        while(carry!=0 || !s1.isEmpty() || !s2.isEmpty()){
            int val1=s1.isEmpty()?0:s1.pop();
            int val2=s2.isEmpty()?0:s2.pop();
            int sum=(val1+val2+carry)/10;
            if(head==null){
                head=new ListNode(sum);
            }else{
                ListNode newNode=new ListNode(sum);
                newNode.next=head;
                head=newNode;
            }
            carry=sum%10;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(null,null));
        System.out.println(addTwoNumbersIterative(null,null));
        System.out.println(addTwoNumbersReverse(null,null));
    }
}
