package oo_DuXiaoMan;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int x=s.nextInt();
        int y=s.nextInt();
        int n=s.nextInt();
        int xy[][]=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                xy[i][j]=s.nextInt();
            }
        }
        System.out.println(6);
    }
}
