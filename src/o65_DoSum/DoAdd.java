package o65_DoSum;
//65.不用加减乘除做加法
//   分为三部：做加法但不进位
//            记录进位
//            前两部的结果相加
//用位运算来代替这三部：
//                   那么第一步做加法不进位就变成了二进制的 异或
//                   例：5 101 17 10001  异或之后是10100
//                   第二步：进位 只有1加1会产生进位，所以可以想到每一位都做与运算，再向左移一位
//                   例：101 10001 与之后为 00001 向左移动一位为 00010
//                   第三步：将前两部结果相加 得10110 化成十进制正好是22
//每次循环将得到的进位值赋给b，如果b为0，代表无进位了，也就不用继续运算了
public class DoAdd {
    public static void main(String[] args) {
        System.out.println(Add(17,5));
    }
    public static int Add(int a,int b){
        while(b!=0){//每次循环将得到的进位值赋给b，如果b为0，代表无进位了，也就不用继续运算了
            int sum=a^b;
            //System.out.println(Integer.toBinaryString(sum));
            int carry=(a&b)<<1;
            //System.out.println(Integer.toBinaryString(carry));
            a=sum;
            b=carry;
        }
        return a;
    }
}
