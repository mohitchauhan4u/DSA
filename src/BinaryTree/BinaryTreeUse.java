package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

    public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        if (root.data == x) {
            ArrayList<Integer> output = new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }
        ArrayList<Integer> leftOutput = nodeToRootPath(root.left, x);
        if (!leftOutput.isEmpty()) {
            leftOutput.add(root.data);
            return leftOutput;
        }
        ArrayList<Integer> rightOutput = nodeToRootPath(root.right, x);
        if (!rightOutput.isEmpty()) {
            rightOutput.add(root.data);
            return rightOutput;
        }
        return new ArrayList<>();
    }

    public static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preOrder[preStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootVal);
        int k = 0;
        // error from here
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inOrder[i]) {
                k = i;
                break;
            }
        }
        root.left = buildTreeHelper(preOrder, preStart + 1, preStart + (k - inStart), inOrder, inStart, k - 1);
        root.right = buildTreeHelper(preOrder, preStart + (k - inStart), preEnd, inOrder, k - 1, inEnd);
        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        int n = preOrder.length;
        int preStart = 0;
        int preEnd = n - 1;
        int inStart = 0;
        int inEnd = n - 1;
        return buildTreeHelper(preOrder, preStart, preEnd, inOrder, inStart, inEnd);
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> front = queue.poll();
            System.out.print(front.data + " ");
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data");
        int data = sc.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        Queue<BinaryTreeNode<Integer>> pendingChild = new LinkedList<BinaryTreeNode<Integer>>();
        pendingChild.add(root);
        while (!pendingChild.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChild.poll();
            System.out.println("Enter the left child of " + front.data);
            int left = sc.nextInt();
            if (left != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                front.left = leftChild;
                pendingChild.add(leftChild);
            }
            System.out.println("Enter the right child of " + front.data);
            int right = sc.nextInt();
            if (right != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                front.right = rightChild;
                pendingChild.add(rightChild);
            }
        }
        return root;
    }

    public static int diameterOfTreeBetter(BinaryTreeNode<Integer> root) {
        BinaryTreeDiameterClass ans = diameterOfTreeBetterHelper(root);
        return ans.diameter;
    }

    public static BinaryTreeDiameterClass diameterOfTreeBetterHelper(BinaryTreeNode<Integer> root) {
        //O(n)
        if (root == null) {
            BinaryTreeDiameterClass ans = new BinaryTreeDiameterClass(0, 0);
            return ans;
        }
        BinaryTreeDiameterClass leftPart = diameterOfTreeBetterHelper(root.left);
        BinaryTreeDiameterClass rightPart = diameterOfTreeBetterHelper(root.right);
        int longestDistance = leftPart.height + rightPart.height + 1;
        int diameter = Math.max(leftPart.diameter, Math.max(rightPart.diameter, longestDistance));
        int height = Math.max(leftPart.height, rightPart.height) + 1;
        return (new BinaryTreeDiameterClass(height, diameter));
    }

    public static int diameterOfTree(BinaryTreeNode<Integer> root) {
        //O(nlog(n))
        if (root == null) {
            return 0;
        }
        int case1 = heightOfTree(root.left) + heightOfTree(root.right);
        int case2 = diameterOfTree(root.left);
        int case3 = diameterOfTree(root.right);
        return Math.max(case1, Math.max(case2, case3));
    }

    public static BinaryTreeReturn isTreeBalancedBetter(BinaryTreeNode<Integer> root) {
        // O(n)
        if (root == null) {
            int height = 0;
            boolean isBalanced = true;
            BinaryTreeReturn ans = new BinaryTreeReturn();
            ans.isBalanced = isBalanced;
            ans.height = height;
            return ans;
        }
        BinaryTreeReturn leftOutput = isTreeBalancedBetter(root.left);
        BinaryTreeReturn rightOutput = isTreeBalancedBetter(root.right);
        boolean isBalanced = true;
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);
        if (Math.abs(leftOutput.height - rightOutput.height) > 1) {
            isBalanced = false;
        }
        if (!leftOutput.isBalanced || !rightOutput.isBalanced) {
            isBalanced = false;
        }
        BinaryTreeReturn ans = new BinaryTreeReturn();
        ans.height = height;
        ans.isBalanced = isBalanced;
        return ans;
    }

    public static boolean isTreeBalanced(BinaryTreeNode<Integer> root) {
        // O(nlog(n))
        if (root == null) {
            return true;
        }
        if (Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) > 1) {
            return false;
        }
        return isTreeBalanced(root.left) && isTreeBalanced(root.right);
    }

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode<Integer> tempLeft = root.left;
        root.left = root.right;
        root.right = tempLeft;
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
        //or
