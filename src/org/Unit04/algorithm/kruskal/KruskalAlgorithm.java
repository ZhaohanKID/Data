package org.Unit04.algorithm.kruskal;

import java.util.Arrays;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/30 16:05
 */
public class KruskalAlgorithm {
    private int edgeNum; // 边的个数
    private char[] vertexes; // 顶点数组
    private int[][] matrix; // 邻接矩阵
    // 使用INF表示两个顶点不能联通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        KruskalAlgorithm kruskal = new KruskalAlgorithm(vertexes, matrix);
        kruskal.print();

        EData[] edges = kruskal.getEdges();
        System.out.println("排序前：");
        System.out.println(Arrays.toString(edges));
        System.out.println("排序后：");
        kruskal.sortEdges(edges);
        System.out.println(Arrays.toString(edges));

        kruskal.kruskal();
    }

    public KruskalAlgorithm(char[] vertexes, int[][] matrix) {
        // 初始化顶点数和边的个数
        int vlen = vertexes.length;
        // 初始化顶点
        this.vertexes = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            this.vertexes[i] = vertexes[i];
        }
        // 初始化边
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        // 统计边条数
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    // 打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵为：");
        for (int i = 0; i < vertexes.length; i++) {
            for (int j = 0; j < vertexes.length; j++) {
                System.out.printf("%13d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    //对边进行排序。冒泡
    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    private int getPosition(char ch) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == ch) {
                return i;
            }
        }
        return -1;
    }
    
    // 获取图中的边，存放到数组中
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexes.length; i++) {
            for (int j = i + 1; j < vertexes.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexes[i], vertexes[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    // 判断回路，两点的终点是不是同一点

    /**
     * 获取下标为i的两个顶点的终点，用于判断两个顶点的终点是否相同
     * @param ends 记录各个顶点的终点是哪个
     * @param i 传入的顶点对应的下标
     * @return 下标为i的这个顶点对应的终点的下标
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public void kruskal() {
        // 最后结果数组的索引
        int index = 0;
        // 用于保存 已有最小生成树 中的每个顶点在最小生成树中的终点
        int[] ends = new int[edgeNum];
        // 创建结果数组，保存最后的最小生成树
        EData[] res = new EData[edgeNum];
        // 获取图中所有边
        EData[] edges = getEdges();
        // 排序
        sortEdges(edges);
        // 遍历edges数组，将边添加到最小生成树中，
        // 判断是准备加入的边是否形成了回路，如果没有，就加入res
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            // 获取p1这个顶点在已有最小生成树中的终点
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            // 是否构成回路
            if (m != n) {
                ends[m] = n;
                res[index++] = edges[i];
            }
        }
        // 统计并打印最小生成树
        System.out.println("最小生成树：");
        for (int i = 0; i < index; i++) {
            System.out.println(res[i]);
        }
    }
}

// 创建一个边类
class EData {
    char start; // 边的起点 两个端点
    char end; // 边的终点
    int weight; // 边的权值
    // 构造方法
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}