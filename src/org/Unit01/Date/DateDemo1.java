package org.Unit01.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo1 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);

        //SimpleDateFormat dateFormat = new SimpleDateFormat();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String s = dateFormat.format(date);
        System.out.println(s);

        String s2 = "2020-9-4 23:34:23";
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = dateFormat1.parse(s2);
        System.out.println(date1);
    }
}
