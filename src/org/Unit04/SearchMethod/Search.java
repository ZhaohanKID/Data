package org.Unit04.SearchMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/25 9:47
 */
public class Search {
    public static void main(String[] args) {
        /*int[] seqArray = {2, 1, 5, 4, 3};
        int seqIndex = seqSearch(seqArray, 3);
        if (seqIndex == -1) {
            System.out.println("没有找到！");
        } else {
            System.out.println("您要查找的元素下标是：" + seqIndex);
        }*/

        int[] binArray = {1, 1, 2 , 2, 2, 2, 2, 3, 3, 3, 4, 5};
        /*int binIndex = binarySearch(binArray, 0, binArray.length - 1, 4);
        if (binIndex == -1) {
            System.out.println("没有找到！");
        } else {
            System.out.println("您要查找的元素下标是：" + binIndex);
        }*/

        System.out.println("--------------------");

        List<Integer> list = new ArrayList<>();
        list = byBinarySearchFindAllValues(binArray, 0, binArray.length - 1, 2);
        System.out.println(list);


        int[] insertSearchArray = new int[100];
        for (int i = 0; i < 100; i++) {
            insertSearchArray[i] = i + 1;
        }
        System.out.println(insertValueSearch(insertSearchArray, 0, insertSearchArray.length - 1, 100));
    }
    // 顺序（线性）查找，逐一比对，发现有相同的值，就返回下标
    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // 二分查找：需要数组是有序的
    /*
        分为递归二分查找和非递归二份查找
     */
    public static int binarySearch(int[] arr,int left, int right, int findValue) {
        // 如果 left > right,说明循环过一遍了，但那时没有找到，直接返回-1
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (midValue > findValue) {
            right = mid - 1;
            return binarySearch(arr, left, right, findValue);
        } else if (midValue < findValue) {
            left = mid + 1;
            return binarySearch(arr, left, right, findValue);
        } else {
            return mid;
        }
    }

    // 如果在数组中有重复的值，找到所有重复的值，添加到一个集合中
    public static List<Integer> byBinarySearchFindAllValues(int[] array, int left, int right, int findValue) {
        int mid = (left + right) / 2;
        if (left > right) {
            return new ArrayList<Integer>(); // 返回一个空的集合
        }
        if (findValue > array[mid]) {
            return byBinarySearchFindAllValues(array, mid + 1, right, findValue);
        } else if (findValue < array[mid]) {
            return byBinarySearchFindAllValues(array, left, mid - 1, findValue);
        } else {
            // 再向左或者向右看，有没有相等的元素
            List<Integer> indexesList = new ArrayList<Integer>();
            int temp = mid - 1;
            while (true) {
                // 老师这里给的是 0 和 array.length - 1，我觉得应该是left和right，而且查找到的顺序不能保证
                if (temp < left || array[temp] != findValue) {
                    break;
                }
                indexesList.add(temp);
                temp -= 1; // temp左移
            }

            indexesList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > right || array[temp] != findValue) {
                    break;
                }
                indexesList.add(temp);
                temp += 1;
            }
            return indexesList;
        }
    }

    public static int insertValueSearch(int[] array, int low, int high, int findValue) {
        System.out.println("查找次数~");

        // 添加的条件必须要有，否则mid可能越界
        if (low > high || findValue < array[0] || findValue > array[array.length - 1]) {
            return -1;
        }
        // 自适应查找
        int mid = low + (high - low) * (findValue - array[low]) / (array[high] - array[low]);
        int midValue = array[mid];
        if (findValue > midValue) {
            return insertValueSearch(array, mid + 1, high, findValue);
        } else if (findValue < midValue) {
            return insertValueSearch(array, low, mid - 1, findValue);
        } else {
            return mid;
        }
    }

    // 斐波那契查找
    /*public static int fibonacciSearch(int[] array, int low, int high, int findValue) {

    }*/
}
