package o17_PrintAtoBNum;
//大数相加
import java.util.Scanner;
import java.util.regex.Pattern;

public class MaxAddMax {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true){
            String c1=scanner.next();
            String c2=scanner.next();
            InitC(c1,c2);
        }
    }
    private static void InitC(String m, String n) {
        if(m.length()<=0||n.length()<=0){
            System.out.println("输入错误，长度必须均大于0");
            return;
        }
        Pattern pattern = Pattern.compile("^\\d+$");//正则判断输入的字符串中只能有0-9
        if(pattern.matcher(m).matches()==false||pattern.matcher(n).matches()==false){
            System.out.println("输入非法");
            return;
        }
        char c1[]=m.toCharArray();
        char c2[]=n.toCharArray();
        Add(c1,c2);

    }
    private static void Add(char[] c1, char[] c2) {//大数相加
        int length=c1.length>=c2.length?c1.length:c2.length;
        char newc2orc1[]=new char[length];
        char c[]=new char[length];
        int index=0;
        for(int i=0;i<c.length;i++){
            c[i]='0';
            if(c2.length<=c1.length){
                if(i<length-c2.length){
                    newc2orc1[i]='0';
                }else{
                    newc2orc1[i]=c2[index];
                    index++;
                }
            }
            else if(c1.length<c2.length){
                if(i<length-c1.length){
                    newc2orc1[i]='0';
                }else{
                    newc2orc1[i]=c1[index];
                    index++;
                }
            }
        }
        //PrintChar(newc2orc1);
        //PrintChar(c);;
        int flag=0;
        char c3[]=new char[length];
        if(c1.length>=c2.length){
            c3=c1;
        }else
            c3=c2;
        //PrintChar(c3);
        for(int i=length-1;i>=0;i--){
            int sum=c3[i]-'0'+newc2orc1[i]-'0'+flag;
            if(i==0){
                if(sum>=10){
                    c[0]=(char)('0'+sum-10);
                    System.out.print('1');
                    PrintChar(c);
                }
                else if(sum<10){
                    c[0]=(char)('0'+sum);
                    PrintChar(c);
                }
            }else{
                if(sum>=10){
                    flag=1;
                    c[i]=(char)('0'+sum-10);
                }else if(sum<10){
                    flag=0;
                    c[i]=(char)('0'+sum);
                }
            }
        }

    }

    public static void PrintChar(char c[]){
        for(int i=0;i<c.length;i++)
            System.out.print(c[i]);
        System.out.println();
    }
}
