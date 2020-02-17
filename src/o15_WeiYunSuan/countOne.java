package o15_WeiYunSuan;

import java.util.Scanner;

//十进制转二进制后1得个数
public class countOne {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true){
            int m=scanner.nextInt();
            int n=CountOne(m);
            int n1=goodCountOne(m);
            System.out.println(Integer.toBinaryString(m));
            System.out.println(n);
            System.out.println(n1);
        }
    }
    //循环的次数等于二进制的位数，不够优化（在这里32位所以循环32次）
    private static int CountOne(int m) {
        int count=0;
        int flag=1;
        while(flag!=0){
            if((m&flag)!=0)//不可用==1判断
                count++;
            flag=flag<<1;
        }
        return count;
    }
    //有几个1就循环几次，比较优化
    private static int goodCountOne(int m) {
         int count=0;
         while(m!=0){
             count++;
             m=(m-1)&m;
         }
         return count;
    }
    }