//        mirrorBinaryTree(root.left);
//        mirrorBinaryTree(root.right);
//        BinaryTreeNode<Integer> tempLeft= root.left;
//        root.left = root.right;
//        root.right = tempLeft;
    }

    public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);
        return root;
    }

    public static void nodesWithoutAnySibling(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right != null) {
            System.out.print(root.right.data + " ");
        } else if (root.left != null && root.right == null) {
            System.out.print(root.left.data + " ");
        }
        nodesWithoutAnySibling(root.left);
        nodesWithoutAnySibling(root.right);
    }

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int X) {
        if (root == null) {
            return false;
        }
        if (root.data == X) {
            return true;
        }
        return (isNodePresent(root.left, X) || isNodePresent(root.right, X));
    }

    public static void replaceNodesWithDepthHelper(BinaryTreeNode<Integer> root, int level) {
        if (root == null) {
            return;
        }
        root.data = level;
        replaceNodesWithDepthHelper(root.left, level + 1);
        replaceNodesWithDepthHelper(root.right, level + 1);
    }

    public static void replaceNodesWithDepth(BinaryTreeNode<Integer> root) {
        replaceNodesWithDepthHelper(root, 0);
    }

    public static void printAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + " ");
        }
        printAtDepthK(root.left, k - 1);
        printAtDepthK(root.right, k - 1);
    }

    public static int numberOfLeafNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return numberOfLeafNodes(root.right) + numberOfLeafNodes(root.left);
    }

    public static int greaterThanX(BinaryTreeNode<Integer> root, int X) {
        if (root == null) {
            return 0;
        }
        int count = (root.data > X) ? 1 : 0;
        if (root.left != null) {
            count += greaterThanX(root.left, X);
        }
        if (root.right != null) {
            count += greaterThanX(root.right, X);
        }
        return count;
        // Need to know reason for wrong output
        //return (root.data>X)?1:0 + greaterThanX(root.left,X)+greaterThanX(root.right,X);


    }

    public static int heightOfTree(BinaryTreeNode<Integer> root) {
        /*if (root == null) {
            return 0;
        }
        int height = 1;
        if (root.left != null) {
            height += heightOfTree(root.left);
        }
        if (root.right != null) {
            height += heightOfTree(root.right);
        }
        if(root.left!=null && root.right!=null){
            height--;
        }
        return height;*/

        //or
        if (root == null) {
            return 0;
        }
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }

    public static int largest(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }
        return Math.max(largest(root.left), Math.max(largest(root.right), root.data));
    }

    public static int sumOfNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    public static int numberOfNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int numberOfLeftNodes = numberOfNodes(root.left);
        int numberOfRightNodes = numberOfNodes(root.right);
        return 1 + numberOfLeftNodes + numberOfRightNodes;
    }

    public static BinaryTreeNode<Integer> takeTreeInput(boolean isRoot, int parentData, boolean isLeftChild) {
        if (isRoot) {
            System.out.println("Enter root data");
        } else {
            if (isLeftChild) {
                System.out.println("Enter left child of " + parentData);
            } else {
                System.out.println("Enter right child of " + parentData);
            }
        }
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        BinaryTreeNode<Integer> leftChild = takeTreeInput(false, data, true);
        BinaryTreeNode<Integer> rightChild = takeTreeInput(false, data, false);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static void printTreePre(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTreePre(root.left);
        printTreePre(root.right);
    }

    public static void printTreeIn(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        printTreeIn(root.left);
        System.out.print(root.data + " ");
        printTreeIn(root.right);
    }

    public static void printTreePost(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        printTreePost(root.left);
        printTreePost(root.right);
        System.out.print(root.data + " ");
    }

    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ":");
        if (root.left != null) {
            System.out.print("L" + root.left.data + ", ");
        }
        if (root.right != null) {
            System.out.print("R" + root.right.data + " ");
        }
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeInput(true, 0, true);
        // BinaryTreeNode<Integer> root = takeInputLevelWise();
        printTreeDetailed(root);
        System.out.println("Number of nodes is " + numberOfNodes(root));
        System.out.println("Sum of all roots is " + sumOfNodes(root));
        ArrayList<Integer> path = nodeToRootPath(root, 5);
        for (int i : path) {
            System.out.print(i + "->");
        }
/*      printTreePre(root);
        System.out.println();
        printTreeIn(root);
        System.out.println();
        printTreePost(root);
        System.out.println("Largest is -> " + largest(root));
        System.out.println("Number of nodes greater than X are -> " + greaterThanX(root, 5));
        System.out.println("Height of tree is -> "+heightOfTree(root));
        System.out.println("Number of Leaf Nodes -> " + numberOfLeafNodes(root));
        System.out.println("Print at depth 2 -->");
        printAtDepthK(root, 2);
        replaceNodesWithDepth(root);
        System.out.println();
        printTreeIn(root);
        System.out.println(isNodePresent(root, 7));
        nodesWithoutAnySibling(root);
        BinaryTreeNode<Integer> newRoot=removeLeafNodes(root);
        printTreeDetailed(newRoot);
        mirrorBinaryTree(root);
        printTreeDetailed(root);
        System.out.println("Is tree balanced->" + isTreeBalancedBetter(root).isBalanced);
        System.out.println("Diameter of tree is-->" + diameterOfTree(root));
        System.out.println("Diameter of tree is-->" + diameterOfTreeBetter(root));
        printLevelWise(root);
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        BinaryTreeNode<Integer> r = buildTree(pre, in);
         printTreeDetailed(r);*/
    }
}
