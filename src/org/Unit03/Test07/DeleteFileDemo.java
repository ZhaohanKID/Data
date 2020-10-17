package org.Unit03.Test07;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/15 18:40
 */
public class DeleteFileDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();

        // 设置指定时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse("2020-10-15 19:04:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timer.schedule(new DeleteTask(timer), date);

        // timer.schedule(new DeleteTask(timer), 5000);
    }
}
class DeleteTask extends TimerTask {
    private Timer timer;

    public DeleteTask(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        File file = new File("D:\\各种作业\\1");
        delDir(file);
        timer.cancel();
    }
    public static void delete(File file) {
        file.delete();
    }
    public static void delDir(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    delDir(f);
                } else {
                    delete(f);
                }
            }
            // 删除文件夹
            file.delete();
        }
    }
}
