package o52_TwoListPublicNode;

import o23_EntranceOfRing.EntranceofRing;

//52.两个链表的第一个公共节点
public class o52_TwoListPublicNode {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    public static int getPublicNode(ListNode head1,ListNode head2){
        if(head1==null||head2==null){

            return -500;
        }
        int length1=getLength(head1);
        int length2=getLength(head2);
        int cha=length1>length2?(length1-length2):(length2-length1);
        ListNode curHead1=null;
        ListNode curHead2=null;
        if(length1>length2){
            curHead1=walkToEqualLength(head1,cha);
            curHead2=head2;
        }else{
            curHead1=walkToEqualLength(head2,cha);
            curHead2=head1;
        }
        while(curHead1!=null&&curHead2!=null){
            if(curHead1==curHead2){
                return curHead1.val;
            }
            curHead1=curHead1.next;
            curHead2=curHead2.next;
        }
        return -1000;
    }
    public static int getLength(ListNode head){//获得链表的长度
        int length=0;
        ListNode p=head;
        while(p!=null){
            length++;
            p=p.next;
        }
        return length;
    }
    public static ListNode walkToEqualLength(ListNode head,int cha){
        ListNode p=head;
        for(int i=0;i<cha;i++){
            if(p!=null)
                p=p.next;
        }
        return p;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
    public static void test(int n){
        if(n==-500){
            System.out.println("输入错误");
        }else if(n==-1000){
            System.out.println("无公共节点");
        }else{
            System.out.println("第一个公共节点是 "+n);
        }
    }
    public static void test1(){
        ListNode head1=null;
        ListNode head2=new ListNode(1);
        int n=getPublicNode(head1,head2);
        test(n);
    }
    public static void test2(){ //1 2
                                //    3
                                //1 2
        ListNode head1=new ListNode(1);
        ListNode h12=new ListNode(2);
        ListNode h13=new ListNode(3);
        head1.next=h12;
        h12.next=h13;
        ListNode head2=new ListNode(1);
        ListNode h22=new ListNode(2);
        head2.next=h22;
        h22.next=h13;
        int n=getPublicNode(head1,head2);
        test(n);
    }
    public static void test3(){//1 2 3
                               //1 2 3
        ListNode head1=new ListNode(1);
        ListNode h12=new ListNode(2);
        ListNode h13=new ListNode(3);
        head1.next=h12;
        h12.next=h13;
        ListNode head2=new ListNode(1);
        ListNode h22=new ListNode(2);
        ListNode h23=new ListNode(3);
        head2.next=h22;
        h22.next=h23;
        int n=getPublicNode(head1,head2);
        test(n);
    }
    public static void test4(){//1 2 3
                               //      6 7
        //                      3 4 5 1
        ListNode head1=new ListNode(1);
        ListNode h12=new ListNode(2);
        ListNode h13=new ListNode(3);
        head1.next=h12;
        h12.next=h13;
        ListNode head2=new ListNode(3);
        ListNode h22=new ListNode(4);
        ListNode h23=new ListNode(5);
        ListNode h24=new ListNode(1);
        head2.next=h22;
        h22.next=h23;
        h23.next=h24;
        ListNode public1=new ListNode(6);
        ListNode public2=new ListNode(7);
        h13.next=public1;
        h24.next=public1;
        public1.next=public2;
        int n=getPublicNode(head1,head2);
        test(n);
    }
    public static void test5(){//2 3 4 从头开始就完全一样了
        ListNode head1=new ListNode(2);
        ListNode h12=new ListNode(3);
        ListNode h13=new ListNode(4);
        head1.next=h12;
        h12.next=h13;
        ListNode head2=head1;
        head2.next=h12;
        h12.next=h13;
        int n=getPublicNode(head1,head2);
        test(n);
    }
}
