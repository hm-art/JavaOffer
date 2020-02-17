package oo_360;

import java.util.Scanner;
//序列重组
//        时间限制：C/C++语言 1000MS；其他语言 3000MS
//        内存限制：C/C++语言 65536KB；其他语言 589824KB
//        题目描述：
//        在一个古老的国度，这个国家的人并不懂得进位，但是对取模情有独钟，因此诞生了一个经典的问题，给出两个在m进制下含有n位的数字，你可以分别将这两个数各位上的数字重新排列，然后将两个数按位对应相加并分别对m取模，这样显然可以得到一个新的m进制下的n位数(可能存在前导0)，但是这个结果是不唯一的，问题来了，按照这样的操作，能够得到的最大的m进制下的数字是多少呢。
//
//        输入
//        输入第一行包含两个正整数n,m分别表示数字含有n位，和在m进制下。
//
//        输入第二行和第三行分别包含n个整数，中间用空格隔开，每个整数都在0到m-1之间。每行第i个数表示的是当前数第i位上的数字。
//
//        输出
//        输出包含n个数字，中间用空格隔开，表示得到的最大的数字，从高位到低位输出，如6在2进制下输出3位的结果是1 1 0。
//
//
//        样例输入
//        5 5
//        4 4 1 1 1
//        4 3 0 1 2
//        样例输出
//        4 4 3 3 2
//
//        提示
//        4 4 1 1 1 →1 4 1 4 1
//        4 3 0 1 2 →3 0 2 4 1（重排序列不唯一，数位相加后的数字为 4 4 3 8 2，对5取模即可 ）
public class two {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();//每个数有n位
        int m=scanner.nextInt();//m进制
        int a1[]=new int[n];
        int a2[]=new int[n];
        for(int i=0;i<n;i++){
            a1[i]=scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            a2[i]=scanner.nextInt();
        }

    }
    public static void zhuan(int a1[],int a2[],int m,int n){

    }
}
