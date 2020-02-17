package oo_MaFengWo;

import java.util.ArrayList;
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int r=scanner.nextInt();
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
        int n[] = stringToInt(s1);
        int result=chuli(n,r);
        System.out.println(result);
    }

    private static int chuli(int[] n, int r) {
       //int result=0;
//        for(int i=0;i<n.length;i++){
//            if(n[i]<r)
//                result++;
//        }
        //int pre=0;
        //int cur=0;
        int m=0;
        int p=0,q=0;
        int sum=1;
        for(q=0;q < n.length;q++){
            sum *= n[q];
            while(sum >= r && p <= q){
                sum /= n[p];
                p++;
            }
            m += q - p + 1;
        }
        return m;
    }


    //把输入的string转化为int数组
    public static int[] stringToInt(String s){
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
        int [] a=new int[count];
        for(i=0;i<count;i++){ //将strings中存储了数字的元素赋值给a中的元素
            a[i]=Integer.parseInt(strings[i]);
        }
        return a;
    }
}
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        String s=scanner.nextLine();
//        System.out.println(1);
//        System.out.println(4);
//    }
//}
