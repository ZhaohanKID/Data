package org.Unit06.leecode;

/**
 * @ Author: Z.HAN
 * @ Date: 2020/12/23 12:56
 */
public class test11 {
    public static void main(String[] args) {

    }
}
class Solution11 {
    public int GetUglyNumber_Solution(int index) {
        for (int i = 0; i < index; i++) {
//            if ()
        }
        return 0;
    }
    public boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
