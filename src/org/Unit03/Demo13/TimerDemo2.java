package org.Unit03.Demo13;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/27 17:07
 */
public class TimerDemo2 {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();

        String time = "2020-9-27 17:32:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(time); // 解析时间。

        timer.schedule(new delFile(), date);
    }
}

// 定义一个类写我们的任务。
class delFile extends TimerTask {

    @Override
    public void run() {
        File file = new File("E:\\test");
        delFolder(file);
    }

    // 使用递归删除文件夹
    public static void delFolder(File file) {

        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    delFolder(f);
                } else {
                    f.delete();
                }
            }
            // 将file底下的内容删除完之后，还要将file也删除掉。
            file.delete();
        }
    }
}
