package oo_niuke;

//public class wangyi1wu {
//}

import java.util.Scanner;
import java.util.Stack;

public class wangyi1wu {
    public static void main(String[] args) {
        int n,m;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();
        Stack s[]=new Stack[n+1];
        for(int i=1;i<=n;i++){
            s[i]=new Stack();
        }
        for(int i=0;i<m;i++){
            int tem=in.nextInt();
            s[tem].push(1);
        }
        int score=0;
        for(int i=0;i<m;i++){
            for(int j=1;j<=n;j++){
                if(!s[j].empty()){
                    s[j].pop();
                }
                else{
                    System.out.println(score);
                    return;
                }
            }
            score++;
        }
        System.out.println(score);
    }

}
