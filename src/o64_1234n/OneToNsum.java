package o64_1234n;
//解法一：递归实现但不用if语句做的累加
//用逻辑与代替if判断，逻辑与的特点是如果前面的条件不符合将不会判断下面的
//解法二：公式展开，众所周知：这个公式是n(n+1)/2
//        展开就变成了(n^2+n)/2 由于不能使用乘除法 所以/换成>>1
public class OneToNsum {
    public static void main(String[] args) {
        System.out.println(getSum1(3));
        System.out.println(getSum2(3));
    }
    //解法一：递归实现但不用if语句做的累加
    public static int getSum1(int n){
        int sum=n;
        //用逻辑与代替if判断，逻辑与的特点是如果前面的条件不符合将不会判断下面的
        boolean flag=(n>1)&&((sum+=getSum1(n-1))>0);
//        等效于
//                if(n>1)
//                    sum+=getSum1(n-1);
        return sum;
    }
    public static int getSum2(int n){
        return ((int)Math.pow(n,2)+n)>>1;
    }
}
