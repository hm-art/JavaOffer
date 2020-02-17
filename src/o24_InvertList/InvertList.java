package o24_InvertList;

import o23_EntranceOfRing.EntranceofRing;

//24.反转链表
//   测试用例要考虑三种情况（鲁棒性）
//   1.链表为空（头指针为null）
//   2.链表中只有一个节点
//   3.链表中有多个节点
public class InvertList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }

    public static void main(String[] args) {
           //test1();
           //test2();
           test3();
    }
    public static ListNode ReverseList(ListNode head){
        if(head==null){//链表中没有节点，返回空
            return null;
        }
        if(head.next==null){//链表中只有一个节点，则返回他自己
            return head;
        }
        ListNode reverseHead=null;//反转后的链表的头
        //ListNode reverseEnd=null;//反转之后链表的尾
        ListNode Prev=null;//反转前，当前节点的前一个结点
        ListNode Node=head;//反转前，当前节点
        ListNode Next=null;//反转前，当前节点的后一个结点
        while(Node!=null){
            Next=Node.next;
            if(Next==null){
                reverseHead=Node;
            }
            Node.next=Prev;
            Prev=Node;
            Node=Next;
        }
        return  reverseHead;
    }
    public static void test1(){
        ListNode head=null;
        ListNode result=ReverseList(head);
        if(head==null){
            System.out.println("链表是空的");
        }else{
            while(head!=null){
                System.out.println("反转前链表");
                System.out.print(head.val+"->");
                head=head.next;
            }
            while(result!=null){
                System.out.println("反转后链表");
                System.out.print(result.val+"->");
                result=result.next;
            }
        }
    }
    public static void test2(){
        ListNode head=new ListNode(1);
        ListNode phead=head;
        ListNode result=ReverseList(head);
        if(head==null){
            System.out.println("链表是空的");
        }else{
            System.out.print("反转前链表");
            while(phead!=null){

                System.out.print(phead.val+"->");
                phead=phead.next;
            }
            System.out.println();
            System.out.print("反转后链表");
            while(result!=null){
                System.out.print(result.val+"->");
                result=result.next;
            }
        }
    }
    public static void test3(){
        ListNode head=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        head.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=null;
        ListNode phead=head;

        if(phead==null){
            System.out.println("链表是空的");
        }else{
            System.out.print("反转前链表");
            while(phead!=null){
                System.out.print(phead.val+"->");
                phead=phead.next;
            }
            System.out.println();
            System.out.print("反转后链表");
            ListNode result=ReverseList(head);
            while(result!=null){
                System.out.print(result.val+"->");
                result=result.next;
            }
        }
    }
}
