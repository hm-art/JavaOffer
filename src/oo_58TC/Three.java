package oo_58TC;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int a[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=scanner.nextInt();
            }
        }
        int minr=minRoot(0,0,a);
        System.out.println(minr);
    }

    private static int minRoot(int i, int i1, int[][] a) {
        if((i==a.length-1)&&(i1==a[0].length-1)){
            return a[i][i1];
        }
        if(i>a.length-1||i1>a[0].length-1)
            return 9999999;
        int r=0;
        r=a[i][i1]+Math.min(minRoot(i+1,i1,a),minRoot(i,i1+1,a));
        return r;
    }

}
