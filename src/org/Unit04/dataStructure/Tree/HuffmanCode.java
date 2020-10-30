package org.Unit04.dataStructure.Tree;

import java.util.*;

/**
 *  赫夫曼编码
 * @Author: Z.HAN
 * @Date: 2020/10/27 17:32
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();

        System.out.println(contentBytes.length);

        List<HuffmanNode> nodes = getNodes(contentBytes);
        System.out.println(nodes);

        System.out.println("赫夫曼树：");
        HuffmanNode huffmanNode = createHuffmanTree(nodes);
        System.out.println("前序遍历：");
        prefixOrderList(huffmanNode);

        // 测试一把是否生成了对应的赫夫曼编码
        //getCodes(huffmanNode, "", stb);
        Map<Byte, String> huffmanCodes = getCodes(huffmanNode);
        System.out.println(huffmanCodes);

    }

    // 生成赫夫曼树对应的赫夫曼编码表
    /*
        1 将赫夫曼编码表存放在 Map<Byte, String>形式
        2 生成赫夫曼编码表示，需要去拼接路径，定义一个StringBuilder存储某个叶子节点的路径
     */
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stb = new StringBuilder();

    // 为了调用简单，我们重载getCodes
    private static Map<Byte, String> getCodes(HuffmanNode root) {
        if (root == null) {
            return null;
        }
        // 处理root的左子树
        getCodes(root.left, "0", stb);
        // 处理root的右子树
        getCodes(root.right, "1", stb);
        return huffmanCodes;
    }


    /**
     * 功能：将传入的node节点的所有叶子节点的赫夫曼编码得到，
     *      并放入到 huffmanCodes 集合
     *
     * @param node 传入结点
     * @param code 路径：左子节点是0，右子节点是1
     * @param stb 用于拼接路径
     */
    private static void getCodes(HuffmanNode node, String code, StringBuilder stb) {
        StringBuilder stb2 = new StringBuilder(stb);
        // 将 code 加入到 stb2
        stb2.append(code);
        if (node != null) {
            // 判断当前node是叶子节点还是非叶子节点
            if (node.data == null) {
                getCodes(node.left, "0", stb2);
                getCodes(node.right, "1", stb2);
            } else {
                // 就表示找到某个叶子节点的最后
                huffmanCodes.put(node.data, stb2.toString());
            }
        }
    }

    public static List<HuffmanNode> getNodes(byte[] bytes) {
        List<HuffmanNode> nodes = new ArrayList<>();
        // 遍历bytes，统计每一个byte出现的次数，存放到map里面
        Map<Byte, Integer> countsMap = new HashMap<>();
        for (byte b : bytes) {
            Integer count = countsMap.get(b);
            if (count == null) {
                countsMap.put(b, 1);
            } else {
                countsMap.put(b, count + 1);
            }
        }
        // 把每一个键值对转成一个Node对象，并加入到nodes集合
        /*for(Map.Entry<Byte, Integer> entry: countsMap.entrySet()) {
            nodes.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }*/
        Set<Byte> keys = countsMap.keySet();
        for (Byte key : keys) {
            nodes.add(new HuffmanNode(key, countsMap.get(key)));
        }
        return nodes;
    }

    // 可以通过List创建对应的赫夫曼树
    public static HuffmanNode createHuffmanTree(List<HuffmanNode> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes); // 从小到大

            HuffmanNode leftNode = nodes.get(0);
            HuffmanNode rightNode = nodes.get(1);

            HuffmanNode parentNode = new HuffmanNode(null, leftNode.weight + rightNode.weight);
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parentNode);
        }
        return nodes.get(0);
    }

    // 前序遍历
    private static void prefixOrderList(HuffmanNode root) {
        if (root != null) {
            root.prefixOrderList();
        } else {
            System.out.println("赫夫曼树为空，不能遍历");
        }
    }
}

// 创建Node，带权值
class HuffmanNode implements Comparable<HuffmanNode> {
    Byte data; //存放数据(字符)本身，比如'a'=97，' '=32
    int weight; //权值，表示字符出现的次数
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        // 从小到大排列
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    // 前序遍历
    public void prefixOrderList() {
        System.out.println(this);
        if (this.left != null) {
            this.left.prefixOrderList();
        }
        if (this.right != null) {
            this.right.prefixOrderList();
        }
    }
}
