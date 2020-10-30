package org.Unit04.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *  贪心算法
 * @Author: Z.HAN
 * @Date: 2020/10/30 12:58
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        // 创建广播电台，放入到map
        HashMap<String, HashSet<String>> boardCasts = new HashMap<>();
        // 将各个电台放进去
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        boardCasts.put("K1", hashSet1);
        boardCasts.put("K2", hashSet2);
        boardCasts.put("K3", hashSet3);
        boardCasts.put("K4", hashSet4);
        boardCasts.put("K5", hashSet5);

        // 把所有地区添加进去
        HashSet<String> allAreas = new HashSet<>();
        // 遍历map添加地区
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        /*Set<String> set = boardCasts.keySet();
        for (String key : set) {
            for (String area : boardCasts.get(key)) {
                allAreas.add(area);
            }
        }*/
        // 存放已经选择的电台的集合
        ArrayList<String> selects = new ArrayList<>();
        // 临时的集合，用来存放map中每个key对应的set集合
        HashSet<String> tmpSet = new HashSet<>();

        String maxKey = null;
        int count = 0;
        while (allAreas.size() != 0) {
            maxKey = null;
            for (String key : boardCasts.keySet()) {
                tmpSet.clear();

                HashSet<String> areas = boardCasts.get(key);
                tmpSet.addAll(areas);
                // 求取出的这个电台的能覆盖城市和 所有地区中的交集
                // 交集会赋值给tmpSet
                // 移除调用者中不包含在另一个集合中的部分
                tmpSet.retainAll(allAreas);
                // 这里体现出贪心算法的特点
                /*
                    tmpSet.size() > boardCasts.get(maxKey).size()这一步？？
                    tmpSet.size()是交集的元素个数，而boardCasts.get(maxKey).size()是整个集合的元素个数？？？
                    怎么可以比较

                    这样还是不对，因为有可能上上一个就是最大的，这样就把它给丢掉了
                 */
                if (tmpSet.size() > 0 && (maxKey == null || tmpSet.size() > count)) {
                    maxKey = key;
                }
                count = tmpSet.size();
            }
            if (maxKey != null) {
                selects.add(maxKey);
                // 将maxKey指向的广播电台去掉
                allAreas.removeAll(boardCasts.get(maxKey));
            }
        }
        System.out.println(selects);
    }
}
