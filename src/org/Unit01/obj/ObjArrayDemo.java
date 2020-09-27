package org.Unit01.obj;

public class ObjArrayDemo {
    public static void main(String[] args) {
        //声明一个对象数组，里面有三个对象
        PersonArr personArr[] = new PersonArr[3];
        System.out.println("-----------数组声明----------");
        for (int i = 0; i < personArr.length; i++) {
            System.out.println(personArr[i] + "、");
        }

        personArr[0] = new PersonArr("张三");
        personArr[1] = new PersonArr("李四");
        personArr[2] = new PersonArr("赵六");
        System.out.println("\n-------------对象实例化------------");
        for (int i = 0; i < personArr.length; i++) {
            System.out.println(personArr[i].getName() + "、");
        }
    }
}
class PersonArr {
    private String name;

    public PersonArr(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
