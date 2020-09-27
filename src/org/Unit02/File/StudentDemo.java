package org.Unit02.File;

/**
 *  成绩排序：降序，所以要 o2 - o1
 */

import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class StudentDemo {
    public static void main(String[] args) throws IOException {
        TreeSet<Student> treeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int num =  o2.getSum() - o1.getSum();
                int num2 = num == 0 ? o2.getCScore() - o1.getCScore() : num;//总分相同，语文成绩不同。
                int num3 = num2 == 0 ? o2.getMScore() - o1.getMScore() : num2;
                int num4 = num3 == 0 ? o2.getEScore() - o1.getEScore() : num3;
                int num5 = num4 == 0 ? o2.getName().compareTo(o1.getName()) : num4;
                return num5;
            }
        });


        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.println("请输入第" + i + "个学生的信息：");
            System.out.println("姓名：");
            String name = sc.next();
            System.out.println("语文：");
            int CScore = sc.nextInt();
            System.out.println("数学：");
            int MScore = sc.nextInt();
            System.out.println("英语：");
            int EScore = sc.nextInt();

            Student student = new Student(name, CScore, MScore, EScore);

            treeSet.add(student);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\各种作业\\Score.docx"));

        bw.write("姓名，语文，数学，英语，总分");
        bw.newLine();
        bw.flush();

        // 遍历集合，把学生信息写入到文件中
        for (Student student : treeSet) {
            StringBuilder stb = new StringBuilder();
            stb.append(student.getName()).append("，").append(student.getCScore()).append("，").append(student.getMScore()).append("，").append(student.getEScore()).append("，").append(student.getSum());
            bw.write(new String(stb));
            //bw.write(stb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
