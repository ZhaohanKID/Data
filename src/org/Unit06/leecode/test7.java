package org.Unit06.leecode;

/**
 * @ Author: Z.HAN
 * @ Date: 2020/12/22 9:25
 */
public class test7 {
    public static void main(String[] args) {
        int[][] mat =  {{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        int sum = new Solution7().diagonalSum(mat);
        System.out.println(sum);
    }
}
class Solution7 {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            int j = s.length - i - 1;
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int len1 = mat.length;
        int len2 = mat[0].length;
        boolean[][] flags = new boolean[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if ((i == j || i + j == len1 - 1) && !flags[i][j]) {
                    sum += mat[i][j];
                    flags[i][j] = true;
                }
            }
        }
        return sum;
    }

    public int diagonalSum2(int[][] mat) {
        int ans = 0,n = mat.length;
        int i = 0,j = n-1;
        while (i < n) {
            ans += mat[i][i] + mat[j][i];
            i++;
            j--;
        }
        if (n % 2 != 0)
            ans -= mat[n/2][n/2];
        return ans;
    }
    public int diagonalSum3(int[][] mat) {
        int sum = 0,n = mat.length;

        for(int i=0;i<n;i++) {
            sum += mat[i][i];
            sum += mat[i][n-i-1];
        }

        if(n%2 == 1) {
            sum -= mat[n/2][n/2];
        }

        return sum;
    }
}
