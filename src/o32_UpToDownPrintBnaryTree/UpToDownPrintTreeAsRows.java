package o32_UpToDownPrintBnaryTree;

import java.util.LinkedList;

//一层打印一行
//    1
//  2   3
//4  5 6  7
//打印之后为：1
//           2 3
//           4 5 6 7
public class UpToDownPrintTreeAsRows {
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
        LinkedList<BinaryTree> queue=new LinkedList<BinaryTree>();
        queue.offer(root);
        BinaryTree node=null;
        int count=0;//当前需要打印的节点个数
        int nextcount=1;//下次需要打印的节点个数
        while (!queue.isEmpty()){
            count=nextcount;
            nextcount=0;//清零，方便计算
            for(int i=0;i<count;i++){
                node=queue.poll();
                System.out.print(node.val+" ");
                if(node.left!=null){
                    queue.offer(node.left);
                    nextcount++;
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    nextcount++;
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
