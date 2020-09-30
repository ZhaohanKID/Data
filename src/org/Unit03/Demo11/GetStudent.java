package org.Unit03.Demo11;

public class GetStudent implements Runnable {
    private Student student;

    public GetStudent(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        //Student s = new Student();
        while (true) {
            student.get();
        }
    }
}
