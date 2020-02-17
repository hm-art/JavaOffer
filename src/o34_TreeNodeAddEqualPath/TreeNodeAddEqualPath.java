package o34_TreeNodeAddEqualPath;


import java.util.ArrayList;
import java.util.List;

//34.二叉树中和为某一值得路径
//   举例子分析可知道要借用 lsit 和 树的前序遍历
//   树不为空但没有找到合适路径的情况下，什么都不输出
public class TreeNodeAddEqualPath {
    public static class BinaryTree{
        int val;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int val){
            this.val=val;
        }
    }

    public static void main(String[] args) {
            //test1();
            //test2();
            //test3();
            //test4();
            test5();
    }
    //
    public static void findPath(BinaryTree root,int sum){
        if(root==null){
            System.out.println("树是空的");
            return;
        }
        List<Integer> list=new ArrayList<>();
        printPath(root,sum,list);
    }
    //sum 路径的和，目标值
    private static void printPath(BinaryTree root, int sum, List<Integer> list) {
        if(root==null)//递归结束条件
        {

            return;
        }

        list.add(root.val);
        sum-=root.val;
        if(sum==0&&root.left==null&&root.right==null){//成功找到路径，打印出来
            for(Integer i:list)
                System.out.print(i+" ");
            System.out.println();
        }else{
            printPath(root.left,sum,list);
            printPath(root.right,sum,list);
        }
        list.remove(list.size()-1);
          //表示还没找到路径，但当前已经走过的节点不符，
          // 所以删除最后进入list的节点，相当于返回上一个节点
    }
    public static void test1(){
        BinaryTree root=null;
        int sum=10;
        findPath(root,sum);
    }
    public static void test2(){//1
        BinaryTree root=new BinaryTree(1);
        int sum=1;
        findPath(root,sum);
    }
    public static void test3(){//已经全都遍历完了
        BinaryTree root=new BinaryTree(1);
        int sum=10;
        findPath(root,sum);
    }
    public static void test4(){// 10 5 7
                               // 10 12
        BinaryTree root=new BinaryTree(10);
        BinaryTree l1=new BinaryTree(5);
        BinaryTree l2=new BinaryTree(12);
        BinaryTree l3=new BinaryTree(4);
        BinaryTree l4=new BinaryTree(7);
        root.left=l1;
        root.right=l2;
        l1.left=l3;
        l1.right=l4;
        int sum=22;
        findPath(root,sum);
    }
    public static void test5(){//已经全都遍历完了
        BinaryTree root=new BinaryTree(10);
        BinaryTree l1=new BinaryTree(5);
        BinaryTree l2=new BinaryTree(12);
        BinaryTree l3=new BinaryTree(4);
        BinaryTree l4=new BinaryTree(7);
        root.left=l1;
        root.right=l2;
        l1.left=l3;
        l1.right=l4;
        int sum=100;
        findPath(root,sum);
    }
}
