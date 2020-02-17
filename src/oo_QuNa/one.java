package oo_QuNa;

import java.util.ArrayList;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        if(n<=0){
            return;
        }
        int size=n*n;
        int m[]=new int[size];
        for(int i=0;i<size;i++){
            m[i]=scanner.nextInt();
        }
        System.out.println(maxCh(m));
    }

    private static int maxCh(int[] m) {
        int max=0;
        if(m==null||m.length==0)
            throw new RuntimeException();
        int l=m.length;
        int jishu=0;
        for(int i=0;i<l;i++){
            if(m[i]<0){
                jishu++;
            }
        }

        if(jishu==l){//全是小于0的
            max=m[0];
            for(int i=1;i<l;i++){
                if(m[i]>max)
                   max=m[i];
            }
            return max;
        }
            for(int i=0;i<l;i++){
                if(m[i]>=0){
                   max+=m[i];
                }
            }

        return max;
    }

}
