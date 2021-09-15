package BinarySearchTree;

public class BSTLikeCollection {
    private static int size;
    private BinarySearchTreeNode<Integer> root;

    private static boolean isPresentHelper(BinarySearchTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        if (x == root.data) {
            return true;
        } else if (x > root.data) {
            return isPresentHelper(root.right, x);
        } else {
            return isPresentHelper(root.left, x);
        }
    }

    private static void insertHelper(BinarySearchTreeNode<Integer> root, int data) {
        if (data > root.data) {
            if (root.right == null) {
                root.right = new BinarySearchTreeNode<Integer>(data);
                size++;
                return;
            }
            insertHelper(root.right, data);
        }
        if (data < root.data) {
            if (root.left == null) {
                root.left = new BinarySearchTreeNode<Integer>(data);
                size++;
                return;
            }
            insertHelper(root.left, data);
        }
    }

    public static BinarySearchTreeNode<Integer> deleteDataHelper(BinarySearchTreeNode<Integer> root, int x) {
        if (root == null) {
            return null;
        }
        if (root.data > x) {
            root.left = deleteDataHelper(root.left, x);
            return root;
        } else if (root.data < x) {
            root.right = deleteDataHelper(root.right, x);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                size--;
                return null;
            } else if (root.left == null) {
                size--;
                return root.right;
            } else if (root.right == null) {
                size--;
                return root.left;
            } else {
                BinarySearchTreeNode<Integer> minNode = root.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                root.data = minNode.data;
                root.right = deleteDataHelper(root.right, minNode.data);
                return root;
            }
        }
    }

    private static void printTreeHelper(BinarySearchTreeNode<Integer> root) {
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
        printTreeHelper(root.left);
        printTreeHelper(root.right);
    }

    public boolean isPresent(int x) {
        return isPresentHelper(root, x);
    }

    public void insert(int x) {
        if (root == null) {
            root = new BinarySearchTreeNode<Integer>(x);
            size++;
        } else {
            insertHelper(root, x);
        }
    }

    public void deleteData(int x) {
        root = deleteDataHelper(root, x);
    }

    public int size() {
        return size;
    }

    public void printTree() {
        if (root == null) {
            return;
        } else {
            printTreeHelper(root);
        }

    }
}
