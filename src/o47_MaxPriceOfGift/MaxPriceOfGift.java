package o47_MaxPriceOfGift;
//47. 礼物的最大价值
//     每次只能向右或向下移动一格，直到右下角，算出经过的路径之和的最大值
//     应用动态规划解决递归效率低的问题
//     逆着考虑，从右下角（终点）开始找，每次都往左或往上找一个
//     所以依照题意，从左上角开始找


public class MaxPriceOfGift {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
    public static int MaxPrice(int values[][]){
        if(values==null||values.length<=0||values[0].length<=0){
            return 0;
        }
        int maxvalues[][]=new int[values.length][values[0].length];
        int row=values.length;
        int lie=values[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<lie;j++){
                int up=0;
                int left=0;
                if(i>0){
                    up=maxvalues[i-1][j];
                }
                if(j>0){
                    left=maxvalues[i][j-1];
                }
                maxvalues[i][j]=Math.max(up,left)+values[i][j];
            }
        }
        return maxvalues[values.length-1][values[0].length-1];
    }
    public static void test1(){
        int n[][]={{1}};
        System.out.println(MaxPrice(n));//1
    }
    public static void test2(){
        int n[][]={{1,2,3,4}};//10
        System.out.println(MaxPrice(n));//
    }
    public static void test3(){
        int n[][]={{1},
                   {2},
                   {3},
                   {4}};
        System.out.println(MaxPrice(n));//10
    }
    public static void test4(){
        int n[][]={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(MaxPrice(n));//29
    }
    public static void test5(){
        int n[][]={{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(MaxPrice(n));//53
    }
    public static void test6(){
        int n[][]=null;
        System.out.println(MaxPrice(n));//0
    }
}
