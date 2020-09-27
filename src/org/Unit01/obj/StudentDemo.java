package org.Unit01.obj;

public class StudentDemo {
    public static void main(String[] args) {
        Student student = new Student("01196023", "Hannah", 90, 98, 87);
        System.out.println("三门课总分：" + student.sum() + "\n三门课平均分：" + student.ave() + "\n三门课最高分：" + student.max());
    }
}
class Student {
    //成员变量
    private String id;
    private String name;
    private float math;
    private float english;
    private float computer;

    //构造方法
    public Student() {
    }

    public Student(String id, String name, float math, float english, float computer) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.english = english;
        this.computer = computer;
    }

    //get set 方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getEnglish() {
        return english;
    }

    public void setEnglish(float english) {
        this.english = english;
    }

    public float getComputer() {
        return computer;
    }

    public void setComputer(float computer) {
        this.computer = computer;
    }

    //成员方法
    public float sum() {
        return getMath() + getEnglish() + getComputer();
    }

    public float ave() {
        return this.sum() / 3;
    }

    public float max() {
        float m = 0;
        if (getMath() > m) {
            m = getMath();
        }
        if (getEnglish() > m) {
            m = getEnglish();
        }
        if (getComputer() > m) {
            m = getComputer();
        }
        return m;
    }
}
