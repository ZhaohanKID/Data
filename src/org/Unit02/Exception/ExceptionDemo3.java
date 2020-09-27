package org.Unit02.Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo3 {
    public static void main(String[] args) {
        String s = "2020-8-16";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(s);
        } catch (ParseException e) {
            System.out.println(e.getMessage());//Unparseable date: "2020-8-16"
            System.out.println(e.toString());//java.text.ParseException: Unparseable date: "2020-8-16"
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
