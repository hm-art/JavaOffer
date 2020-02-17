package o10_BackTracking;
import java.util.Scanner;
//13提：机器人运动范围
public class RangeOfRobots {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入行数 m：");
        int m=scanner.nextInt();
        System.out.println("请输入列数 n：");
        int n=scanner.nextInt();
        System.out.println("请输入坐标数位和最大值 k：");
        int k=scanner.nextInt();
        int a[][]=new int[m][n];
//        Int(a,m,n);
//        OutPut(a,m,n);
        System.out.println();
        System.out.println(Num(a,m,n,k));
    }
    public static int Num(int [][]a,int m,int n,int k){
        int result=0;
        if(n<=0||m<=0||k<0||a==null){
            System.out.println("输入错误");
            return -1;
        }
        int b[][]=Int(a,m,n);
        boolean flag[][]=new boolean[m][n];
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                flag[i][j]=true;
            }
        }
        result=digui(0,0,k,b,flag);
        return result;
    }

    private static int digui(int i, int j, int k, int[][] b,boolean flag[][]) {
        int sum=0;
        if(flag[i][j]==true&&i>=0&&j>=0&&i<b.length&&j<b[0].length&&b[i][j]<=k){
            flag[i][j]=false;
            sum+= 1 +digui(i+1,j,k,b,flag) +digui(i,j+1,k,b,flag);
        }
        return sum;
    }

    public static int[][] Int(int [][]a,int m,int n){//初始化矩阵
        //int b[][]=new int[m][n];
        if(m<=0||n<=0||a==null){
            System.out.println("行列不可以为0，数组不可以为空！");
            return null;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=AddXY(i,j);
            }
        }
        return a;
    }
    //计算横纵坐标数位和
    public static int AddXY(int i,int j){
        int sum=0;
        while(i/10!=0){
            sum+=i%10;
            i=i/10;
        }
        sum+=i%10;
        int sum1=0;
        while(j/10!=0){
            sum1+=j%10;
            j=j/10;
        }
        sum1+=j%10;
        return sum1+sum;
    }
    public static void OutPut(int [][]a,int m,int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
