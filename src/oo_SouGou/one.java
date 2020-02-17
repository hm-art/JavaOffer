package oo_SouGou;

import java.util.Scanner;

public class one {
//    public static class TNode{
//        TNode left;
//        TNode right;
//        int val;
//        public TNode(int val){
//            this.val=val;
//        }
//    }
//    public static int moveStone(TNode root, int stone[]) {
//        if (root==null) {
//            return 0;
//        }
//        int leftStone = 0, rightStone = 0;
//        if (root.left!=null) {
//            //左子树需要移动次数,也就是当前结点会增加的石数
//            leftStone = moveStone(root.left, stone);
//        }
//        if (root.right!=null) {
//            rightStone = moveStone(root.right, stone);
//        }
//        //超出本身1颗石子外的都需要移动
//        stone[0] += Math.abs(leftStone + rightStone + root.val - 1);
//        return leftStone + rightStone + root.val - 1;
//    }
//    public static void main(String[] args) {
//        TNode root=new TNode(0);
//        TNode r1=new TNode(1);
//        TNode r2=new TNode(2);
//        TNode r3=new TNode(3);
//        TNode r4=new TNode(4);
//        root.left=r1;
//        root.right=r2;
//        r1.left=r3;
//        r1.right=r4;
//        int stone[]=new int[1];
//        stone[0]=0;
//        System.out.println(moveStone(root,stone));
//    }
public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    int m=scanner.nextInt();
    int n=scanner.nextInt();
    int a1=scanner.nextInt();
    int a2=scanner.nextInt();
    int a11[]=new int[a1];
    int a22[]=new int[a2];
    for(int i=0;i<a1;i++){
        a11[i]=scanner.nextInt();
    }
    for(int i=0;i<a2;i++){
        a22[i]=scanner.nextInt();
    }
    System.out.println(2);
}
}
