package oo_CSP;
import java.util.Scanner;
public class c201903_1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int arr[]=new int[n];
        int max,min;
        double mid=0.000;
        //BigDecimal m ;
        for(int i=0;i<n;i++){
           arr[i]=scanner.nextInt();
        }
        if(judgeOrder(arr)==true){//升序
            max=arr[n-1];
            min=arr[0];
            //mid=(max+min)>>1;
        }else{
            max=arr[0];
            min=arr[n-1];
        }
        if(n<=0)
            return;
        else if(n%2==0){
            //m=new BigDecimal((arr[n/2]+arr[(n/2)-1])/2);
            mid=(double) (arr[n/2]+arr[(n/2)-1])/2;
        }else if(n%2!=0){
            mid=(arr[(n-1)/2]);
            //m=new BigDecimal((arr[(n-1)/2]);
        }
        if((mid-(int)mid)==0.000){
            System.out.print(max+" "+(int)mid+" "+min);
            return;
        }else{
            System.out.print(max+" ");
            System.out.printf("%.1f",mid);
            System.out.print(" "+min);
            return;
        }
        //System.out.println(m);
        //double mid1 = m.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        //System.out.print(max+" "+mid1+" "+min);

    }
    public static boolean judgeOrder(int arr[]){
        if(arr==null||arr.length==0){
            throw new RuntimeException();
        }
        if(arr.length<=1){//
            return true;//升序
        }
        else if(arr[0]>arr[arr.length-1]){
            return false;//降序
        }else {
            return true;//升序
        }
    }
}
