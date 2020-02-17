package o32_UpToDownPrintBnaryTree;

import java.util.Stack;

//32.题三：之字形打印二叉树 分析可知利用stack的数据结构
//奇数层从左到右  偶数层从右到左
//层数从1开始
public class zhizixingPringTree {
    public static class BinaryTree{
        int val;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int val){
            this.val=val;
        }
    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test7();
    }
    public static void printTree(BinaryTree root){
        if(root==null){
            System.out.println("树是空的");
            return;
        }
        Stack<BinaryTree> stack1=new Stack<BinaryTree>();//存奇数行
        Stack<BinaryTree> stack2=new Stack<BinaryTree>();//存偶数行
        BinaryTree node=null;
        stack1.push(root);
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            while(!stack1.isEmpty()){//奇数行
                node=stack1.pop();
                System.out.print(node.val+" ");
                if(node.left!=null){
                    stack2.push(node.left);
                }
                if(node.right!=null){
                    stack2.push(node.right);
                }
            }
            System.out.println();
            while(!stack2.isEmpty()){
                node=stack2.pop();
                System.out.print(node.val+" ");
                if(node.right!=null){
                    stack1.push(node.right);
                }
                if(node.left!=null){
                    stack1.push(node.left);
                }
            }
            System.out.println();
        }
    }
    public static void test1(){//1 2 3
        BinaryTree root=new BinaryTree(1);
        BinaryTree l1=new BinaryTree(2);
        BinaryTree l2=new BinaryTree(3);
        root.left=l1;
        root.right=l2;
        printTree(root);
    }
    public static void test2(){//1 2 3 4 5 6 7
        BinaryTree root=new BinaryTree(1);
        BinaryTree l1=new BinaryTree(2);
        BinaryTree l2=new BinaryTree(3);
        BinaryTree l3=new BinaryTree(4);
        BinaryTree l4=new BinaryTree(5);
        BinaryTree l5=new BinaryTree(6);
        BinaryTree l6=new BinaryTree(7);
        root.left=l1;
        root.right=l2;
        l1.left=l3;
        l1.right=l4;
        l2.left=l5;
        l2.right=l6;
        printTree(root);
    }
    public static void test3(){//1 2
        BinaryTree root=new BinaryTree(1);
        BinaryTree l1=new BinaryTree(2);
        root.right=l1;
        printTree(root);
    }
    public static void test4(){//
        BinaryTree root=null;
        printTree(root);
    }
    public static void test5(){//
        BinaryTree root=new BinaryTree(1);
        BinaryTree l1=new BinaryTree(2);
        BinaryTree l2=new BinaryTree(3);
        root.left=l1;
        l1.left=l2;
        printTree(root);
    }
    public static void test7(){//
        BinaryTree root=new BinaryTree(1);
        BinaryTree l1=new BinaryTree(2);
        BinaryTree l2=new BinaryTree(3);
        root.right=l1;
        l1.right=l2;
        printTree(root);
    }
}
