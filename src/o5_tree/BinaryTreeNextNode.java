package o5_tree;

public class BinaryTreeNextNode {
    //中序遍历寻找下一个节点
    /**
     * 有三种情况：
     * 1 有右子树的节点，那该右子树中的最左节点就是该节点的下一个节点
     * 2 无右子树的节点，且该节点为其父亲节点的左子节点
     *    那么该节点的下一个节点就是其父亲节点
     * 3 无右子树的节点，且该节点为其父亲节点的右子节点
     *    那么就向上遍历，直到找到一个节点，他是他父亲的左子节点，
     *    那么这个节点的父亲节点，就是要找的下一个节点
     *    （若便利至根节点了，就结束了）
     */
    private class Tree{
        int val;
        Tree tlef;
        Tree trig;
        Tree parent;
        Tree(int value){
            this.val=value;
        }
        Tree(){}//没有这个默认构造器。35行就会出错
    }

    /**
     * 建立一个二叉树
     * @param val
     */
    public Tree creatTree(int val){
        Tree node=new Tree();
        node.val=val;
        node.tlef=null;
        node.trig=null;
        node.parent=null;
        return node;
    }

    /**
     * 连接一个二叉树
     * @param tleft
     * @param tright
     * @param tParent
     */
    public void connectTree(Tree tParent,Tree tleft,Tree tright){

        if(tParent!=null){
            tParent.tlef=tleft;
            tParent.trig=tright;
            if(tleft!=null){
                tleft.parent=tParent;
                tright.parent=tParent;
            }
        }
    }
    public Tree getNext(Tree node){
        if(node.trig!=null){
            node=node.trig;
            while(node.tlef!=null){
                node=node.tlef;
            }
            return node;
        }
        else {
            if(node.parent!=null&&node.parent.tlef==node){
                node=node.parent;
                return node;
            }
            while(node.parent.trig==node){
                node=node.parent;
            }
            return node.parent;
        }
    }
    public  void test(Tree node,Tree expect){
        Tree next=getNext(node);
        if(next.val==expect.val){
            System.out.println(node.val+" 后面是预期节点 "+next.val);
        }
        else{
            System.out.println(node.val+" 后面不是预期节点 ");
        }
    }
    public  void pretree(Tree root){
        //前序遍历 根左右
        if(root!=null){//必须有这个判断
            System.out.print(root.val+" ");
            pretree(root.tlef);
            pretree(root.trig);
        }
    }
    public  void midtree(Tree root) {
        //中序遍历 左根右
        if (root != null) {
            midtree(root.tlef);
            System.out.print(root.val + " ");
            midtree(root.trig);
        }
    }
    public static void main(String[] args) {
       BinaryTreeNextNode binaryTreeNextNode=new BinaryTreeNextNode();
       Tree node8=binaryTreeNextNode.creatTree(8);
       Tree node6=binaryTreeNextNode.creatTree(6);
       Tree node10=binaryTreeNextNode.creatTree(10);
       Tree node5=binaryTreeNextNode.creatTree(5);
       Tree node7=binaryTreeNextNode.creatTree(7);
       Tree node9=binaryTreeNextNode.creatTree(9);
       Tree node11=binaryTreeNextNode.creatTree(11);
        /**
         *     8
         *   6    10
         *  5 7  9  11
         */
       binaryTreeNextNode.connectTree(node8,node6,node10);
       binaryTreeNextNode.connectTree(node6,node5,node7);
       binaryTreeNextNode.connectTree(node10,node9,node11);

        System.out.println("中序遍历");
        binaryTreeNextNode.midtree(node8);
        System.out.println();
        System.out.println("前序遍历");
        binaryTreeNextNode.pretree(node8);
        System.out.println();

        binaryTreeNextNode.test(node8,node9);
        binaryTreeNextNode.test(node7,node10);
        binaryTreeNextNode.test(node5,node6);
        binaryTreeNextNode.test(node10,node11);
        binaryTreeNextNode.test(node9,node10);

    }
}
