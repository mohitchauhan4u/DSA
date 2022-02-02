package OnlineQuestions;

public class IntersectionOfTwoLinkedLists {
    public static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode p1=head1;
        ListNode p2=head2;
        while(p1!=null && p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        ListNode newp1;
        ListNode newp2;
        if(p1==null){
            p1=head2;
            while(p2!=null){
                p2=p2.next;
                p1=p1.next;
            }
            newp1=p1;
            newp2=head1;
        }else{
            p2=head1;
            while(p1!=null){
                p1=p1.next;
                p2=p2.next;
            }
            newp1=p2;
            newp2=head2;
        }
        while(newp1!=null ){
            if(newp1==newp2){
                return newp1;
            }
            newp1=newp1.next;
            newp2=newp2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getIntersectionNode(null,null));
    }
}
