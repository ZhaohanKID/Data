package org.Unit04.SparseArray;

public class SparseArr {
    public static void main(String[] args) {
        // 创建原始数组，一个 11*11 的数组
        // 0表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 2;
        // 输出这个原始的数组
        System.out.println("原始的二维数组：");
        for (int[] row : chessArr1) {
            for (int item : row) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
        // 将 二维数组 转为 稀疏数组
        // 1.遍历数组，得到非零数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum = " + sum);

        // 2.创建对应的稀疏数组
        int[][] sparseArr1 = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr1[0][0] = 11;
        sparseArr1[0][1] = 11;
        sparseArr1[0][2] = sum;
        // 遍历二维数组，将非0的值放到稀疏数组中
        int count = 1; // 计数器，记录稀疏数组的行下标
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr1[count][0] = i;
                    sparseArr1[count][1] = j;
                    sparseArr1[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }
        System.out.println();
        System.out.println("得到的稀疏数组是：");
        for (int i = 0; i < sparseArr1.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArr1[i][0], sparseArr1[i][1], sparseArr1[i][2]);
        }

        // 将稀疏数组恢复为原来的二维数组
        /*
            1.先读取稀疏数组第一行的数据，根据第一行的数据创建恢复的二维数组
            2.再读取稀疏数组后面的几行（从第二行开始），根据这些数据给原始数组赋值
         */
        System.out.println();
        System.out.println("恢复后的二维数组：");
        int[][] chessArr2 = new int[sparseArr1[0][0]][sparseArr1[0][1]];
        for (int i = 1; i < sparseArr1.length; i++) {
            chessArr2[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
        }
        for (int[] row : chessArr2) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}
