package o42_LianXuZiShuZu_MaxSum;
//42.连续子数组的最大和
//   解法一：举例分析数组的规律，然后写代码如下O(n)
//   解法二：动态规划 和解法1得思路是一样的
public class O_n {
    public static void main(String[] args) {
//        int n[]=null;
//        int n[]={};
//        int n[]={1,-2,3,10,-4,7,2,-5};//18
//        int n[]={2};
        int n[]={-1};
        System.out.println(MaxSum(n));
    }
    public static int MaxSum(int []n){
        boolean flag=false;//若返回值为0，判断是输入出错输出0，还是返回值就是0
        if(n==null||n.length==0){
            flag=true;//输入出错
            return 0;
        }
        flag=false;
        int curSum=n[0];
        int maxSum=n[0];
        for(int i=1;i<n.length;i++){
            if(curSum<0)
                curSum=n[i];
            else
                curSum+=n[i];
            if(curSum>maxSum)
                maxSum=curSum;
        }
        return maxSum;
    }
}
