package o63_GuPiao;
//63.股票的最大利润
//   思路：扫描到第i个数字时，找到前面i-1个数中得最小值
//        时间复杂度是o(n)
public class MaxLiRun {
    public static void main(String[] args) {
        int price[]={9,11,8,5,7,12,16,14};
        System.out.println(MaxDiff(price));
    }
    public static int MaxDiff(int price[]){
        if(price==null||price.length<2)
            return -1;
        int curDiff=0;
        int maxDiff=0;
        int minPrice=price[0];
        for(int i=1;i<price.length;i++){
            if(price[i]<minPrice){
                minPrice=price[i];
            }
            curDiff=price[i]-minPrice;
            if(curDiff>maxDiff)
                maxDiff=curDiff;
        }
        return maxDiff;
    }
}
