package org.Unit04.dataStructure.Tree;

import java.util.Arrays;

/**
 *  树的实际应用：堆排序
 * @Author: Z.HAN
 * @Date: 2020/10/27 8:46
 */
public class HeapSort {
    public static void main(String[] args) {
        // 升序大顶堆，降序小顶堆，这里就升序吧
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        //System.out.println("ok数组=" + Arrays.toString(arr));
    }
    // 堆排序的方法
    public static void heapSort(int[] arr) {
        int temp = 0;

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        /*
            将堆顶元素与末尾元素进行交换，将最大元素沉到数组末端
            重新调整结构，使其满足堆定义，然后继续交换堆顶元素和末尾元素
         */
        for (int j = arr.length - 1; j > 0; j--) {
            // 交换
            temp = arr[j];
            arr[j] = temp;
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println("数组=" + Arrays.toString(arr));
    }

    // 将一个数组(二叉树)，调整成一个大顶堆

    /**
     * 功能：完成将以 i 对应的非叶子节点的树调整成大顶堆
     *  举例：int[] arr = {4, 6, 8, 5, 9};---i=1---adjustHeap---{4,9,8,5,6}
     *  如果我们再次调用adjustHeap传入的是i=0，{9,6,8,5,4}
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整，length是在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break; // 存疑，说得对，为什么不能再有子节点了？？
            }
        }
        // 当for循环结束之后，就是将以i为父节点的这棵局部子树的 最大值放到了最顶上
        arr[i] = temp; // 将temp的值放到调整后的位置
    }
}
