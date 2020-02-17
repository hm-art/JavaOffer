package oo_BiLiBiLI;

import java.util.Scanner;

public class TEO {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int count=0;
        int a[]=new int[n];
        for(int i=0;i<n;i++){
           a[i]=i+1;
        }
        for(int i=0;i<n;i++){
            int sum=a[i];
            for(int j=i+1;j<n;j++){
                sum+=a[j];
            }
        }

    }
}
