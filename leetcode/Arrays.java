
package com.zs.leetcode;

/**
 * leetcode ���������Ŀ
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
        int k = 1;// ��¼����������λ��
        int temp = sortedArray[0];
        for (int i = 1; i < sortedArray.length; i++) {
            if (temp < sortedArray[i]) {// !=Ҳ����
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
     * @param times  ��ʾ����times��  ����Ŀһ������������2�Σ�times=2
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
