package o17_PrintAtoBNum;

import java.util.Scanner;

//数字排列得办法，用递归
public class PrintNum2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true){
            int n=scanner.nextInt();
            PrintOneToMax(n);
        }
    }
    private static void PrintOneToN(char[] c) {//用来打印的函数
        boolean flag0=true;
        for(int i=0;i<c.length;i++){
            if(flag0==true&&c[i]!='0'){
                flag0=false;
            }
            if(flag0==false){//这一位不是0，就会打印
                System.out.print(c[i]);
            }
        }
        System.out.println();
    }

    private static void PrintOneToMax(int n) {
        char c[]=new char[n];
        for(int i=0;i<10;i++){
            c[0]=(char)(i+'0');
            Print1toMax(c,n,0);
        }
    }

    private static void Print1toMax(char[] c, int length, int index) {
        if(index==length-1){
            PrintOneToN(c);
            return;
        }
        for(int i=0;i<10;i++){
            c[index+1]=(char)(i+'0');
            Print1toMax(c,length,index+1);
        }

    }
}
