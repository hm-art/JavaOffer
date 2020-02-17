package o58_ReverseString;
//题二：左旋字符串
//     思路：把字符串分成两部分，先左旋每一部分中的每个字母，再整体旋转
//          例：把abcdefg变成cdefgab
//              abcdefg 分成 ab 和 cdefg两部分，分别旋转后为 bagfedc
//              再整体旋转得 cdefgab
//    所以是调用三次reverseString()
public class two {
    public static void main(String[] args) {
        String str="abcdefg";
        leftReverse(str,0);
        leftReverse(str,10);
        leftReverse(str,2);
        leftReverse(str,1);
        leftReverse(str,7);
    }
    //将str左面的n个字符旋转到右面
    public static void leftReverse(String str,int n){
        if(str==null||str.length()==0){
            System.out.println("输入字符串为空/长度为0");
            return;
        }
        if(n<=0||n>str.length()){
            System.out.println("输入的n值不合法");
            return;
        }
        char[] all=str.toCharArray();
        System.out.println("原始字符串"+String.valueOf(all));
        char[] left=reverseString(all,0,n-1);
        System.out.println("反转左面部分后"+String.valueOf(left));
        char[] right=reverseString(left,n,str.length()-1);
        System.out.println("反转右面部分后"+String.valueOf(right));
        all=reverseString(right,0,str.length()-1);
        System.out.println("左旋后结果"+String.valueOf(all));

    }
    public static char[] reverseString(char ch[],int start,int end){
        //指定索引位置的值交换
        while(start<end){
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            start++;
            end--;
        }
        return ch;
    }
}
