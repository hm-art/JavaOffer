package oo_58TC;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.HashMap;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        int a[]=stringToInt(s);
        System.out.println(getNoRepeat(a));

    }
    //把输入的string转化为int数组
    public static int[] stringToInt(String s){
        if(s==null||s.length()<=0)
            return null;
        String[] strings=s.split(",");
        int a[]=new int[strings.length];
        for(int i=0;i<strings.length;i++){
            a[i]=Integer.parseInt(strings[i]);
        }
        return a;
    }
    public static int getNoRepeat(int a[]){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        //int all=a.length;
        for(int i=0;i<a.length;i++){
            if(!hashMap.containsKey(a[i])){
                hashMap.put(a[i],1);
            }
        }
        return hashMap.size();
    }
}
