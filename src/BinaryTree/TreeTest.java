package BinaryTree;
public class TreeTest {
    public static void main(String[] args) {

        BinaryTreeUse bt=new BinaryTreeUse();
        BinaryTreeNode<Integer> root=bt.takeTreeInput(true,0,false);
        bt.printTreeDetailed(root);
    }
}
