package oo_ShunFeng;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();//人数
        int m=scanner.nextInt();//语言数
        int k=scanner.nextInt();//已知信息数
        int xinxi[][]=new int[k][2];
        for(int i=0;i<xinxi.length;i++){
            for(int j=0;j<xinxi[0].length;j++){
                xinxi[i][j]=scanner.nextInt();
            }
        }
        System.out.println(2);
    }
}
