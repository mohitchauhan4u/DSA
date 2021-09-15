package LinkedList;

public class DSA_450_LL {
    public static Node<Integer> moveLastElementToFrontOfAGivenLinkedList(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }

    public static Node<Integer> removeDuplicatesSorted(Node<Integer> head) {
        if (head == null && head.next == null) {
            return head;
        }
        Node temp1 = head;

        while (temp1 != null && temp1.next != null) {
            if (temp1.data == temp1.next.data) {
                temp1.next = temp1.next.next;
            } else {
                temp1 = temp1.next;
            }
        }
        return head;
    }

    public static Node<Integer> removeDuplicatesUnSorted(Node<Integer> head)
    {
        if(head==null || head.next==null){
            return head;
        }
        Node<Integer> temp1=head;
        while(temp1.next!=null && temp1!=null){
            Node<Integer> temp2=temp1;
            while(temp2.next!=null && temp2!=null){
                if(temp1.data==temp2.next.data){
                    temp2.next=temp2.next.next;
                }else{
                    temp2=temp2.next;
                }
            }
            temp1=temp1.next;
        }
        return head;
    }
}

