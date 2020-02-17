package o27_MirrorOfBinaryTree;

import java.util.LinkedList;

//27.二叉树的镜像
//方法1：最简单的递归做镜像
//方法2：非递归做镜像 用栈
//方法3：用二叉树的层序遍历实现镜像=广度优先搜索
//      先将根结点入队，然后讲根节点弹出
//      再将根结点的子节点入列
//      直至队列为空
public class MirrorOfBinaryTree {
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
        //test2();
        //test3();
        //test4();
    }
    //方法1：最简单的递归做镜像
    public static void mirror(BinaryTree root){
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
            return;
        BinaryTree temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirror(root.left);
        mirror(root.right);
    }
    //方法2：非递归做镜像 用栈
    public static void mirror2(BinaryTree root){
        LinkedList<BinaryTree> stack=new LinkedList<BinaryTree>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                if(root.left!=null||root.right!=null){
                    BinaryTree temp=root.right;
                    root.right=root.left;
                    root.left=temp;
                }
                root=root.left;
            }
            if(!stack.isEmpty()){
                root=stack.pop();
                root=root.right;
            }
        }
    }
    //方法3：用二叉树的层序遍历实现镜像=广度优先搜索
    //先将根结点入队，然后讲根节点弹出
    // 再将根结点的子节点入列
    //直至队列为空
    public static void mirror3(BinaryTree root){
        if(root==null)
            return;
        LinkedList<BinaryTree> queue=new LinkedList<BinaryTree>();
        queue.offer(root);
        while(!queue.isEmpty()){//队列不为空时
             BinaryTree binaryTree=queue.poll();//出队
             System.out.println(binaryTree.val);//输出结果表明是层序的
             if(binaryTree.left!=null||binaryTree.right!=null){
                 BinaryTree temp=binaryTree.left;
                 binaryTree.left=binaryTree.right;
                 binaryTree.right=temp;
             }
             if(binaryTree.left!=null){
                 queue.offer(binaryTree.left);
             }
             if(binaryTree.right!=null){
                 queue.offer(binaryTree.right);
             }
        }
    }
    //打印某结点
    public static void printNode(BinaryTree root){
        if(root!=null){
            System.out.println("该节点值为： "+root.val);
            if(root.left!=null){
                System.out.println("该节点左子节点值为: "+root.left.val);
            }else{
                System.out.println("该节点左子节点为空");
            }
            if(root.right!=null){
                System.out.println("该节点右子节点值为: "+root.right.val);
            }else{
                System.out.println("该节点右子节点为空");
            }
        }else{
            System.out.println("该结点为空");
        }
    }
    //打印树 前序遍历来打印树 根左右
    public static void printTree(BinaryTree root){
       printNode(root);
       if(root!=null){
           if(root.left!=null)
               printTree(root.left);
           if(root.right!=null)
               printTree(root.right);
       }
    }
    //测试用例
    public static void test1(){
        //     1            镜像后     1
        //   2   3                 3    2
        // 4  5  6  7          7    6  5   4
        BinaryTree root=new BinaryTree(1);
        BinaryTree l2=new BinaryTree(2);
        BinaryTree l3=new BinaryTree(3);
        BinaryTree l4=new BinaryTree(4);
        BinaryTree l5=new BinaryTree(5);
        BinaryTree l6=new BinaryTree(6);
        BinaryTree l7=new BinaryTree(7);
        root.left=l2;
        root.right=l3;
        l2.left=l4;
        l2.right=l5;
        l3.left=l6;
        l3.right=l7;
        BinaryTree temproot=root;
        mirror3(root);
        printTree(temproot);
    }
    public static void test2(){
        //     1            镜像后     1
        //   2   3                 3    2
        // 4  5  6  null       null 6  5 4
        BinaryTree root=new BinaryTree(1);
        BinaryTree l2=new BinaryTree(2);
        BinaryTree l3=new BinaryTree(3);
        BinaryTree l4=new BinaryTree(4);
        BinaryTree l5=new BinaryTree(5);
        BinaryTree l6=new BinaryTree(6);
        //BinaryTree l7=new BinaryTree(7);
        root.left=l2;
        root.right=l3;
        l2.left=l4;
        l2.right=l5;
        l3.left=l6;
        //l3.right=l7;
        BinaryTree temproot=root;
        mirror2(root);
        printTree(temproot);
    }
    public static void test3(){
        BinaryTree root=null;
        BinaryTree temproot=root;
        mirror2(root);
        printTree(temproot);
    }
    public static void test4(){
        BinaryTree root=new BinaryTree(1);
        BinaryTree temproot=root;
        mirror2(root);
        printTree(temproot);
    }
}
