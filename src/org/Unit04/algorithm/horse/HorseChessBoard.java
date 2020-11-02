package org.Unit04.algorithm.horse;

import java.awt.*;
import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/30 20:53
 */
public class HorseChessBoard {
    private static int X; // 列数
    private static int Y; // 行数
    // 创建一个数组，标记棋盘的各个位置是否被访问过
    private static boolean visited[];
    // 使用一个属性，标记是否棋盘的所有位置都被访问过
    private static boolean finished;

    public static void main(String[] args) {
        System.out.println("计算中...");
        // 测试
        X = 8;
        Y = 8;
        int row = 1;// 马初始位置的行，从1开始
        int column = 1;
        // 创建棋盘
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y]; // 初始默认为false
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "毫秒");

        // 输出棋盘的最后位置
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 完成骑士周游问题的核心代码
     * @param chessboard 棋盘
     * @param row 马所在的位置
     * @param column
     * @param step 马走的第几步，初始位置是第一步
     */
    public static void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        // row * X + column算出当前位置在整个二维棋盘的第几个
        // 因为visited是用一维数组来表示的
        visited[row * X + column] = true;// 标记该位置已经访问
        // 获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(column, row));
        // 对ps进行排序，排序的规则就是对ps的
        // 所有Point对象的下一步位置的数目，进行非递减排序
        sort(ps);
        // 遍历ps
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);//取出一个可以走的位置
            // 判断该点是否已经访问过
            if (!visited[p.y * X + p.x]) {
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }
        /*
        step < X * Y 可能处于两种状态
        1 棋盘还没有走完
        2 走完了，回溯过程中
         */
        if (step < X * Y && !finished) {
            // 这一点走不通，所以说要把这个第几步走的置为0，也就是还没走过
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    /**
     * 根据当前位置，计算还能走哪些位置
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> ps = new ArrayList<Point>();
        // 创建一个点
        Point p1 = new Point();
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            /*
                Point(Point p)
             构造并初始化一个与指定的 Point 对象具有相同位置的点。
             不能直接添加进去p1 吗？？？
             */
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }

        return ps;
    }

    // 根据当前这一步的所有下一步的选择位置，进行非递减排序
    // 减少回溯次数
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = next(o1).size();
                int count2 = next(o2).size();

                if (count1 < count2) {
                    return -1;
                } else if (count1 == count2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }
}
