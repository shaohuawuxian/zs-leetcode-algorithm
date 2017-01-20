
package com.zs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode ���������Ŀ
 * 
 * @author zhangshao
 */
public class LeetCodeArrays {

    /**
     * 1��Two Sum
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a) && map.get(a) != i) {
                return new int[] {
                        i, map.get(a)
                };
            }
        }
        return null;
    }
    
    /**
     * 3��Remove Element
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int result=0;
        int start=0,end=nums.length-1;
        while(start<=end){
            if(nums[end]==val){
                end--;
                continue;
            }
            if(nums[start]!=val){
                start++;
                continue;
            }
            int temp=nums[end];
            nums[end]=nums[start];
            nums[start]=temp;
            start++;
            end--;
            result++;
            
        }
        return result;
    }

    /**
     * 4��Remove Duplicates from Sorted Array
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
        return k;
    }

    
    
    
    
    /**
     * 5��Remove Duplicates from Sorted Array II
     * 
     * @param sortedArray
     * @param times ��ʾ����������times�� ����ĿҪ��һ������������2�Σ�times=2
     * @return
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

    /**
     * 6.Find All Numbers Disappeared in an Array
     * 
     * ʱ�临�Ӷ�O(n)
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List <Integer> result=new ArrayList<>();
        if(nums==null||nums.length<2){
            return result;
        }
        int len=nums.length;
        for(int i=0;i<len;i++){//n
            result.add(nums[i]);
            nums[i]=0;
        }
        
        for(int i=0;i<len;i++){//n
            int a=result.get(i);
            nums[a-1]=a;
        }
        result.clear();
        for(int i=0;i<len;i++){//n
            if(nums[i]==0){
                result.add(i+1);
            }
        }
        
      
        return result;
    }
    
    /**
     * 7.Max Consecutive Ones
     * 
     * ��������ֵ���ҵ����������1��
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        
        int result=0;
        int start=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                start++;
            }else{
                if(result<start){
                    result=start;
                }
                start=0;
            }
        }
        if(result<start){//��������һֱû������0��start>0��
            result=start;
        }
        return result;
    }
    /**
     * 8.Find All Duplicates in an Array
     * 
     *  ����Ŀ�� {@link #findDisappearedNumbers(int[])}�ı���,ʱ�临�Ӷ�ͬ����O{n}��
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List <Integer> result=new ArrayList<>();
        if(nums==null||nums.length<2){
            return result;
        }
        int len=nums.length;
        for(int i=0;i<len;i++){//n
            result.add(nums[i]);
            nums[i]=0;
        }
        
        for(int i=0;i<len;i++){//n
            int a=result.get(i);
            if(nums[a-1]!=0){
                nums[a-1]=-1;//�ظ������֣���Ϊ-1
            }else{
                nums[a-1]=a;
            }
            
        }
        result.clear();
        for(int i=0;i<len;i++){//n
            if(nums[i]==-1){
                result.add(i+1);
            }
        }
        
      
        return result;
    }
    
    
    /**
     * Single Nubmer Given an array of integers, every element appears twice
     * except for one. Find that single one. int
     * []numbers={1,3,1,4,4,3,7,6,0,-1,-1,6,0} return 7; ˼·������λ����a^a=0
     * 0^b=b;������Ŀ ������ֻ��һ������һ�ε��������������������Σ�����������ó��������ǽ���� ʱ�临�Ӷ� O(n),�ռ临�Ӷ�O(1)
     * 
     * @param numbers
     * @return
     */
    public static int singleNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("numbers's length must more than 0");
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        int result = 0;
        for (int i = 0, len = numbers.length; i < len; i++) {
            result ^= numbers[i];
        }
        System.out.println("result=" + result);
        return result;
    }
    
    

}
