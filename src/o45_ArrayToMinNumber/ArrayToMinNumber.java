package o45_ArrayToMinNumber;

import o23_EntranceOfRing.EntranceofRing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//45.把数组排成最小的数
//   隐形的大数问题
//   所以要把int转换成字符串，然后按照string比较就可以
public class ArrayToMinNumber {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
    public static String arrayToMinNumber(int []n){
        String s="输入无效";
        if(n==null||n.length==0)
            return s;
        List<String> list=new ArrayList<>();
        for(int i:n){
            list.add(String.valueOf(i));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a=o1+o2;
                String b=o2+o1;
                return a.compareTo(b);
            }
        });
        StringBuilder stringBuilder=new StringBuilder();
        list.forEach(c->stringBuilder.append(c));
        return stringBuilder.toString();
    }
    public static void test1(){
        int n[]=null;
        System.out.println(arrayToMinNumber(n));
    }
    public static void test2(){
        int n[]={2,1,3,4,5};
        System.out.println(arrayToMinNumber(n));//12345
    }
    public static void test3(){
        int n[]={3,323,32123};
        System.out.println(arrayToMinNumber(n));//32123 323 3
    }
    public static void test4(){
        int n[]={1,11,111};
        System.out.println(arrayToMinNumber(n));//111111
    }
    public static void test5(){
        int n[]={323};
        System.out.println(arrayToMinNumber(n));//323
    }
}
