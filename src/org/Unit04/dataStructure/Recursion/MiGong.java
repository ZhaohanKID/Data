package org.Unit04.dataStructure.Recursion;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/24 15:07
 */
public class MiGong {
    public static void main(String[] args) {
        // 画地图，1代表墙，不能走
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        System.out.println("新的地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    // 使用递归回溯来给小球找路

    /**
     * 1. map表示地图
     * 2. i,j表示从地图的哪个位置出发
     * 3. 如果小球能到 map[6][5]，说明通路找到
     * 4. 约定：当 map[i][j] 为0表示该点没有走过，1为墙，2表示通路可以走，3表示该点已经走过但是走不通
     * 5. 策略：按照 下-右-上-左 的方式走
     * @param map 地图
     * @param i 当前小球的位置坐标
     * @param j
     * @return 如果找到通路，就返回 true，否则返回false、
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 通路已经找到 OK
            return true;
        } else {
            if (map[i][j] == 0) { // 如果当前这个点还没有走过
                // 按照策略，下-右-上-左
                map[i][j] = 2; // 假定该路可以走通
                if (setWay(map, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { // 向上走
                    return true;
                } else if (setWay(map, i, j - 1)) { // 向左走
                    return true;
                } else {
                    // 说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果 map[i][j] != 0，可能是 1 2 3，这三个都没必要再走一遍了
                return false;
            }
        }
    }
}
