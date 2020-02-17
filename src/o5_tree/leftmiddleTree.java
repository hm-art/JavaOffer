package o5_tree;

public class leftmiddleTree {
    public static class Tree{
        int val;
        Tree tleft;
        Tree tright;
    }

    public static void main(String[] args) {
        int []preorder={1,2,4,7,3,5,6,8};
        int []miorder={4,7,2,1,5,3,6,8};
        Tree root=constructor(preorder,miorder);
        System.out.println("前序遍历:");
        pretree(root);
        System.out.println();
        System.out.println("中序遍历:");
        midtree(root);
    }
    public static void pretree(Tree root){
    //前序遍历 根左右
        if(root!=null){//必须有这个判断
            System.out.print(root.val+" ");
            pretree(root.tleft);
            pretree(root.tright);
        }
    }
    public static void midtree(Tree root) {
        //中序遍历 左根右
        if (root != null) {
            midtree(root.tleft);
            System.out.print(root.val + " ");
            midtree(root.tright);
        }
    }
    /**
     *
     * @param preorder 前序遍历数组
     * @param miorder  中序遍历数组
     * @return
     */
    public static Tree constructor(int []preorder,int []miorder){
        if(preorder==null||miorder==null||preorder.length!=miorder.length||miorder.length<1){
            return null;//
        }
        return constructor(preorder,0,preorder.length-1, miorder,0,miorder.length-1);
    }

    /**
     *
     * @param preorder 前序遍历数组
     * @param i 前序遍历起始位置
     * @param i1 前序遍历结束位置
     * @param miorder 中序遍历数组
     * @param i2 中序遍历起始位置
     * @param i3 中序遍历结束位置
     * @return
     */
    private static Tree constructor(int []preorder,int i,int i1,int []miorder,int i2,int i3){
        if(i>i1){
           return null;
        }
        int value=preorder[i];//前序中根的值
        int index=i2;
        while (index<=i3&&miorder[index]!=value){
            index++;//计算中序遍历中，已知一个跟，它的左子树有几个元素
        }
        if(index>i3){
            throw new RuntimeException("错误的输入");
        }
        Tree node=new Tree();
        node.val=value;
        node.tleft=constructor(preorder, i+1, i+index-i2, miorder, i2, index-1);
        node.tright=constructor(preorder, i+index-i2+1, i1, miorder, index+1, i3);
        return node;
    }
}
