package org.Unit04.algorithm.prim;

import java.util.Arrays;
import java.util.GregorianCalendar;

/**
 *  普里姆算法解决修路路径最短问题
 * @Author: Z.HAN
 * @Date: 2020/10/30 14:58
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        // 测试图
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        // 邻接矩阵的关系使用二维数组表示
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}};
        // 创建图对象
        MGraph graph = new MGraph(7);
        // 创建miniTree对象
        MiniTree miniTree = new MiniTree();
        miniTree.createGraph(graph, verxs, data, weight);
        miniTree.showGraph(graph);

        miniTree.prim(graph, 0);
        System.out.println("------------");
        miniTree.prim(graph, 1);
    }
}

// 创建最小生成树
class MiniTree {
    // 创建图的邻接矩阵

    /**
     *
     * @param graph 图对象
     * @param verxs 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }
    // 显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] ints : graph.weight) {
            System.out.println(Arrays.toString(ints));
        }
    }
    // 编写prim算法，生成最小生成树
    public void prim(MGraph graph, int v) {
        // 标记节点是否被访问过得数组，默认全是0
        int[] visited = new int[graph.verxs];
        visited[v] = 1;
        // h1 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int k = 1; k < graph.verxs; k++) {
            /*
            确定每一次生成的子图和哪个节点的距离最近
            这里有点懂了，这两层循环结束之后，才会找出权值最小的那个
            非常对啊！！
             */
            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            // 找到一条边是最小
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值" + minWeight);
            // 将当前这个节点标记为已经访问
            visited[h2] = 1;
            // 重置minWeight
            minWeight = 10000;
        }
    }
}

// 写一个图
class MGraph {
    int verxs; //节点个数
    char[] data; // 存放节点数据，村庄 A
    int[][] weight; // 邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
