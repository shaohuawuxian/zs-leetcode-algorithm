
package com.zs.leetcode;

/**
 * leetcode 数组相关题目
 * 
 * @author zhangshao
 */
public class Arrays {

    /**
     * Remove Duplicates from Sorted Array 
     *  
     * 
     * @param sortedArray
     * @return
     */
    public static int removeDuplicates(int[] sortedArray) {
        if (sortedArray == null) {
            return 0;
        }
        int k = 1;// 记录新数组的最大位置
        int temp = sortedArray[0];
        for (int i = 1; i < sortedArray.length; i++) {
            if (temp < sortedArray[i]) {// !=也可以
                sortedArray[k] = sortedArray[i];
                k++;
                temp = sortedArray[i];
            }
        }
        System.out.println("new length=" + k);
        for (int i = 0; i < k; i++) {
            System.out.print(sortedArray[i]);
            if (i < k - 1) {
                System.out.print(",");
            }
        }
        return k;
    }

    /**
     * Remove Duplicates from Sorted Array II 
     * 
     * @param sortedArray
     * @param times  表示出现times次  本题目一个数字最多出现2次，times=2
     * @return 
     * 
     */
    public static int removeDuplicatesN(int[] sortedArray, int times) {
        if (sortedArray == null) {
            return 0;
        }
        if (sortedArray.length <= times) {
            return times;
        }
        int k = 0;
        int showtimes = 1;
        int temp = sortedArray[0];
        for (int i = 1; i < sortedArray.length; i++) {
            if (temp != sortedArray[i]) {
                k++;
                sortedArray[k] = sortedArray[i];
                showtimes = 1;
                temp = sortedArray[i];
            } else {
                if (showtimes < times) {
                    k++;
                    sortedArray[k] = sortedArray[i];
                    showtimes++;
                }
            }
        }
        for (int i = 0; i <= k; i++) {
            System.out.print(sortedArray[i]);
            if (i < k) {
                System.out.print(",");
            }
        }
        System.out.println("new length=" + (k + 1));
        return k + 1;
    }
}
