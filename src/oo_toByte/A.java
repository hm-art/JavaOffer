package oo_toByte;

import java.util.Random;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true) {
            int l = scanner.nextInt();
            int m = scanner.nextInt();
            Fire(l, m);
        }
    }

    public static void Fire(int l, int m) {
        if(l<1||l>100000||m<1||m>100000){
            System.out.println("NO");
        }
        else{
            if(l==m){
                System.out.println("N0");
                //return false;
            }
            else if(l!=m){
                if(l>m&&(l-m==1)){
                    System.out.println("NO");
                }
                else if(l<m&&m-l==1){
                    System.out.println("NO");
                }
                else{
                int t=Integer.parseInt(getRandom(l,m));
                if(t!=l&&t!=m){
                System.out.println("YES");
                System.out.print(l+" "+m+" "+t);
                //return true;
                }
//                else if(t==l||t==m||m==l){
//                    System.out.println("NO");
//                }
                }
            }
//            System.out.println("NO");
        }
    }
    public static String getRandom(int min, int max){
        Random random = new Random();
        int s=0;
        if(min>max){
            s = random.nextInt(min) % (min - max + 1) + max;
            if(s==max)
                s=s+1;
        }else {
            s = random.nextInt(max) % (max - min + 1) + min;
            if(s==min)
                s=s+1;
        }

        return String.valueOf(s);
    }
}
