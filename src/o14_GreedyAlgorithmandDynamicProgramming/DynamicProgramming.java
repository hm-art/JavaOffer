package o14_GreedyAlgorithmandDynamicProgramming;
//动态规划解决剪绳子问题
public class DynamicProgramming {
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
        int procuct[]=new int[length+1];
        procuct[0]=0;
        procuct[1]=1;
        procuct[2]=2;
        procuct[3]=3;
        int max=0;
        for(int i=4;i<=length;i++){
            for(int j=1;j<=i/2;j++){
                int p1=procuct[j]*procuct[i-j];
                if(p1>max)
                    max=p1;
                procuct[i]=max;
            }

        }
        return procuct[length];
    }
}
