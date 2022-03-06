package OnlineQuestions;

public class LeetcodeListToBST {
    /**
     * Given a sorted array, convert it to a balanced binary search tree
     *
     * @param head the head of the linked list.
     * @return A tree node.
     */
    public static TreeNode sortedListToBST(ListNode head) {
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int[] nums=new int[len];
        int i=0;
        while(head!=null){
            nums[i++]=head.val;
            head=head.next;
        }
        return sortedArrayToBST(nums,0,len-1);
    }
    /**
     * Given a sorted array, convert it to a balanced binary search tree
     *
     * @param nums the sorted array
     * @param i the start index of the array
     * @param j the last index of the array
     * @return A tree node.
     */
    public static TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if(i > j) {
            return null;
        }
        int mid = (i+j)/2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = sortedArrayToBST(nums, i, mid-1);
        n.right = sortedArrayToBST(nums, mid+1, j);
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sortedListToBST(null));
    }
}


   /**
    * A tree node contains a value and references to left and right children
    */
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

