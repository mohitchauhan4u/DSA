package OnlineQuestions;

class ListNode{
    int val;
    int next;
    public ListNode(int val){
        this.val=val;
    }
}
class LeetCodeAddTwoNumber {

   /*
            //my wrong or error code
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2,false,null,null);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean carry,ListNode head,ListNode last) {
        if(!carry && l1==null && l2==null){
            return head;
        }else{
            if(head==null){
                head=new ListNode(( l1!=null?l1.val:0 + l2!=null?l2.val:0 + carry?1:0)%10);
                last=head;
                carry=( l1!=null?l1.val:0 + l2!=null?l2.val:0 + carry?1:0 )>=10;
                return addTwoNumbers(l1!=null?l1.next:null,l2!=null?l2.next:null,carry,head,last);
            }else{
                last.next=new ListNode(( l1!=null?l1.val:0 + l2!=null?l2.val:0 + carry?1:0)%10);
                last=last.next;
                carry=( l1!=null?l1.val:0 + l2!=null?l2.val:0 + carry?1:0 )>=10;
                return addTwoNumbers(l1!=null?l1.next:null,l2!=null?l2.next:null,carry,head,last);
            }
        }
    }*/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }


    public static void main(String[] args) {
        System.out.println(addTwoNumbers(null,null));
    }
}
