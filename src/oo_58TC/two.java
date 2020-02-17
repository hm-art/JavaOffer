package oo_58TC;

import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int m[]=new int[num];
        for(int i=0;i<num;i++){
            m[i]=scanner.nextInt();
        }
        int temp[]=buyCookie(m,num);
        System.out.println(getCnum(temp,num));
    }

    private static int[] buyCookie(int[] m,int num) {
        if(m==null||m.length<=0)
            return null;
        int temp[]=new int[num];
        for(int i=0;i<num;i++){
            temp[i]=1;
        }
        for(int i=0;i<num-1;i++){
            if(m[i+1]>m[i]){
                temp[i+1]=temp[i]+1;
            }
        }
//        if(m[num-1]>m[num-2])
//            temp[num-1]=temp[num-2]+1;
        for(int i=num-1;i>0;i--){
            if(m[i]<m[i-1]&&temp[i-1]<=temp[i]){
                temp[i-1]=temp[i]+1;
            }
        }
        return temp;
    }
    public static int getCnum(int temp[],int num){
        int all=0;
        for(int i=0;i<num;i++)
            all+=temp[i];
        return all;
    }
}
