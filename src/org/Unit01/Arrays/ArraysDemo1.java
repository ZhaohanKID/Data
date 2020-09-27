package org.Unit01.Arrays;

import java.util.Arrays;

public class ArraysDemo1 {
    public static void main(String[] args) {
        int[] arr = {12, 34, 1, 56, 10, 78};
        /*System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.binarySearch(arr, 10));
        int index = Arrays.binarySearch(arr, 34);
        System.out.println(index);*/

        System.out.println("---------------------------");
        //冒泡排序
       /* for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }*/

       //选择排序
        /*for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }*/

        //折半查找
        Arrays.sort(arr);
        int max = arr.length;
        int min = 0;
        int key = 34;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (key == arr[mid]) {
                System.out.println(mid);
                break;
            } else if (key < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

            /*int low=0,high=n-1,mid;
            while(low<=high)
            {
                mid=(low+high)/2;
                if(key[mid]==k)
                    return mid;	//查找成功，返回mid
                if(k>key[mid])
                    low=mid+1;	//在后半序列中查找
                else
                    high=mid-1;	//在前半序列中查找
            }
            return -1;//查找失败，返回-1 */




    }
}
