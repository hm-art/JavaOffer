package oo_RenRen;

import java.util.ArrayList;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char c[] = s.toCharArray();
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ',') {
                arrayList.add(' ');
            } else {
                arrayList.add(c[i]);
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            str.append(arrayList.get(i));
        }
        String s1 = str.toString();
        long n[] = stringToInt(s1);
        long max=MaxSum(n);
        System.out.print(max);
    }
    //把输入的string转化为int数组
    public static long[] stringToInt(String s){
        String[] strings=new String[s.length()];
        int i,k=0,count=0;
        for(i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                if(strings[k]==null) //如果是第一个计数的数字则直接赋值
                    strings[k]=String.valueOf(s.charAt(i));
                else //否则直接添加到其后面
                    strings[k]=strings[k]+s.charAt(i);
            }
            else{ //如果是第一次出现的空格，则k+1，这一次空格（可能有多个连续空格）后面出现的数字存储到strings的下一个元素中
                if(s.charAt(i-1)!=' ')
                    k++;
            }
        }
        for(i=0;i<s.length();i++){ //得到strings中存储了数字（不是null）的元素个数
            if(strings[i]!=null)
                count++;
        }
        long [] a=new long[count];
        for(i=0;i<count;i++){ //将strings中存储了数字的元素赋值给a中的元素
            a[i]=Integer.parseInt(strings[i]);
        }
        return a;
    }
    //连续子数组和的最大值
    public static long MaxSum(long []n){
        boolean flag=false;//若返回值为0，判断是输入出错输出0，还是返回值就是0
        if(n==null||n.length==0){
            flag=true;//输入出错
            return 0;
        }
        flag=false;
        long curSum=n[0];
        long maxSum=n[0];
        for(int i=1;i<n.length;i++){
            if(curSum<0)
                curSum=n[i];
            else
                curSum+=n[i];
            if(curSum>maxSum)
                maxSum=curSum;
        }
        return maxSum;
    }
}
