package org.Unit01.Object;

import java.util.Objects;

public class ObjectDemo1 {
    public static void main(String[] args) {
        //ObjectDemo1 obj = new ObjectDemo1();
        Object obj = new Object();
        Class c = obj.getClass();
        System.out.println(c);
        System.out.println(c.getName());

        System.out.println("--------------------------");

        ObjectDemo1 obj2 = new ObjectDemo1();
        Class c1 = obj2.getClass();
        System.out.println(c1);
        System.out.println(c1.getName());

        System.out.println("--------------------------");

        Stu s1 = new Stu("Hannah");
        Stu s2 = new Stu("Hannah");
        System.out.println(s1.equals(s2));
    }
}
class Stu {
    private String name;

    public Stu(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stu stu = (Stu) o;
        return Objects.equals(name, stu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
