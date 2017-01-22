package com.zs.leetcode;
/**
 * Tag ����
 * @author zhangshao
 *
 */
public class LeetCodeLinkedLists {
    /**
     * 
     * �㷨�Ĺ�����1������Node
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
     * 1��Add Two Numbers
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
     * ˼·���ȶ�λ��ӣ�Ȼ��ת��Ϊ���������λ����Ϊû��ָ��ǰ���ı��������ò�����ǰ��λ���������������ɽӿ�����
     * ~~����ܳ������Ż�~~
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
     * ����Ƚϼ򵥣�ֻҪ֪��Ҫ�Ƴ���removenode��ǰһ�Ȼ�������next���¸��Ƶ�removenode.next�Ϳ����ˡ�
     * ��Ҫע�⣬����������Ƴ���������ĵ�һ�
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
        int removeIndex=len-n+1;//��1����
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
    
}
