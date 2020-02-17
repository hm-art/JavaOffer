package o14_GreedyAlgorithmandDynamicProgramming;

import java.util.Scanner;

public class Excel {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true){
        String s=scanner.next();
        //System.out.println(s);
//        int m=Cow(s);
//        System.out.println(m);
        System.out.println(Cow(s));
        }
    }
    private static int Cow(String s) {
        char c[]=new char[s.length()+1];
        int a[]=new int[s.length()+1];
        int result=0;
        c=s.toCharArray();
        if(s.length()==1){
            result=c[0]-64;
            return result;
        }
        else if(s.length()>1){
            a[0]=c[0]-64;
            //a[1]=26+c[1]-64;
            for(int i=1;i<s.length();i++){
                a[i]=a[i-1]+26+c[i]-65;
            }
        }
        return a[s.length()-1];
   }
}
