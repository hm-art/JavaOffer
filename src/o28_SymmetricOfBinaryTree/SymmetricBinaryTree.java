package o28_SymmetricOfBinaryTree;


//28.对称二叉树
//   如果一棵二叉树和它的镜像一样，说明他是对称的
//   一棵树的前序遍历（根左右）和对称前序遍历一样（根右左），就说明他是对称二叉树
//   特殊的：所有结点值都一样的，如下所示，则用null来补充叶子
//             7
//       7           7
//   7       7    7     null
//nu nu   nu nu nu  nu
public class SymmetricBinaryTree {
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
        test6();
        test7();
    }
    public static boolean isRoot(BinaryTree root){
        if(root==null)
            return false;//根结点不存在，认为这棵树没有对称的意义所以返回false
        return isEqual(root.left,root.right);

    }

    private static boolean isEqual(BinaryTree left, BinaryTree right) {
        //树中只有一个结点，且该节点为根节点，则是对称的，返回true
        if(left==null&&right==null)
            return true;
        //左右只有一个存在，则一定不对称
        if(left==null||right==null)
            return false;
        return left.val==right.val
                &&isEqual(left.left, right.right)
                &&isEqual(left.right, right.left);
        //以下三者比较结果都是true才符合条件
        //left.val==right.val
        //isEqual(left.left, right.right)
        //isEqual(left.right, right.left);
        //                      root
        //          left                    right
        // left.left    left.right   right.left  right.right
    }


    //测试用例
    public static void test1(){//false
        BinaryTree root=null;
        System.out.println(isRoot(root));
    }
    public static void test2(){//false
        BinaryTree root=new BinaryTree(1);
        BinaryTree l1=new BinaryTree(2);
        BinaryTree l2=null;
        root.left=l1;
        root.right=l2;
        System.out.println(isRoot(root));
    }
    public static void test3(){//false
        BinaryTree root=new BinaryTree(1);
        BinaryTree l1=new BinaryTree(2);
        BinaryTree l2=new BinaryTree(3);
        root.left=l1;
        root.right=l2;
        System.out.println(isRoot(root));
    }
    public static void test4(){//true
        BinaryTree root=new BinaryTree(1);
        BinaryTree l1=new BinaryTree(2);
        BinaryTree l2=new BinaryTree(2);
        root.left=l1;
        root.right=l2;
        System.out.println(isRoot(root));
    }
    public static void test5(){//false
        BinaryTree root=new BinaryTree(1);
        BinaryTree l1=new BinaryTree(1);
        BinaryTree l2=new BinaryTree(1);
        BinaryTree l3=new BinaryTree(1);
        BinaryTree l4=new BinaryTree(1);
        BinaryTree l5=new BinaryTree(1);
        root.left=l1;
        root.right=l2;
        l1.left=l3;
        l1.right=l4;
        l2.left=l5;
        l2.right=null;
        System.out.println(isRoot(root));
    }
    public static void test6(){//true
        BinaryTree root=new BinaryTree(8);
        BinaryTree l1=new BinaryTree(6);
        BinaryTree l2=new BinaryTree(6);
        BinaryTree l3=new BinaryTree(5);
        BinaryTree l4=new BinaryTree(7);
        BinaryTree l5=new BinaryTree(7);
        BinaryTree l6=new BinaryTree(5);
        root.left=l1;
        root.right=l2;
        l1.left=l3;
        l1.right=l4;
        l2.left=l5;
        l2.right=l6;
        System.out.println(isRoot(root));
    }
    public static void test7(){//false
        BinaryTree root=new BinaryTree(8);
        BinaryTree l1=new BinaryTree(6);
        BinaryTree l2=new BinaryTree(9);
        BinaryTree l3=new BinaryTree(5);
        BinaryTree l4=new BinaryTree(7);
        BinaryTree l5=new BinaryTree(7);
        BinaryTree l6=new BinaryTree(5);
        root.left=l1;
        root.right=l2;
        l1.left=l3;
        l1.right=l4;
        l2.left=l5;
        l2.right=l6;
        System.out.println(isRoot(root));
    }
}
