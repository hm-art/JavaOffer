package o7_Fibonaccci;

/**方法1：递归
 * 重复计算太多了，所以慢
 * 1 1 2 3 5 8 13 21 34
 * 青蛙跳台阶本质也是斐波那契数列
 */
public class fibonacci {
    public static void main(String[] args) {
        System.out.println(F(4));
    }

    public static long F(int n){
        //System.out.println(n);
        if(n<=0)
            return 0;
        else if(n==1)
            return 1;
        return F(n-1)+F(n-2);
    }
}
