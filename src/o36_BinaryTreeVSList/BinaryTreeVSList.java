package o36_BinaryTreeVSList;

import java.util.Stack;

//36.二叉树与双向链表（二叉搜索树转为双向链表）
//   分析可知利用中序遍历
//   有两种方式：递归和非递归
//               非递归时借用堆栈，模拟递归的操作
//   双向链表就是用left和right实现的，画图就可以清楚整个过程了
public class BinaryTreeVSList {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }
    public static class BinaryTree{
        int val;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int val){
            this.val=val;
        }
        BinaryTree(){}
    }
    //         10
    //     6       14
    //   4   8   12  16
    //1.非递归实现
    public static BinaryTree convert1(BinaryTree root){
        if(root==null)
            return root;
        BinaryTree lastnode=null;
        BinaryTree p=root;
        Stack<BinaryTree> stack=new Stack<>();
        while(p!=null||stack.size()!=0){//p和stack同时为空的时候，循环结束
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            if(!stack.empty()){
                p=stack.pop();
                p.left=lastnode;
                if(lastnode!=null){
                    lastnode.right=p;
                }
                lastnode=p;
                p=p.right;
            }
        }
        BinaryTree temp=root;
        while(temp!=null&&temp.left!=null)//为了找到头节点，而做的循环
            temp=temp.left;
        return temp;
    }
    //2.递归实现
    public static BinaryTree convert2(BinaryTree root){
        if(root==null)//鲁棒性
            return root;
        BinaryTree lastnode=null;
        BinaryTree fistNode=root;
        while(fistNode.left!=null&&fistNode.left!=null){
            fistNode=fistNode.left;
        }
        converCore(root,lastnode);
        return fistNode;
    }
      //递归实现的核心代码 和非递归的思路一样
    private static BinaryTree converCore(BinaryTree root, BinaryTree lastnode) {
        if(root==null)
            return null;
        BinaryTree p=root;
        if(p.left!=null){
            lastnode=converCore(p.left,lastnode);
        }
        p.left=lastnode;
        if(lastnode!=null){
            lastnode.right=p;
        }
        lastnode=p;
        if(p.right!=null){
            lastnode=converCore(p.right,lastnode);
        }
        return lastnode;
    }
    //
    public static void printList(BinaryTree root){
        if(root==null)
        {
            System.out.println("链表为空，无法打印");
            return;
        }
        while(root!=null){
            System.out.println("该节点值为"+root.val);
            if(root.left!=null){
                System.out.println("该节点左面为"+root.left.val);
            }
            if(root.right!=null){
                System.out.println("该节点右面为"+root.right.val);
            }
            root=root.right;
        }
    }
    public static void test1(){
        BinaryTree root=null;
        //BinaryTree c=convert1(root);
        BinaryTree c=convert2(root);
        printList(c);
    }
    public static void test2(){
        BinaryTree root=new BinaryTree(3);
        BinaryTree r2=new BinaryTree(2);
        BinaryTree r3=new BinaryTree(1);
        root.left=r2;
        r2.left=r3;
        r3.left=null;
        //BinaryTree c=convert1(root);
        BinaryTree c=convert2(root);
        printList(c);
    }
    public static void test3(){
        BinaryTree root=new BinaryTree(1);
        BinaryTree r2=new BinaryTree(2);
        BinaryTree r3=new BinaryTree(3);
        root.right=r2;
        r2.right=r3;
        r3.right=null;
        //BinaryTree c=convert1(root);
        BinaryTree c=convert2(root);
        printList(c);
    }
    public static void test4(){
        BinaryTree root=new BinaryTree(1);
        //BinaryTree c=convert1(root);
        BinaryTree c=convert2(root);
        printList(c);
    }
    public static void test5(){
        BinaryTree root=new BinaryTree(10);
        BinaryTree r2=new BinaryTree(6);
        BinaryTree r3=new BinaryTree(14);
        BinaryTree r4=new BinaryTree(4);
        BinaryTree r5=new BinaryTree(8);
        BinaryTree r6=new BinaryTree(12);
        BinaryTree r7=new BinaryTree(16);
        root.left=r2;
        root.right=r3;
        r2.left=r4;
        r2.right=r5;
        r3.left=r6;
        r3.right=r7;
        //BinaryTree c=convert1(root);
        BinaryTree c=convert2(root);
        printList(c);
    }
}
