package oo_other;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Test.Inner a=new Test.Inner();
        a.method();
        Test.Inner2.method();

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str=str.replace(" ","");
        String []news = str.split(",");
        int [] arr = new int[news.length];
        for(int i=0;i<news.length;i++){
            arr[i]=Integer.parseInt(news[i]);
        }
    }
}
