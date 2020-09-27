package org.Unit01.Date;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 根据用户输入的年份，输出该年2月有多少天
 */

public class CalenderDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        Calendar c = Calendar.getInstance();
        c.set(year, 2, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
    }
}
