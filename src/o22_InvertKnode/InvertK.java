package o22_InvertKnode;
//22.链表中倒数第k个结点
//默认最后一个为倒数第一个（k=1）
//为了保证只遍历一次链表，有了以下想法：(方法1)
//  设两个指针
//  第一个指针p1先向前走k-1步，第二个指针p2在头不动
//  从第k步开始，p1和p2一起向前走，始终保持距离k-1
//  p1遍历到尾了，p2就遍历到倒数第k个了
//再考虑鲁棒性，三种情况
// 输入head为空--则返回空
// 链表的总结点数小于k
// 输入的k为0 由于k为无符号整型，k-1后为4294967295 这种情况for循环执行次数远超过预计
//利用栈：（方法2）
//将链表结点入栈，每入一次加1，就是结点总长度，计算出来后与k比较（鲁棒性），<k则返回null
//再将栈中间点弹出k个，第k个就是我们要的

import java.util.Stack;

public class InvertK {
    public static class List{
        int val;
        List next=null;
        List(int val,List next){
            this.val=val;
            this.next=next;
        }
    }
    public static void main(String[] args) {
       test1();
        test2();
        test3();
        test4();
    }
    public static void test1(){
        List l4=new List(3,null);
        List l3=new List(3,l4);
        List l2=new List(2,l3);
        List head=new List(1,l2);
        List result=InvertKNode2(head,0);
        if(result==null){
            System.out.println("输入有误");
        }else{
            System.out.println(result.val);
        }
    }
    public static void test2(){
        List l4=new List(4,null);
        List l3=new List(3,l4);
        List l2=new List(2,l3);
        List head=new List(1,l2);
        List result=InvertKNode2(head,4);
        if(result==null){
            System.out.println("输入有误");
        }else{
            System.out.println(result.val);
        }

    }
    public static void test3(){
        List l4=new List(3,null);
        List l3=new List(3,l4);
        List l2=new List(2,l3);
        List head=new List(1,l2);
        List result=InvertKNode2(head,10);
        if(result==null){
            System.out.println("输入有误");
        }else{
            System.out.println(result.val);
        }
    }
    public static void test4(){
        List head=null;
        List result=InvertKNode2(head,4);
        if(result==null){
            System.out.println("输入有误");
        }else{
            System.out.println(result.val);
        }

    }
    public static List InvertKNode(List head,int k){//方法1
        if(k<=0||head==null){//鲁棒性
            return null;
        }
        List p1=head;
        List p2=head;
        for(int i=0;i<k-1;i++){
            p1=p1.next;
            if(p1==null)//鲁棒性，解决了链表结点总数<k的问题
                return null;
        }
        while (p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }
    public static List InvertKNode2(List head,int k){
        //方法2
        if(head==null||k<=0)
            return null;
        Stack<List> s=new Stack<List>();
        int count=1;
        s.push(head);
        List node=head.next;
        while(node!=null){
            count++;
            s.push(node);
            node=node.next;
        }
        if(count<k){
            return null;
        }
        List result=null;
        for(int i=0;i<k;i++){
            result=s.pop();
        }
        return result;
    }
}
