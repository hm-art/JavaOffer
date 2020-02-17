package oo_LiuLiShuo;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(qingwatiao1(n));
    }
    public static long qingwatiao1(int n){
        if(n<=0)
            return 0;
        else if(n==1)
            return 1;
        else if(n==2)
            return 2;
        long pre=2;
        long prepre=1;
        long current=2;
        for(int i=3;i<=n;i++){
            current=pre+prepre;
            prepre=pre;
            pre=current;
        }
        return current;
    }
}
