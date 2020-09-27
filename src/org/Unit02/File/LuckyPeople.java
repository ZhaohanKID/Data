package org.Unit02.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 从名单中获取随机人名。
 */

public class LuckyPeople {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\各种作业\\1.txt"));
        ArrayList<String> arrayList = new ArrayList<>();
        String line = null;
        while ((line = br.readLine()) != null) {
            arrayList.add(line);
        }
        /*Collections.shuffle(arrayList);
        System.out.println(arrayList.get(0));*/
        //产生一个随机数
        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        System.out.println(arrayList.get(index));
    }
}
