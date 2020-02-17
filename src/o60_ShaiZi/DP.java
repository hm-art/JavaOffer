package o60_ShaiZi;
//方法二：队列中的最大值
// f(k,s):代表有k个骰子，点数和为s的情况数 f[][]=new int[k+1][6*k+1]
// 初始化时f(1,s)均=1，（6种情况的f都=1）
// 往下开始计算2到n个骰子，逐个增加，n个骰子可能的和是n~6n
// 分析可得公式:
// 0<n<=6n
// f(n,s)=f(n-1,s-1)+f(n-1,s-2)+f(n-1,s-3)+f(n-1,s-4)+f(n-1,s-5)+f(n-1,s-6)

public class DP {
    public static void main(String[] args) {
        DP dp=new DP();
        dp.printP(1);
        dp.printP(2);
        dp.printP(3);
    }
    public void printP(int n){
        if(n<1)
            return;
        // f(k,s):代表有k个骰子，点数和为s的情况数 f[][]=new int[k+1][6*k+1]
        int f[][]=new int[n+1][6*n+1];
        // 初始化时f(1,s)均=1，（6种情况的f都=1）
        for(int i=1;i<=6;i++){
            f[1][i]=1;
        }
        // 往下开始计算2到n个骰子，逐个增加，
        for(int i=2;i<=n;i++){
            //n个骰子可能的和是n~6n
            for(int sum=i;sum<=6*i;sum++){//操作的是i，不是n
                // f(n,s)=f(n-1,s-1)+f(n-1,s-2)+f(n-1,s-3)+f(n-1,s-4)+f(n-1,s-5)+f(n-1,s-6)
                for(int j=1;j<=6&&j<sum;j++){
                    //????不明白这部为什么
                    f[i][sum]+=f[i-1][sum-j];
                }
            }
        }
        int total=(int)Math.pow(6,n);
        for(int sum=n;sum<=6*n;sum++){
            System.out.println(n+"个骰子，和是"+sum+"的概率为"+f[n][sum]+"/"+total);
        }
    }
}
