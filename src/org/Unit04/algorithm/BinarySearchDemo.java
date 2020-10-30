package org.Unit04.algorithm;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/29 21:31
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 7, 9, 11, 4};
        int index = binarySearch(arr, 11);
        System.out.println(index);
        /*if (index >= 0) {
            System.out.println("要查找元素的索引是：" + index);
        } else {
            System.out.println("要查找的元素不存在");
        }*/
    }
    // 查找的方法
    public static int binarySearch(int[] arr, int findValue) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == findValue) {
                return mid;
            } else if (arr[mid] > findValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
