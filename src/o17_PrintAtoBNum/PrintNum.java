package o17_PrintAtoBNum;
import java.util.Scanner;
//打印从1到n最大的n位数
//要考虑到大数
public class PrintNum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true){
            int n=scanner.nextInt();
            PrintOneToMax(n);
        }
    }
    //用字符串
    public static void PrintOneToMax(int n){
        if(n<=0){//鲁棒性!!!!!
            System.out.println("输入必须大于0");
            return;
        }
        char c[]=new char[n];
        for (int i=0;i<c.length;i++) {
            c[i]='0';
        }
        //c[n]='\0';//最后一位是结束符！！！！
        while(JudgeN(c)==false){//不是第0位的进位，则打印输出
            PrintOneToN(c);
        }
    }

    private static void PrintOneToN(char[] c) {
        boolean flag0=true;
        for(int i=0;i<c.length;i++){
            if(flag0==true&&c[i]!='0'){
                //char[]数组在某一位上没有值时会自动补0
                flag0=false;
            }
            if(flag0==false){//这一位不是0，就会打印
                System.out.print(c[i]);
            }
        }
        System.out.println();
    }
    private static boolean JudgeN(char[] c) {
        boolean flag=false;
        int length=c.length;
        for(int i=length-1;i>=0;i--) {
            //int sum=0;
            int sum = c[i] - '0';
            //if(i==length-1)
                sum++;
            if(sum>=10){
                if(i==0){
                    flag=true;
                }else{
                    c[i]=(char)(sum-10+'0');
                }
            }
            else if(sum<10){
                c[i]=(char)(sum+'0');
                break;
            }
        }
        return flag;
    }
}
