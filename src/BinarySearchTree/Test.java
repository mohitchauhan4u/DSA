package BinarySearchTree;

public class Test {
    public static void main(String[] args) {
        BSTLikeCollection b=new BSTLikeCollection();
        System.out.println("size is ->"+b.size());
        b.insert(5);
        b.insert(3);
        b.insert(8);
        b.insert(1);
        b.insert(7);
        b.insert(9);
        b.insert(10);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.printTree();
        System.out.println("size is ->"+b.size());
        b.insert(20);
        b.insert(15);
        b.insert(21);
        System.out.println("size is ->"+b.size());
        /*  b.deleteData(20);
            b.deleteData(15);
            b.deleteData(21);
            b.deleteData(6);*/
        b.deleteData(8);
        b.printTree();
        System.out.println("size is ->"+b.size());
        System.out.println(b.isPresent(20));
        System.out.println(b.isPresent(6));
    }
}
