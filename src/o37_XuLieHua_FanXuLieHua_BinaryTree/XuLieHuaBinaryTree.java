package o37_XuLieHua_FanXuLieHua_BinaryTree;
//37.序列化和反序列化二叉树
//   序列化若是从根节点开始，那么反序列化在根节点读出来的同时就可以开始了
//   所以思路是二叉树的前序遍历
//   序列化时，指针为空的部分用特殊字符代替，便于反序列化
//   大问题分解为小问题，所以用递归
public class XuLieHuaBinaryTree {
    public static class BinaryTree{
        int val;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int val){
            this.val=val;
        }
    }

    public static void main(String[] args) {
//        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    static StringBuilder sb=new StringBuilder();
    public static String serilize(BinaryTree root){
        BinaryTree node=root;
        if(node==null){
            sb.append("$,");
        }else{
            sb.append(node.val+",");
            serilize(root.left);
            serilize(root.right);
        }
        return sb.toString();
    }
    public static int index=0;
    public static BinaryTree reverseSerilize(String str){
        if(str.length()==0||str==null){
            return null;
        }
        BinaryTree node=null;
        int start=index;
        while(str.charAt(index)!=','){
            index++;
        }
        if(!str.substring(start,index).equals("$")){//不是$符号
            //有可能是多位数，所以用str.substring（）
            node=new BinaryTree(Integer.parseInt(str.substring(start,index)));
            index++;
            node.left=reverseSerilize(str);
            node.right=reverseSerilize(str);
        }else{//是$符号,则直接掠过去
            index++;
        }
        return node;
    }
    //测试
    public static boolean isSameTree(BinaryTree root1,BinaryTree root2){
        if(root1==root2&&root2==null)
            return true;
        if(root1==null||root2==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return isSameTree(root1.left, root2.left)&&
                isSameTree(root1.right, root2.right);
    }
    public static void test1(){
        BinaryTree root=null;
        String str=serilize(root);
        BinaryTree root2=reverseSerilize(str);
        System.out.println(isSameTree(root,root2));

    }
    public static void test2(){
        BinaryTree root=new BinaryTree(1);
        String str=serilize(root);
        BinaryTree root2=reverseSerilize(str);
        System.out.println(isSameTree(root,root2));
    }
    public static void test3(){
        BinaryTree root=new BinaryTree(1);
        BinaryTree r2=new BinaryTree(2);
        BinaryTree r3=new BinaryTree(3);
        root.left=r2;
        r2.left=r3;
        String str=serilize(root);
        BinaryTree root2=reverseSerilize(str);
        System.out.println(isSameTree(root,root2));
    }
    public static void test4(){
        BinaryTree root=new BinaryTree(1);
        BinaryTree r2=new BinaryTree(2);
        BinaryTree r3=new BinaryTree(3);
        root.right=r2;
        r2.right=r3;
        String str=serilize(root);
        BinaryTree root2=reverseSerilize(str);
        System.out.println(isSameTree(root,root2));
    }
    public static void test5(){
        BinaryTree root=new BinaryTree(1);
        BinaryTree r2=new BinaryTree(2);
        BinaryTree r3=new BinaryTree(3);
        root.left=r2;
        root.right=r3;
        String str=serilize(root);
        BinaryTree root2=reverseSerilize(str);
        System.out.println(isSameTree(root,root2));
    }
    public static void test6(){
        BinaryTree root=new BinaryTree(1);
        BinaryTree r2=new BinaryTree(1);
        BinaryTree r3=new BinaryTree(1);
        root.left=r2;
        root.right=r3;
        String str=serilize(root);
        BinaryTree root2=reverseSerilize(str);
        System.out.println(isSameTree(root,root2));
    }
    public static void test7(){
        BinaryTree root=new BinaryTree(1);
        BinaryTree r2=new BinaryTree(2);
        BinaryTree r3=new BinaryTree(3);
        BinaryTree r4=new BinaryTree(4);
        BinaryTree r5=new BinaryTree(5);
        BinaryTree r6=new BinaryTree(6);
        root.left=r2;
        root.right=r3;
        r2.left=r4;
        r3.left=r5;
        r3.right=r6;
        String str=serilize(root);
        BinaryTree root2=reverseSerilize(str);
        System.out.println(isSameTree(root,root2));
    }
}
