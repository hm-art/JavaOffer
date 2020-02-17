package o32_UpToDownPrintBnaryTree;
//32.从上到下打印二叉树（实际上就是广度优先遍历二叉树）
//   printTree():层序遍历打印二叉树 利用队列queue
import java.util.LinkedList;

public class UpToDownPrintBnaryTree {
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
    }
    public static void printTree(BinaryTree root){
        if(root==null){
            System.out.println("树是空的");
            return;
        }
        LinkedList<BinaryTree> queue=new LinkedList<BinaryTree>();
        queue.offer(root);
        BinaryTree node=null;
        while(queue.size()!=0){
            node=queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
        System.out.println();
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
}
