package OnlineQuestions;

public class LeetcodeLCA {
    public static TreeNode lowestCommonAncestorFast(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q){
            return root==p?p:q;
        }
        if(root==null){
            return null;
        }
        TreeNode left= lowestCommonAncestorFast(root.left,p,q);
        TreeNode right= lowestCommonAncestorFast(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        else if(left!=null){
            return left;
        }else{
            return right;
        }
    }

    public static  TreeNode lowestCommonAncestorSlow(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val==p.val || root.val==q.val){
            return root.val==p.val?p:q;
        }
        if(search(root.left,p) && search(root.left,q)){
            return lowestCommonAncestorSlow(root.left,p,q);
        }else if(search(root.right,p) && search(root.right,q)){
            return lowestCommonAncestorSlow(root.right,p,q);
        }else{
            return root;
        }
    }
    public static  boolean search(TreeNode root,TreeNode r2){
        if(root==null){
            return false;
        }
        if(root.val==r2.val){
            return true;
        }
        return search(root.left,r2) || search(root.right,r2);
    }

    public static void main(String[] args) {

    }
}
