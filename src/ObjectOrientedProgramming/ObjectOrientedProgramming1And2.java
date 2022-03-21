package ObjectOrientedProgramming;

public class ObjectOrientedProgramming1And2 {

    public static void main(String[] args) {
        Student s1 = new Student(1, "Mohit", 99);
        Student s2 = new Student();
        System.out.println(s1.rollNo + " " + s1.name + " " + s1.marks);
        System.out.println(s2.rollNo + " " + s2.name + " " + s2.marks);
        int u;
        //System.out.println(u);
        u=5;
    }

    public static void check(int x) {
        int u;
//        System.out.println(u);
    }
}

class Student {
    int rollNo = 10;
    String name = "kuch na";
    float marks = 34;

    Student() {
        // this(23,"default",100);
    }

    Student(int rollNo, String name, float marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
}
