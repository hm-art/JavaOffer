package oo_VIPKID;

import java.util.Scanner;

public class TWO {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int count=0;
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n>>=1;
        }
        System.out.println(count);
    }
}
