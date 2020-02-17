package o35_ComplexListNode;

import o23_EntranceOfRing.EntranceofRing;

//35.复杂链表的复制
//   第一步：将复制后的节点放在原始节点的后面
//   第二步：根据原始节点的Sibling，写出复制后节点的Sibling
//   第三步：将长链表分为原始链表和复制后的链表
//          1.找到原始链表的头和克隆链表的头
//          2.分别连接原始链表和克隆链表
public class ComplexListNode {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode Sibling;
        ListNode(int val){
            this.val=val;
        }
    }
    public static void judge(ListNode node){//鲁棒性
        if(node==null){
            System.out.println("链表是空的，无法复制");
            return;
        }
        cloneNodes(node);
    }
    //1.将复制后的节点放在原始节点的后面
    public static void cloneNodes(ListNode node){//克隆原始节点
        ListNode temp=node;
        while(temp!=null){
            ListNode cloneNode=new ListNode(temp.val);
            cloneNode.next=temp.next;
            temp.next=cloneNode;
            temp=cloneNode.next;
        }
    }
    //2.根据原始节点的Sibling，写出复制后节点的Sibling
    public static void doSibing(ListNode node){
        if(node==null)
            return;
        ListNode temp=node;
        while(temp!=null){
            if(temp.Sibling!=null){
                temp.next.Sibling=temp.Sibling.next;
            }
            temp=temp.next.next;//把克隆节点越过去
        }
    }
    //3.将长链表分为原始链表和复制后的链表
    //   1.找到原始链表的头和克隆链表的头
    //   2.分别连接原始链表和克隆链表
    public static ListNode getCopmplexList(ListNode node){
        if(node==null)
            return node;
        ListNode cloneHead=null;//克隆链表的头
        ListNode yuanHead=node;//原始链表的头
        ListNode cloneNode=null;//克隆链表的其他节点
        if(yuanHead!=null){
            cloneHead=node.next;
            cloneNode=yuanHead.next;//现在cloneHead和cloneNode是一样的，但是是不同的堆栈
            yuanHead.next=cloneNode.next;
            yuanHead=yuanHead.next;//提前指向next，方便判断是否为空
        }
        while(yuanHead!=null){
            cloneNode.next=yuanHead.next;
            cloneNode=cloneNode.next;
            yuanHead.next=cloneNode.next;
            yuanHead=yuanHead.next;
        }
        return cloneHead;
    }
    //测试
    public static void printList(ListNode node){
        ListNode node1=node;
        if(node1==null)
            return;
        while(node1!=null){
            System.out.println("node.val: "+node1.val+" ");
            if(node1.Sibling!=null){
                System.out.println("node.Sibling.val: "+node1.Sibling.val);
            }
            node1=node1.next;
        }
    }
    public static void test1(){
        ListNode node=null;
        System.out.println("原始");
        printList(node);
        judge(node);
        //cloneNodes(node);
        doSibing(node);
        ListNode cloneComplex=getCopmplexList(node);
        System.out.println("复制");
        printList(cloneComplex);
    }
    public static void test2(){
        ListNode node=new ListNode(1);
        node.next=null;
        System.out.println("原始");
        printList(node);
        judge(node);
        //cloneNodes(node);
        doSibing(node);
        ListNode cloneComplex=getCopmplexList(node);
        System.out.println("复制");
        printList(cloneComplex);
    }
    public static void test3(){
        ListNode node=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(1);
        node.next=n2;
        n2.next=n3;
        n3.Sibling=node;
        System.out.println("原始");
        printList(node);
        judge(node);
        //cloneNodes(node);
        doSibing(node);
        ListNode cloneComplex=getCopmplexList(node);
        System.out.println("复制");
        printList(cloneComplex);
    }
    public static void test4(){
        ListNode node=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(1);
        node.next=n2;
        n2.next=n3;
        n3.Sibling=n3;
        n2.Sibling=node;
        System.out.println("原始");
        printList(node);
        judge(node);
        //cloneNodes(node);
        doSibing(node);
        ListNode cloneComplex=getCopmplexList(node);
        System.out.println("复制");
        printList(cloneComplex);
    }
}//
