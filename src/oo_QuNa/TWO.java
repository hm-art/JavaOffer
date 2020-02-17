package oo_QuNa;

import oo_other.B;

import java.beans.BeanInfo;
import java.util.Scanner;

public class TWO {
    public static class BinaryTree{
        BinaryTree l;
        BinaryTree r;
        char value;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.next();
        String s2=scanner.next();
        char zhong[]=s1.toCharArray();
        char hou[]=s2.toCharArray();
        BinaryTree root=buildTree(hou,0,hou.length-1,zhong,0,zhong.length-1);
        preBianLi(root);
    }

    private static void preBianLi(BinaryTree root) {
        if(root!=null){
            System.out.print(root.value);
            preBianLi(root.l);
            preBianLi(root.r);
        }
        //System.out.println();
    }

    private static BinaryTree buildTree(char[] hou, int i, int i1, char[] zhong, int i2, int i3) {
        if(i>i1){
            return null;
        }
        BinaryTree root=new BinaryTree();
        char value=hou[i1];
        root.value=value;
        int index=0;
        for(int j=i2;j<=i3;j++){
            if(zhong[j]==value) {
                index = j;
                break;
            }
        }
        int count=index-i2;
        root.l=buildTree(hou,i,i+count-1,zhong,i2,index-1);
        root.r=buildTree(hou,i+count,i1-1,zhong,index+1,i3);
        return root;
    }


}
