package oo_LiuLiShuo;
import java.util.Arrays;
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        two m= new two();
        int a[]=new int[100];
        int b[]=new int[100];
        String sa=in.nextLine();//输入一行字符串，转换成数组
        String sb=in.nextLine();
        m.turnStringToInt(sa,a);
        m.turnStringToInt(sb,b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(m.minStep(a,b));
    }
    public void turnStringToInt(String sa,int a[]){//把字符串转换成数组
        int j=0;
        int flag=0;
        for(int i=0;i<sa.length();i++){
            if(sa.charAt(i)==' '||sa.charAt(i)=='\n'){
                //System.out.println(sa.substring(flag,i));
                a[j]=Integer.parseInt(sa.substring(flag,i));
                j++;
                flag=i+1;
            }
        }
        a[j]=Integer.parseInt(sa.substring(flag,sa.length()));
    }
    public int minStep(int in[],int out[]){
        int res=0;
        int step[]=new int[2401];
        for(int i=0;i<in.length;i++){
            for(int j=in[i];j<out[i];j++){
                step[j]+=1;
            }
        }
        //System.out.println(Arrays.toString(step));
        for(int i=0;i<step.length;i++){
            if(res<step[i]){
                res=step[i];
            }
        }
        return res;
    }
}
//900 940 950 1100
//910 1200 1120 1130
