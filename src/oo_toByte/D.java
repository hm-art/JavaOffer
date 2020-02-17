package oo_toByte;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int v=VecolCup(a,b);
        System.out.println(v);
    }

    private static int VecolCup(int a, int b) {
        int max=30;
        int v=0;
        if(a<1||b<1||a>30||b>30){
            return 0;
        }
        if(a==1&&b==1){
            return 1;
        }
        if(a==2&&b==1){
            return 3;
        }
        if(a==2&&b==2){
            return 3;
        }
        int p[][]=new int[max][max];
        p[0][0]=0;
        p[1][1]=1;
        p[2][1]=1;
        p[2][2]=1;
        if(a>2){
            v=(a+1)*a/2;
        }
        return v;
    }
}
