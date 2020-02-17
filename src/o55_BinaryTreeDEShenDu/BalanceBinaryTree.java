package o55_BinaryTreeDEShenDu;
//题二：平衡二叉树
//      任意节点左右子树深度之差，不能超过1
//      解法一：递归，但节点会重复遍历，所以面试官不会满意
//      解法二：利用后续遍历
public class BalanceBinaryTree {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
    public static class BinaryTree{
        int val;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int val){
            this.val=val;
        }
    }
    //方法1 会重复遍历
    public static boolean isBalance(BinaryTree root){
        if(root==null)//=null时返回true，下一次递归才能正常进行
            return true;
        int left=treeDepth(root.left);
        int right=treeDepth(root.right);
        int depth=Math.abs(left-right);
        if(depth>1)
            return false;
        return isBalance(root.left)&&isBalance(root.right);

    }
    public static int treeDepth(BinaryTree root){
        if(root==null)
            return 0;
        int left=treeDepth(root.left);
        int right=treeDepth(root.right);
        return left>right?left+1:right+1;
    }
    //方法二 每个节点就只遍历一次 从下往上遍历得
    public static boolean isBalace2(BinaryTree root,int[] depth){
        //depth必须是数组，不能是单纯的int型
        if(root==null){
            depth[0]=0;
            return true;
        }
        boolean left=isBalace2(root.left,depth);
        int dleft=depth[0];
        boolean right=isBalace2(root.right,depth);
        int dright=depth[0];
        //当前节点的根得深度
        depth[0]=Math.max(dleft,dright)+1;
        //如果左右都存在且深度差<=1 返回true
        if(left&&right&&Math.abs(dleft-dright)<=1){
            return true;
        }
        return false;
    }
    public static void test1(){
//           5
//        3   7
//      2  4 6  8
//             9
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
        System.out.println(isBalance(root));
        int depth[]=new int[1];
        depth[0]=0;
        System.out.println(isBalace2(root,depth));
    }
    public static void test2(){
//           5
//        3   7
//           6  8
//             9
        BinaryTree root=new BinaryTree(5);
        BinaryTree node1=new BinaryTree(3);
        BinaryTree node2=new BinaryTree(7);

        BinaryTree node5=new BinaryTree(6);
        BinaryTree node6=new BinaryTree(8);
        BinaryTree node7=new BinaryTree(9);
        root.left=node1;
        root.right=node2;
        node2.left=node5;
        node2.right=node6;
        node6.left=node7;
        System.out.println(isBalance(root));
        int depth[]=new int[1];
        depth[0]=0;
        System.out.println(isBalace2(root,depth));
    }
    public static void test3(){
//           5
//            7
//             8
//
        BinaryTree root=new BinaryTree(5);
        BinaryTree node2=new BinaryTree(7);
        BinaryTree node6=new BinaryTree(8);
        root.right=node2;
        node2.right=node6;
        System.out.println(isBalance(root));
        int depth[]=new int[1];
        depth[0]=0;
        System.out.println(isBalace2(root,depth));
    }

}
