package oo_360;

import java.util.Scanner;

public class two_1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int arr[]=new int[m];
        int count=0;
        for(int i=0;i<m;i++){
            arr[i]=scanner.nextInt();
        }
        int hash[]=new int[n+1];
        for(int x=1;x<=n;x++){
            int bit=0;
            for(int k=0;k<Math.pow(2,m);k++){
                String str=String.format("%"+m+"s",Integer.toBinaryString(bit));
                char binary[]=str.toCharArray();
                for(int i=0;i<m;i++){
                    if(binary[i]==' '){
                        binary[i]='0';
                    }
                }
                int start=x;
                for(int j=0;j< binary.length;j++){
                    if(binary[j]=='0'){
                        start+=arr[j];
                    }
                    if(binary[j]=='1'){
                        start-=arr[j];
                    }
                    if(start>0&&start<=n){
                        hash[start]=1;
                    }                    bit++;
                }
            }
            for(int i=1;i<=n;i++){
                if(hash[i]==1)
                    count++;
            }
        }
        System.out.println(count);
    }
}
