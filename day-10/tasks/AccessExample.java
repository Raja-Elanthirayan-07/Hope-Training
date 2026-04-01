package tasks;
class Student {
    private String name = "Jonathan";
    int age = 20;
    protected String dept = "CSE";
    public int rollNo = 101;

    private void showName() {
        System.out.println(name);
    }

    void showAge() {
        System.out.println(age);
    }

    protected void showDept() {
        System.out.println(dept);
    }

    public void showRollNo() {
        System.out.println(rollNo);
    }

    public void display() {
        showName();
        showAge();
        showDept();
        showRollNo();
    }
}

public class AccessExample {
    public static void main(String[] args) {
        Student s = new Student();

        s.display();
        s.showAge();
        s.showDept();
        s.showRollNo();
    }
}