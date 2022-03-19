package BinarySearchTree;

import LinkedList.Node;

import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearchTree {


    public static ArrayList<Integer> nodeToRootPathInBST(BinarySearchTreeNode<Integer> root, int x) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        if (root.data == x) {
            ArrayList<Integer> output = new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }
        if (root.data > x) {
            ArrayList<Integer> leftOutput = nodeToRootPathInBST(root.left, x);
            if (!leftOutput.isEmpty()) {
                leftOutput.add(root.data);
            }
            return leftOutput;
        } else if (root.data < x) {
            ArrayList<Integer> rightOutput = nodeToRootPathInBST(root.right, x);
            if (!rightOutput.isEmpty()) {
                rightOutput.add(root.data);
            }
            return rightOutput;
        }
        return new ArrayList<>();
    }

    public static Node<Integer> BSTToLLSorted(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        BSTToLLSorted(root.left);
        Node<Integer> head = new Node<>(root.data);
        head.next = new Node<>(root.left.data);
        head.next = new Node<>(root.right.data);
        BSTToLLSorted(root.right);
        return head;
    }

    public static int largest(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.max(largest(root.left), Math.max(largest(root.right), root.data));
    }

    public static int maximum(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.right == null) {
            return root.data;
        }
        return maximum(root.right);
    }

    public static int minimum(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
//        return Math.min(root.data,Math.min(minimum(root.left),minimum(root.right)));
        if (root.left == null) {
            return root.data;
        }
        return minimum(root.left);
    }

    public static boolean isBST(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        int leftMax = maximum(root.left);
        int rightMin = minimum(root.right);


        if (root.left != null && leftMax >= root.data) {
            System.out.println("left error " + leftMax);
            return false;
        }
        if (root.right != null && rightMin <= root.data) {
            System.out.println("right error " + rightMin);
            return false;
        }
        boolean isLeftBST = isBST(root.left);
        boolean isRightBST = isBST(root.right);
        return isLeftBST && isRightBST;
    }

    public static BinarySearchTreeNode<Integer> sortedArrayToBSTHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        BinarySearchTreeNode<Integer> temp = new BinarySearchTreeNode<Integer>(arr[mid]);
        temp.left = sortedArrayToBSTHelper(arr, start, mid - 1);
        temp.right = sortedArrayToBSTHelper(arr, mid + 1, end);
        return temp;
    }

    public static BinarySearchTreeNode<Integer> sortedArrayToBST(int[] arr) {
        return sortedArrayToBSTHelper(arr, 0, arr.length - 1);
    }

    public static boolean search(BinarySearchTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        if (x == root.data) {
            return true;
        } else if (x > root.data) {
            return search(root.right, x);
        } else {
            return search(root.left, x);
        }
    }

    public static void elementBetweenK1andK2(BinarySearchTreeNode<Integer> root, int k1, int k2) {
        if (root == null) {
            return;
        }
        //assuming k2>k1
        if (root.data >= k1 && root.data <= k2) {
            elementBetweenK1andK2(root.left, k1, k2);
            System.out.print(root.data + " ");
            elementBetweenK1andK2(root.right, k1, k2);
        } else if (root.data > k2) {
            elementBetweenK1andK2(root.left, k1, k2);
        } else if (root.data < k1) {
            elementBetweenK1andK2(root.right, k1, k2);
        }
    }

    public static void insert(BinarySearchTreeNode<Integer> root, int data) {
        if (data > root.data) {
            if (root.right == null) {
                root.right = new BinarySearchTreeNode<Integer>(data);
                return;
            }
            insert(root.right, data);
        }
        if (data < root.data) {
            if (root.left == null) {
                root.left = new BinarySearchTreeNode<Integer>(data);
                return;
            }
            insert(root.left, data);
        }
    }

    public static BinarySearchTreeNode<Integer> takeInputOfBST() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data of BinarySearchTree");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(data);
        System.out.println("Enter data of next element of BinarySearchTree");
        data = sc.nextInt();
        while (data != -1) {
            insert(root, data);
            System.out.println("Enter data of next element of BinarySearchTree");
            data = sc.nextInt();
        }
        return root;
    }

    public static BinarySearchTreeNode<Integer> takeTreeInput(boolean isRoot, int parentData, boolean isLeftChild) {
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
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<Integer>(data);
        BinarySearchTreeNode<Integer> leftChild = takeTreeInput(false, data, true);
        BinarySearchTreeNode<Integer> rightChild = takeTreeInput(false, data, false);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static void printTreeDetailed(BinarySearchTreeNode<Integer> root) {
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

    public static void printTreePre(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTreePre(root.left);
        printTreePre(root.right);
    }

    public static void main(String[] args) {
        // BinarySearchTreeNode<Integer> root = takeInputOfBST();
        BinarySearchTreeNode<Integer> root = takeTreeInput(true, 0, true);
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        BinarySearchTreeNode<Integer> root = sortedArrayToBST(arr);
       /*  System.out.println(search(root, 12));
       printTreePre(root);
        System.out.println();
        elementBetweenK1andK2(root, 3, 8);
        System.out.println();
        System.out.println(minimum(root));
        System.out.println(maximum(root));*/
        System.out.println(isBST(root));
//        printTreeDetailed(root);
//        ArrayListClass<Integer> path=nodeToRootPathInBST(root,2);
//        System.out.println(path);
    }
}
