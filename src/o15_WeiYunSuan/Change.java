package o15_WeiYunSuan;

import java.util.Scanner;

//一个数改变几位才能变成另一个数
public class Change {
    public static void main(String[] args) {
        int m,n;
        Scanner scanner=new Scanner(System.in);
        while(true){
            m=scanner.nextInt();
            n=scanner.nextInt();
            System.out.println(Integer.toBinaryString(m));
            System.out.println(Integer.toBinaryString(n));
            System.out.println(change(m,n));

        }
    }

    private static int change(int m, int n) {
        int temp=0;
        temp=m^n;
        int sum=0;
        while(temp!=0){
            temp=(temp-1)&temp;
            sum++;
        }
        return sum;
    }
}
