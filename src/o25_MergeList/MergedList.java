package o25_MergeList;

import o24_InvertList.InvertList;

//25.合并两个排序的链表
//   原始两个链表都是递增的，要求合并后还是递增的
//   鲁棒性：1.其中一个链表为空，或者都为空
//          2.链表只有一个结点
//   考虑合并过程：两种实现方法，递归和非递归
public class MergedList {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    //递归版本
    public static ListNode mergedlist(ListNode head1, ListNode head2){
        if(head1==null&&head2==null){
            return null;
        }
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        if(head1.val<head2.val){
            head1.next=mergedlist(head1.next,head2);
            return head1;
        }else{
            head2.next=mergedlist(head1, head2.next);
            return head2;
        }
    }
    //非递归版本
    public static ListNode mergedList2(ListNode head1,ListNode head2){
        if(head1==null&&head2==null){
            return null;
        }
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        ListNode tempHead=new ListNode(-1,null);
        //虚构一个新链表的头节点，最后返回它的next就是真正的头节点
        ListNode p=tempHead;
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val){
                p.next=head1;
                head1=head1.next;
            }else{
                p.next=head2;
                head2=head2.next;
            }
            p=p.next;
        }
        if(head1==null){
            p.next=head2;
        }
        if(head2==null)
        {
            p.next=head1;
        }
        return tempHead.next;
    }
    //测试用例
    public static void test1(){
        ListNode head1=null;
        ListNode head2=null;
//        ListNode result=mergedlist(head1,head2);
        ListNode result=mergedList2(head1,head2);
        if(result==null){
            System.out.println("两个链表都是空的，无法合并");
        }else{
            while(result!=null){
                System.out.print(result.val+" ");
            }
            System.out.println();
        }

    }
    public static void test2(){//1 2
        ListNode head1=null;
        ListNode l2=new ListNode(2,null);
        ListNode head2=new ListNode(1,l2);
       // ListNode result=mergedlist(head1,head2);
        ListNode result=mergedList2(head1,head2);

        if(result==null){
            System.out.println("两个链表都是空的，无法合并");
        }else{
            while(result!=null){
                System.out.print(result.val+" ");
                result=result.next;
            }
            System.out.println();
        }
    }
    public static void test3(){//1 1 2 2
        ListNode l3=new ListNode(2,null);
        ListNode head1=new ListNode(1,l3);
        ListNode l2=new ListNode(2,null);
        ListNode head2=new ListNode(1,l2);
        //ListNode result=mergedlist(head1,head2);
        ListNode result=mergedList2(head1,head2);
        if(result==null){
            System.out.println("两个链表都是空的，无法合并");
        }else{
            while(result!=null){
                System.out.print(result.val+" ");
                result=result.next;
            }
            System.out.println();
        }
    }
    public static void test4(){//1 1 2 3 4
        ListNode l4=new ListNode(4,null);
        ListNode l3=new ListNode(3,l4);
        ListNode head1=new ListNode(1,l3);
        ListNode l2=new ListNode(2,null);
        ListNode head2=new ListNode(1,l2);
        //ListNode result=mergedlist(head1,head2);
        ListNode result=mergedList2(head1,head2);

        if(result==null){
            System.out.println("两个链表都是空的，无法合并");
        }else{
            while(result!=null){
                System.out.print(result.val+" ");
                result=result.next;
            }
            System.out.println();
        }
    }
}
