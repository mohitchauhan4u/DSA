package LinkedList;

import java.util.Scanner;

public class LinkedList extends DSA_450_LL {
    public static Node<Integer> swapTwoNodesOfLL(Node<Integer> head, int I, int J) {
        Node<Integer> temp1 = head;
        Node<Integer> temp2 = head;
        for (int i = 0; i < I; i++) {
            temp1 = temp1.next;
        }
        for (int i = 0; i < J; i++) {
            temp2 = temp2.next;
        }
        Node<Integer> Ith = temp1.next;
        Node<Integer> Jth = temp2.next;
        Ith.next=temp1.next.next;
        Jth.next=temp2.next.next;
        System.out.println(Ith.data);
        System.out.println(Jth.data);
        temp1.next=Jth;
        temp2.next=Ith;
        return head;
    }

    public static Node<Integer> deleteEveryNNodesAfterMNodes(Node<Integer> head, int N, int M) {
        Node<Integer> temp1 = head;
        Node<Integer> temp3 = head;
        while (temp3 != null) {
            int m = M;
            int n = N;
            while (temp1 != null && m != 0) {
                temp1 = temp1.next;
                temp3 = temp3.next;
                m--;
            }
            Node<Integer> temp2 = temp1;
            while (temp2 != null && n != 0) {
                temp2 = temp2.next;
                temp3 = temp3.next;
                n--;
            }
            temp1.next = temp2.next;
        }
        return head;
    }

    public static Node<Integer> evenAfterOddLinkedList(Node<Integer> head) {
        // incomplete
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> temp1 = null;
        Node<Integer> temp2 = null;
        Node<Integer> initialHead = null;
        while (head != null) {
            if (head.data % 2 == 0) {
                if (temp1 == null) {
                    temp1 = head;
                } else {
                    temp1.next = head;

                }
            } else {
                if (temp2 == null) {
                    temp2 = head;
                    initialHead = head;
                } else {
                    temp2.next = head;

                }
            }
            head = head.next;
        }
        temp2.next = temp1;
        return initialHead;
    }

    public static int nodeIndexInLL(Node<Integer> head, int n) {
        if (head.data == n) {
            return 0;
        }
        return 1 + nodeIndexInLL(head.next, n);
    }

    public static Node<Integer> mergeSortLL(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> mid = midPointSlowFastMethod(head);
        Node<Integer> half1 = head;
        Node<Integer> half2 = mid.next;
        mid.next = null;
        half1 = mergeSortLL(half1);
        half2 = mergeSortLL(half2);
        Node<Integer> newHead = mergeTwoSortedLL(half1, half2);
        return newHead;
    }

