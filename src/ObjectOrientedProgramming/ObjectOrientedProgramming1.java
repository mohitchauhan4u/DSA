package ObjectOrientedProgramming;

public class ObjectOrientedProgramming1 {

    public static void main(String[] args) {
        Student s1 = new Student(1, "Mohit", 99);
        System.out.println(s1.rollNo + " " + s1.name + " " + s1.marks);
    }
}

class Student {
    int rollNo;
    String name;
    float marks;

    Student() {

    }

    Student(int rollNo, String name, float marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
}
