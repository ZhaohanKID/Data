package org.Unit04.SparseArray;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class SparseArray2 {
    public static void main(String[] args) throws IOException {
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

        Writer writer = new FileWriter("map.txt");
        for (int[] row : sparseArr1) {
            for (int item : row) {
                writer.write((char)item);
            }
        }
        writer.close();
    }
}