    public static Node<Integer> mergeTwoSortedLL(Node<Integer> head1, Node<Integer> head2) {
        /*if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.data <= head2.data) {
            Node<Integer> temp = head1.next;
            head1.next = head2;
            head2.next=mergeTwoSortedLL(head2,temp);
        }else{
            Node<Integer> temp = head2.next;
            head2.next = head1;
            head1.next =mergeTwoSortedLL(head1,temp);
    }
        return head1.data<head2.data?head1:head2;
}
*/
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node<Integer> newHead = null, newTail = null;
        if (head1.data < head2.data) {
            newHead = head1;
            newTail = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            newTail = head2;
            head2 = head2.next;
        }
        while ((head1 != null && head2 != null)) {
            if (head1.data < head2.data) {
                newTail.next = head1;
                newTail = newTail.next;
                head1 = head1.next;
            } else {
                newTail.next = head2;
                newTail = newTail.next;
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            newTail.next = head1;
        }
        if (head2 != null) {
            newTail.next = head2;
        }
        return newHead;
    }

    public static Node<Integer> reverseRecursiveBest(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> smallHead = reverseRecursive(head.next);
        Node<Integer> reversedTail = head.next;
        reversedTail.next = head;
        head.next = null;
        return smallHead;
    }

    public static Boolean palindrome(Node<Integer> head) {
        if (head == null) {
            return true;
        }
        int mid = midPointSlowFastMethod(head).data;
        Node<Integer> temp = head;
        while (temp.data != mid) {
            temp = temp.next;
        }
        temp = reverseRecursive(temp.next);
        while (temp != null) {
            if (head.data != temp.data) {
                return false;
            }
            head = head.next;
            temp = temp.next;
        }
        return true;
    }

    public static Node<Integer> appendLastNToFirst(Node<Integer> head, int N) {
        if (N == 0 || head == null) {
            return head;
        }
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        Node<Integer> initialHead = head;
        for (int i = 0; i < N; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        Node<Integer> temp = slow.next;
        slow.next = null;
        fast.next = head;
        head = temp;
        return head;
    }

    public static Node<Integer> reverseRecursive(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            Node<Integer> smallHead = reverseRecursive(head.next);
            Node<Integer> tail = smallHead;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = head;
            head.next = null;
            return smallHead;
        }
    }

    public static int midPointCountMethod(Node<Integer> head) {
        Node<Integer> temp1 = head;
        Node<Integer> temp2 = head;
        int count = 0;
        while (temp1 != null) {
            temp1 = temp1.next;
            count++;
        }
        if (count == 0) {
            System.out.println("empty linked list");
            return -1;
        } else if (count % 2 == 0) {
            int i = 1;
            while (i != count / 2) {
                i++;
                temp2 = temp2.next;
            }
            return temp2.data;
        } else {
            int i = 1;
            while (i != ((count / 2) + 1)) {
                temp2 = temp2.next;
                i++;
            }
            return temp2.data;
        }
    }

    public static Node<Integer> midPointSlowFastMethod(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node<Integer> deleteRecursive(Node<Integer> head, int pos) {
        if (head == null) {
            return null;
        }
        if (pos == 0) {
            return head.next;
        } else {
            head.next = deleteRecursive(head.next, pos - 1);
            return head;
        }
    }

    public static Node<Integer> delete(Node<Integer> head, int data) {
        Node<Integer> temp = head;
        Node<Integer> tail = head;

        if (head.data == data) {
            head = head.next;
            return head;
        } else {
            temp = temp.next;
            while (temp.data != data) {
                temp = temp.next;
                tail = tail.next;
            }
            tail.next = temp.next;
            return head;
        }
    }

    public static Node<Integer> insert(Node<Integer> head) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data to be inserted");
        int data = sc.nextInt();
        System.out.println("Enter position at which data is to be inserted");
        int pos = sc.nextInt();
        Node<Integer> newNode = new Node<>(data);
        Node<Integer> temp = head;
        int t = 0;
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }
        while (t < pos - 1) {
            temp = temp.next;
            t++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public static Node<Integer> insertRecursive(Node<Integer> head, int data, int pos) {
        if (head == null && pos > 0) {
            return head;
        }
        if (pos == 0) {
            Node<Integer> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
            return head;
        } else {
            head.next = insertRecursive(head.next, data, pos - 1);
            return head;
        }
    }

    public static Node<Integer> takeInput() {
        System.out.println("Enter the data in the liked list");
        Node<Integer> head = null, tail = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        while (data != -1) {
            if (head == null) {
                Node<Integer> newNode = new Node<>(data);
                head = newNode;
                tail = newNode;
            } else {
                Node<Integer> newNode = new Node<>(data);
                tail.next = newNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printRecursive(Node<Integer> head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        printRecursive(head.next);
    }

    public static void printReverse(Node<Integer> head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);
        System.out.print(head.data + " ");
    }

    //main method
    public static void main(String[] args) {
        //        Node<Integer> head1 = takeInput();
        //        Node<Integer> head2 = takeInput();
        //print(head);
        /*    public static int midPointNotCountMethod(Node<Integer> head){
        Node<Integer> fast=head;
        Node<Integer> slow=head;
        Node<Integer> tail=head;
        while(fast!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.data;
    }
        head1=delete(head1,7);
         head1=insert(head1);
                System.out.println(midPointNotCountMethod(head1));
        System.out.println(midPointCountMethod(head1));
        print(head1);
       head = insertNodeAtPosition(head,  1233,  2);
        print(head);
        insertRecursive(head,23,0);
        insertRecursive(head,123,4);
        printRecursive(head);
        System.out.println();
        printReverse(head);
        head=reverseRecursive(head);
        System.out.println(midPointSlowFastMethod(head));
        print(deleteRecursive(head, 5));*/
        //print(reverseRecursive(head));
//        print(moveLastElementToFrontOfAGivenLinkedList(head));
//        print(removeDuplicatesSorted(head));
//        print(removeDuplicatesUnSorted(head));
        //print(appendLastNToFirst(head,4));
        //System.out.println(palindrome(head));
        //print(mergeTwoSortedLL(head1,head2));
        Node<Integer> head = takeInput();
        print(head);
        // print(evenAfterOddLinkedList(head));
       // print(deleteEveryNNodesAfterMNodes(head, 2, 2));
        print(swapTwoNodesOfLL(head,3,4));
    }
}