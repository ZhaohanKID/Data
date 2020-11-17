package org.Unit07.timu;

import java.applet.Applet;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/13 0:32
 */
public class MyClass extends Applet implements MyInter {
    @Override
    public int method1(int x) {
        return (int) Math.pow(5, x);
    }

    @Override
    public int method2(int x, int y) {
        return Math.max(x, y);
    }

    public void paint() {
        System.out.println(method1(2));
        System.out.println(method2(2, 8));
    }

    public static void main(String[] args) {
        new MyClass().paint();
    }

/*
    public static void main(String[] args) {
        int res1 = new MyClass().paint(new MyInter() {
            @Override
            public int method1(int x) {
                return (int) Math.pow(5, x);
            }

            @Override
            public int method2(int x, int y) {
                return Math.max(x, y);
            }
        });
        System.out.println(res1);
    }
*/

}
