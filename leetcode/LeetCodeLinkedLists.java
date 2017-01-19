package com.zs.leetcode;
/**
 * Tag Á´±í
 * @author zhangshao
 *
 */
public class LeetCodeLinkedLists {

    
    /**
     * 1¡¢Add Two Numbers
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
     * 
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
}
