package o14_GreedyAlgorithmandDynamicProgramming;
//贪心算法解决剪绳子问题
public class GreedyAlgorithm {
    public static void main(String[] args) {
        int length=12;
        System.out.println(MaxCheng(length));
    }
    private static int MaxCheng(int length) {
        if(length==0){
            System.out.println("输入错误");
            return 0;
        }
        if(length==1){
            return 0;
        }
        if(length==2){
            return 1;
        }
        if(length==3){
            return 2;
        }
        int max=1;
        int max1=1;
        if(length>=4){
            int timesOf3=length/3;
            if(length-timesOf3*3==1){
                timesOf3-=1;
            }

            int timesOf2=(length-timesOf3*3)/2;
            for(int i=1;i<=timesOf2;i++){
                max=max*2;
            }

            for(int j=0;j<timesOf3;j++){
                max1=max1*3;
            }
        }
        return max*max1;
    }
}
