package org.Unit04.dataStructure.Sort;

import java.util.Arrays;

/**
 *  冒泡排序
 * @Author: Z.HAN
 * @Date: 2020/10/24 21:10
 */
public class BubbleSort {
    public static void main(String[] args) {
        /*int[] array = {3, 9, -1, 10, -2};
        System.out.println("排序前的数组：" + Arrays.toString(array));

        // 冒泡排序
        bubbleSort(array);
        System.out.println("冒泡排序后的数组：" + Arrays.toString(array));*/


        // 选择排序
        int[] selectArray = {101, 34, 109, 1};
        /*System.out.println("排序前的数组：" + Arrays.toString(selectArray));
        selectSort(selectArray);
        System.out.println("选择排序后的数组：" + Arrays.toString(selectArray));*/

        System.out.println("---------------------------");

        // int[] insertArray = {101, 34, 119, 1, -1, 90, 123};
        /*int[] insertArray = {2, 3, 4, 5, 6, 1};
        System.out.println("排序前的数组：" + Arrays.toString(insertArray));
        insertSort(insertArray);
        System.out.println(Arrays.toString(insertArray));*/

        int[] shellArray = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("排序前的数组：" + Arrays.toString(shellArray));
        shellSort(shellArray);
        System.out.println("排序后的数组：" + Arrays.toString(shellArray));
    }
    // 冒泡排序封装成一个方法
    public static void bubbleSort(int[] array) {
        int temp = 0;
        // 时间复杂度：O(n^2)
        // 优化
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序后的数组：" + Arrays.toString(array));
            /*
                {3, 9, -1, 10, 20}
                优化之后的这个代码，只进行了3次排序，其实第二次排序之后的
                结果就已经是有序的了，但是因为第二次进行了交换，所以还要继
                续进行第三次交换。
             */
            if (!flag) {
                // 等于false说明在一趟排序中一次交换都没有发生
                break;
            } else {
                // 重置flag，进行下次排序
                flag = false;
            }
        }
    }

    // 选择排序
    public static void selectSort(int[] array) {
        int temp = 0;
        int k = 0;
        for (int i = 0; i < array.length - 1; i++) {
            k = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[k] > array[j]) {
                    k = j;
                }
            }
            if (k != i) {
                temp = array[k];
                array[k] = array[i];
                array[i] = temp;
            }

            System.out.println("第" + (i + 1) + "次排序后的数组：" + Arrays.toString(array));
        }
    }

    // 插入排序
    public static void insertSort(int[] array) {
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < array.length; i++) {
            insertValue = array[i]; // 定义待插入的数
            insertIndex = i - 1; // 即 array[i] 前面的这个数的下标
            // 如果要从大到小排序，则需要将insertValue > array[insertIndex]这个变成大于号
            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                array[insertIndex + 1] = insertValue;
            }
            System.out.println("第" + i + "轮插入后的数组：" + Arrays.toString(array));
        }
    }

    // 希尔排序 交换法
    public static void shellSort(int[] array) {
        int temp = 0;
        int gap = array.length / 2;
        int count = 0;
        while (gap > 0) {
            count++;
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，就要进行交换
                    if (array[j] > array[j + gap]) {
                        temp = array[j + gap];
                        array[j + gap] = array[j];
                        array[j] = temp;
                    }
                }
            }
            System.out.println("希尔第" + count + "次排序后的数组：" + Arrays.toString(array));
            gap = gap / 2;
        }
    }
}
