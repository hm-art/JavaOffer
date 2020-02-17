package o15_WeiYunSuan;

import java.util.Scanner;

//判断一个数是不是2得正整次方
public class TwoPower {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true){
            int m=scanner.nextInt();
            System.out.println(Judge(m));
        }
    }

    private static boolean Judge(int m) {
        int n=0;
        while(m!=0){
            m=(m-1)&m;
            n++;
        }
        if(n==1)
            return true;//是2得正整次方
        return false;
    }
}
