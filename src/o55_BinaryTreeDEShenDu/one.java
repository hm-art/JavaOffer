package o55_BinaryTreeDEShenDu;
//题一：求二叉树的深度
//      它的深度等于左右子树中叫大得深度，再+1
//      所以分析可知这是一个递归问题
public class one {
    public static void main(String[] args) {
        test1();//4
    }
    public static class BinaryTree{
        int val;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int val){
            this.val=val;
        }
    }
    public static int treeDepth(BinaryTree root){
        if(root==null)
            return 0;
        int left=treeDepth(root.left);
        int right=treeDepth(root.right);
        return left>right?left+1:right+1;
    }

    public static void test1(){
        BinaryTree root=new BinaryTree(5);
        BinaryTree node1=new BinaryTree(3);
        BinaryTree node2=new BinaryTree(7);
        BinaryTree node3=new BinaryTree(2);
        BinaryTree node4=new BinaryTree(4);
        BinaryTree node5=new BinaryTree(6);
        BinaryTree node6=new BinaryTree(8);
        BinaryTree node7=new BinaryTree(9);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node6.left=node7;
        System.out.println(treeDepth(root));

    }
}
