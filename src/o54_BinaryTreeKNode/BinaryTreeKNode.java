package o54_BinaryTreeKNode;

import java.util.LinkedList;

//54.二叉搜索树得第K大节点
//   已知二叉搜索树的特点是 右>根>左
//   所以中序遍历所得的第K个节点，就是我们要的
//   考察的就是二叉树得中序遍历
public class BinaryTreeKNode {
    public static void main(String[] args) {
        test1();
    }
    public static class BinaryTree{
        int val;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int val){
            this.val=val;
        }
    }
    public static BinaryTree find(BinaryTree root,int k){
        if(root==null||k<=0)//默认从1开始计数
            return null;
        LinkedList<BinaryTree> stack=new LinkedList<>();
        int count=0;
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            if(!stack.isEmpty()){
                root=stack.pop();
                if(++count==k){
                    return root;
                }
                root=root.right;
            }
        }
        return null;
    }
    public static void test1(){
        BinaryTree root=new BinaryTree(5);
        BinaryTree node1=new BinaryTree(3);
        BinaryTree node2=new BinaryTree(7);
        BinaryTree node3=new BinaryTree(2);
        BinaryTree node4=new BinaryTree(4);
        BinaryTree node5=new BinaryTree(6);
        BinaryTree node6=new BinaryTree(8);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        System.out.println(find(root,3).val);
        System.out.println(find(root,1).val);
        System.out.println(find(root,7).val);
        //System.out.println(find(root,3).val);
    }
}
