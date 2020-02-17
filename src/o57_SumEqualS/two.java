package o57_SumEqualS;
//题二：
//定义一个small，一个big，small初始化为1，big初始化为2
//初始化一个cursum=0
//若small~big之间的序列和<sum,则big++,并cursum+big
//若small~big之间的序列和>sum,则cursum-small并small++
//若small~big之间的序列和=sum,则打印出来，并增加big
//循环条件是small<(1+sum)/2
public class two {
    public static void main(String[] args) {
        find(15);
    }
    public static void find(int sum){
        if(sum<3)
            return;
        int small=1;
        int big=2;
        int curSum=small+big;
        while(small<(1+sum)/2){
            if(curSum==sum){
                PrintResult(small,big);
            }
            while(curSum>sum&&small<(1+sum)/2){
                curSum-=small;
                small++;
                if(curSum==sum){
                    PrintResult(small,big);
                }
            }
            big++;
            curSum+=big;
        }
    }

    private static void PrintResult(int small, int big) {
        for(int i=small;i<=big;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
