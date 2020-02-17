package o26_HasChildBinaryTree;
//26.树的子结构
//   分成两部：
//   1.找到A中和树B根节点一样的结点
//   2.检查二者的叶子结点是否相同
//注意：要考虑到大量的空指针
public class HasChildTree {
    public static void main(String[] args) {
         //test1();
        //test2();
        //test3();
        test4();
        test5();
        test6();
        test7();
    }
    public static class BinaryTree{
        int val;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int val, BinaryTree left,BinaryTree right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static boolean hasRoot(BinaryTree root1,BinaryTree root2){
        boolean result=false;//表示A中无B
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val){
                result=hasLeftandRight(root1,root2);
            }
            if(!result){
                result=hasRoot(root1.left, root2);
            }
            if(!result){
                result=hasRoot(root1.right, root2);
            }
        }
        return result;
    }

    private static boolean hasLeftandRight(BinaryTree root1, BinaryTree root2) {
        //二者同时遍历完了，表明这两棵树相同，则A自然包含（等于）B
        if(root1==null&&root2==null)
            return true;
        //这种情况下B树遍历完了，则A包含B
        if(root2==null)
            return true;
        if(root1==null)
            return false;//A遍历完了B没有，A自然不包含B
        if(root1.val!=root2.val)//有一个结点不相等，则退出这个函数
            return false;
        //其他情况则继续判断左和右
        return hasLeftandRight(root1.left, root2.left)&&hasLeftandRight(root1.right, root2.right);
    }
    //测试用例
    public static void judge(boolean result){
        if(result==false){
            System.out.println("A中不包含B/其中一个为null/二者都为null");
        }else{
            System.out.println("A中包含B/A=B");
        }
    }
    public static void test1(){
        BinaryTree node1=null;
        BinaryTree node2=null;
        boolean result=hasRoot(node1,node2);
        judge(result);
    }
    public static void test2(){
        //             1          1
        //          2    3
        //       4    5 6   7
        BinaryTree n17=new BinaryTree(7,null,null);
        BinaryTree n16=new BinaryTree(6,null,null);
        BinaryTree n15=new BinaryTree(5,null,null);
        BinaryTree n14=new BinaryTree(4,null,null);
        BinaryTree n13=new BinaryTree(3,n16,n17);
        BinaryTree n12=new BinaryTree(2,n14,n15);
        BinaryTree node1=new BinaryTree(1,n12,n13);

        BinaryTree node2=new BinaryTree(1,null,null);
        boolean result=hasRoot(node1,node2);
        judge(result);
    }
    public static void test3(){
        //             1             1
        //          2    3        2
        //       4    5 6   7
        BinaryTree n17=new BinaryTree(7,null,null);
        BinaryTree n16=new BinaryTree(6,null,null);
        BinaryTree n15=new BinaryTree(5,null,null);
        BinaryTree n14=new BinaryTree(4,null,null);
        BinaryTree n13=new BinaryTree(3,n16,n17);
        BinaryTree n12=new BinaryTree(2,n14,n15);
        BinaryTree node1=new BinaryTree(1,n12,n13);

        BinaryTree n21=new BinaryTree(2,null,null);
        BinaryTree node2=new BinaryTree(1,n21,null);
        boolean result=hasRoot(node1,node2);
        judge(result);
    }
    public static void test4(){
        //             1             2
        //          2    3        4    5
        //       4    5 6   7
        BinaryTree n17=new BinaryTree(7,null,null);
        BinaryTree n16=new BinaryTree(6,null,null);
        BinaryTree n15=new BinaryTree(5,null,null);
        BinaryTree n14=new BinaryTree(4,null,null);
        BinaryTree n13=new BinaryTree(3,n16,n17);
        BinaryTree n12=new BinaryTree(2,n14,n15);
        BinaryTree node1=new BinaryTree(1,n12,n13);

        BinaryTree n22=new BinaryTree(5,null,null);
        BinaryTree n21=new BinaryTree(4,null,null);
        BinaryTree node2=new BinaryTree(2,n21,n22);
        boolean result=hasRoot(node1,node2);
        judge(result);
    }
    public static void test5(){
        //             1             1
        //          2    3        2    3
        //       4    5 6  7    4   5  6   7
        BinaryTree n17=new BinaryTree(7,null,null);
        BinaryTree n16=new BinaryTree(6,null,null);
        BinaryTree n15=new BinaryTree(5,null,null);
        BinaryTree n14=new BinaryTree(4,null,null);
        BinaryTree n13=new BinaryTree(3,n16,n17);
        BinaryTree n12=new BinaryTree(2,n14,n15);
        BinaryTree node1=new BinaryTree(1,n12,n13);

        BinaryTree n26=new BinaryTree(7,null,null);
        BinaryTree n25=new BinaryTree(6,null,null);
        BinaryTree n24=new BinaryTree(5,null,null);
        BinaryTree n23=new BinaryTree(4,null,null);
        BinaryTree n22=new BinaryTree(3,n25,n26);
        BinaryTree n21=new BinaryTree(2,n23,n24);
        BinaryTree node2=new BinaryTree(1,n21,n22);
        boolean result=hasRoot(node1,node2);
        judge(result);
    }

    public static void test6(){
        //             1             2
        //          2    3        4    3
        //       4    5 6   7
        BinaryTree n17=new BinaryTree(7,null,null);
        BinaryTree n16=new BinaryTree(6,null,null);
        BinaryTree n15=new BinaryTree(5,null,null);
        BinaryTree n14=new BinaryTree(4,null,null);
        BinaryTree n13=new BinaryTree(3,n16,n17);
        BinaryTree n12=new BinaryTree(2,n14,n15);
        BinaryTree node1=new BinaryTree(1,n12,n13);

        BinaryTree n22=new BinaryTree(3,null,null);
        BinaryTree n21=new BinaryTree(4,null,null);
        BinaryTree node2=new BinaryTree(2,n21,n22);
        boolean result=hasRoot(node1,node2);
        judge(result);
    }
    public static void test7(){
        //             1             null
        //          2    3
        //       4    5 6   7
        BinaryTree n17=new BinaryTree(7,null,null);
        BinaryTree n16=new BinaryTree(6,null,null);
        BinaryTree n15=new BinaryTree(5,null,null);
        BinaryTree n14=new BinaryTree(4,null,null);
        BinaryTree n13=new BinaryTree(3,n16,n17);
        BinaryTree n12=new BinaryTree(2,n14,n15);
        BinaryTree node1=new BinaryTree(1,n12,n13);

        BinaryTree node2=null;
        boolean result=hasRoot(node1,node2);
        judge(result);
    }
}
