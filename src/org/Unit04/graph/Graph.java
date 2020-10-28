package org.Unit04.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/28 20:40
 */
public class Graph {
    private ArrayList<String> vertexList; // 存储顶点集合
    private int[][] edges; // 存储图对应的邻接矩阵
    private int numOfEdges; // 表示边的数目
    // 定义一个boolean数组，记录某个节点是否被访问过
    private boolean[] isVisited;


    public Graph(int n) {
        // 初始化邻接矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    // 得到第一个邻接节点的下标w
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }
    // 根据前一个邻接节点的下标获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 深度优先遍历算法
    private void dfs(boolean[] isVisited, int i) {
        // 首先我们访问该节点，输出
        System.out.print(getValueByIndex(i) + "->");
        // 将节点设置为已经访问
        isVisited[i] = true;
        // 查找节点i的第一个邻接点w
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            // 如果w节点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }
    // 对 dfs进行一个重载，遍历所有的节点，并进行dfs
    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }



    // 图中常用的方法
    // 返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }
    // 返回边的条数
    public int getNumOfEdges() {
        return numOfEdges;
    }
    // 返回节点(i)下标 对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }
    // 返回某条边的权值，要先给出两个节点，因为边不就是两个节点之间的吗
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }
    // 显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    // 插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
    // 添加边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
