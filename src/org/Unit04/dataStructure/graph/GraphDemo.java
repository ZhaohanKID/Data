package org.Unit04.dataStructure.graph;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/28 21:09
 */
public class GraphDemo {
    public static void main(String[] args) {
        int n = 5; // 节点个数
        String[] vertexValue = {"A", "B", "C", "D", "E"};
        // 创建图对象
        Graph graph = new Graph(n);
        // 循环添加项点，可以使用iter，迭代器
        for (int i = 0; i < vertexValue.length; i++) {
            graph.insertVertex(vertexValue[i]);
        }
        // 添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        // 显示
        graph.showGraph();

        // 测试深度遍历
        System.out.println("深度遍历:");
        graph.dfs();
    }
}
