package com.zs.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Tag 链表
 * @author zhangshao
 *
 */
public class LeetCodeLinkedLists {
    /**
     * 
     * 算法的公共类1：链表Node
     * @author zhangshao
     *
     */
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { 
            val = x; 
        }
    }
    
    /**
     * 1、Add Two Numbers
     * @param list1
     * @param list2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1=l1,list2=l2;
        ListNode resultNode=null;
        ListNode tempNode=null;
        while(list1!=null||list2!=null){
            int val1=0;
            int val2=0;
            ListNode next1=null,next2=null;
            if(list1!=null){
                val1=list1.val;
                next1=list1.next;
            }
            if(list2!=null){
                val2=list2.val;
                next2=list2.next;
            }
            if(resultNode==null){
                resultNode=new ListNode(val1+val2);
                if(resultNode.val>9){
                    tempNode=new ListNode(1);//resultNode.val/10
                    resultNode.next=tempNode;
                    resultNode.val=resultNode.val%10;
                }else{
                    if(next1!=null||next2!=null){
                        tempNode=new ListNode(0);
                        resultNode.next=tempNode;
                    }
                }
                list1=next1;
                list2=next2;
                continue;
            }
            
            tempNode.val=tempNode.val+val1+val2;
            if(tempNode.val>9){
                ListNode nextNode=new ListNode(1);
                tempNode.val=tempNode.val%10;
                tempNode.next=nextNode;
                tempNode=nextNode;
            }else{
                if(next1!=null||next2!=null){
                    ListNode nextNode=new ListNode(0);
                    tempNode.next=nextNode;
                    tempNode=nextNode;
                }
            }
            list1=next1;
            list2=next2;
        }
        return resultNode;
    }
    
    /**
     * 2. Add Two Numbers II
     * 
     * 思路：先对位相加，然后转换为数组操作进位（因为没有指向前驱的变量，不好操作向前进位），最后把数组生成接口链表。
     * ~~代码很长，待优化~~
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        ListNode list1=l1,list2=l2;
        int len1=0,len2=0;
        while(list1!=null){
            len1++;
            list1=list1.next;
        }
        while(list2!=null){
            len2++;
            list2=list2.next;
        }
        
        int max=len1>len2?len1:len2;
        int tempMax=max;
        list1=l1;
        list2=l2;
        ListNode resultNode=null;
        ListNode tempNode=null;
        while(tempMax!=0){
            if(resultNode==null){
                resultNode=new ListNode(0);
                tempNode=resultNode;
            }
            int val1=0;
            int val2=0;
            if(list1!=null){
                if(tempMax==len1){
                    val1=list1.val;
                    list1=list1.next;
                    len1--;
                }
                
            }
            
            if(list2!=null){
                if(tempMax==len2){
                    val2=list2.val;
                    list2=list2.next;
                    len2--;
                }

            }
            tempMax--;
            tempNode.val=val1+val2;
            if(list1!=null||list2!=null){
                final ListNode next=new ListNode(0);
                tempNode.next=next;
                tempNode=next;
            }
        }
        
        if(max>0){
            int[] tempArray=new int[max+1];
            tempNode=resultNode;
            int index=1;
            while(tempNode!=null){
                tempArray[index]=tempNode.val;
                tempNode=tempNode.next;
                index++;
            }
            
            for(int i=tempArray.length-1;i>-1;i--){
                if(tempArray[i]>9){
                    tempArray[i]=tempArray[i]%10;
                    tempArray[i-1]=tempArray[i-1]+1;
                }
            }
            
            if(tempArray[0]>0){
                resultNode=new ListNode(tempArray[0]);
                index=1;
            }else{
                resultNode=new ListNode(tempArray[1]);
                index=2;
            }
            tempNode=resultNode;
            
            for(;index<tempArray.length;index++){
                 final ListNode next=new ListNode(tempArray[index]);
                 tempNode.next=next;
                 tempNode=next;
            }
        }
        
        return resultNode;
    }
    
    /**
     * 3. Remove Nth Node From End of List
     * 
     * 这题比较简单，只要知道要移除的removenode的前一项，然后把它的next重新复制到removenode.next就可以了。
     * 需要注意，特殊情况：移除的是链表的第一项。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int len=0;
        ListNode list=head;
        while(list!=null){
            list=list.next;
            len++;
        }
        int removeIndex=len-n+1;//从1算起
        if(removeIndex==1){
            ListNode next=head.next;
            head.next=null;
            head=next;
            return head;
        }
        int index=1;
        list=head;
        
        while(index<removeIndex-1){
            list=list.next;
            index++;
        }
        
        ListNode next=list.next;
        list.next=next.next;
        next.next=null;
        
        return head;
    }
    /**
     * 4. Merge Two Sorted Lists
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode resultNode=null;
        ListNode list1=l1,list2=l2;
        int tempVal=0;
        ListNode tempNode=null;
        while(list1!=null||list2!=null){
            if(list1!=null&&list2!=null){
                int val1=list1.val;
                int val2=list2.val;
                if(val1<=val2){
                    tempVal=val1;
                    list1=list1.next;
                }else{
                    tempVal=val2;
                    list2=list2.next;
                }
                
            }else{
                if(list1!=null){
                    tempVal=list1.val;
                    list1=list1.next;
                }
                if(list2!=null){
                    tempVal=list2.val;
                    list2=list2.next;
                }
            }
            if(resultNode==null){
                resultNode=new ListNode(tempVal);
                tempNode=resultNode;
            }else{
                final ListNode next=new ListNode(tempVal);
                tempNode.next=next;
                tempNode=next;
            }
            
        }
        
        return resultNode;
    }
    /**
     * 5. Merge k Sorted Lists
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        Map <Integer,ListNode> maps=new HashMap<>();
        for(int i=0;i<lists.length;i++){
            ListNode node=lists[i];
            while(node!=null){
                ListNode item=maps.get(node.val);
                if(item!=null){
                    while(item!=null){
                        if(item.next==null){
                            item.next=new ListNode(node.val);
                            break;
                        }else{
                            item=item.next;
                        }
                    }
                }else{
                    maps.put(node.val, new ListNode(node.val));
                }
                node=node.next;
                
            }
            
        }
        if(maps.isEmpty()){
            return null;
        }
        Set<Integer> set=maps.keySet();
        int min=set.iterator().next();
        int max=min;
        for(Integer key:set){//n*n
            if(min>key){
                min=key;
            }
            if(max<key){
                max=key;
            }
        }
        ListNode resultNode=null;
        ListNode tempNode=null;
        for(int i=min;i<=max;i++){
            ListNode node=maps.get(i);
            while(node!=null){
                if(resultNode==null){
                    resultNode=node;
                    tempNode=resultNode;
                }else{
                    tempNode.next=node;
                    tempNode=node;
                }
                node=node.next;
            }
        }
        return resultNode;
    }
    
    /**
     * 6. Swap Nodes in Pairs
     * 要求：空间复杂度 O(1),并且不能换每项listnode的值。
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode tempNode=head;
        ListNode returnLast=null;
        while(tempNode!=null){
            if(returnLast==null){//第一次循环
                if(tempNode.next!=null){
                    ListNode f=tempNode.next;
                    ListNode s=tempNode;
                    tempNode=tempNode.next.next;
                    head=f;
                    head.next=s;
                    head.next.next=null;
                    returnLast=head.next;
                }else{
                    return head;
                }
            }else{
                if(tempNode.next!=null){
                    ListNode f=tempNode.next;
                    ListNode s=tempNode;
                    tempNode=tempNode.next.next;
                    
                    returnLast.next=f;
                    returnLast=returnLast.next;
                    returnLast.next=s;
                    returnLast.next.next=null;
                    returnLast=returnLast.next;
                    
                }else{
                    returnLast.next=tempNode;
                    break;
                }
            }
            
        }
        return head;
    }
}
