package org.Unit06.leecode;

import java.util.Arrays;

/**
 * @Author: Z.HAN
 * @Date: 2020/12/23 14:31
 */
public class test12 {
    public static void main(String[] args) {
        int[] numbers = {3, 1, 2, 5, 4};
        int[] numbers2 = {3,5,1,4,2};
        int[] ints = new Solution12().selectSort(numbers);

        String s = new Solution12().PrintMinNumber(numbers2);
        System.out.println(s);
        System.out.println(Arrays.toString(ints));
    }
}
class Solution12 {

    public boolean isNumeric(char[] str) {
        return false;
    }

    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else {
            return JumpFloorII(target - 1) * 2;
        }
    }
    public int JumpFloorII2(int target) {
        if (target <= 0) {
            return 0;
        } else {
            return (int) Math.pow(2, target - 1);
        }
    }

    public int JumpFloor(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }

    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (array[left] >= array[right]) {
            mid = (left + right) / 2;
            if (left - right == -1) {
                return array[right];
            }
            if (array[mid] == array[left] && array[mid] == array[right]) {
                int res = array[left];
                for (int i = left + 1; i < right; i++) {
                    if (array[i] < res) {
                        res = array[i];
                    }
                }
                return res;
            }
            if (array[mid] >= array[left]) {
                mid = left;
            } else {
                mid = right;
            }
        }
        return array[mid];
    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
    for (int i = 0; i < length; i++) {
        for (int j = i + 1; j < length; j++) {
            if (numbers[i] == numbers[j]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
    }
    return false;
    }
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        boolean[] flags = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (!flags[numbers[i]]) {
                flags[numbers[i]] = true;
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }


    public String PrintMinNumber(int [] numbers) {
        String res = "";
        int temp = 0;
        int k = 0;
        for (int i = 0; i < numbers.length; i++) {
            k = i;
            for (int j = i + 1; j < numbers.length; j++) {
                int a = Integer.parseInt(numbers[i] + "" + numbers[j]);
                int b = Integer.parseInt(numbers[j] + "" + numbers[i]);
                if (a > b) {
                    /*
                    好像知道为啥了，在选择排序里面是每次j都跟k比较的
                    而这里不是
                     */
                    // i j 交换位置
                    k = j;
                }
            }
            if (k != i) {
                temp = numbers[i];
                numbers[i] = numbers[k];
                numbers[k] = temp;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            res += numbers[i];
        }
        return res;
    }
    // 选择排序
    public int[] selectSort(int[] numbers) {
        int k = 0; // 记录最小数的位置
        int temp = 0;
        for (int i = 0; i < numbers.length; i++) {
            k = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[k] > numbers[j]) {
                    k = j;
                }
            }
            if (k != i) {
                temp = numbers[i];
                numbers[i] = numbers[k];
                numbers[k] = temp;
            }
        }
        return numbers;
    }
    public String PrintMinNumber2(int [] numbers) {
        String res = "";
        int temp = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = Integer.parseInt(numbers[i] + "" + numbers[j]);
                int b = Integer.parseInt(numbers[j] + "" + numbers[i]);
                if (a > b) {
                    // i j 交换位置
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            res += numbers[i];
        }
        return res;
    }
}
