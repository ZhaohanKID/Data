package org.Unit05.Exam;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/24 9:59
 */
public class Test {
    public static void main(String[] args) {
        int[] numbers = {23, 5, 28, 29, 4, 65};
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
