package o29_ClockwisePrintMatrix;
//29.顺时针打印矩阵
//   (start,start)    1     (start,y)
//        4                    2
//    (x,start)       3     (x,y)
//start从0开始，每次+1
//x=row-1-start
//y=clo-1-start
public class ClockwisePrintMatrix {
    public static void main(String[] args) {
             //test1();
             //test2();
             //test3();
             //test4();
             //test5();
             test6();
             test7();
    }
    //row 行 col 列
    public static void PrintMatrix(int n[][], int row, int col) {
        System.out.println("------顺时针打印矩阵------");
        if(n==null||col<=0||row<=0){
            System.out.println("矩阵不存在");
            return;
        }
        int start=0;
        int x=row-1-start;
        int y=col-1-start;
        while(start*2<row&&start*2<col){
            for(int i=start;i<=y;i++){
                int number=n[start][i];
                printNumber(number);
            }
            //System.out.println();
            if(start<x){
                for(int i=start+1;i<=x;i++){
                    int number=n[i][y];
                    printNumber(number);
                }
                //System.out.println();
            }
            if(start<x&&start<y){
                for(int i=y-1;i>=start;i--){
                    int number=n[x][i];
                    printNumber(number);
                }
                //System.out.println();
            }
            if(start+1<x&&start<y){
                for(int i=x-1;i>=start+1;i--){
                    int number=n[i][start];
                    printNumber(number);
                }
                //System.out.println();
            }
            start++;
            x--;
            y--;
        }

    }
    public static void printNumber(int number){
        System.out.print(number+" ");
    }

    public static void creatMatrix(int n[][]){//初始化矩阵
        int m=0;
        for(int i=0;i<n.length;i++){
            for(int j=0;j<n[0].length;j++){
                n[i][j]=m;
                m++;
            }
        }
    }
    public static void printMatrix(int n[][]){//正常打印
        System.out.println("----正常打印矩阵----");
        for(int i=0;i<n.length;i++){
            for(int j=0;j<n[0].length;j++){
                System.out.print(n[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void test1() {
        int n[][] = null;
        if(n!=null)
        PrintMatrix(n, n.length, n[0].length);
        System.out.println("矩阵不存在");
    }
    public static void test2(){
        int n[][]=new int[1][3];
        creatMatrix(n);
        printMatrix(n);
        PrintMatrix(n, n.length, n[0].length);
    }
    public static void test3(){
        int n[][]=new int[2][2];
        creatMatrix(n);
        printMatrix(n);
        PrintMatrix(n, n.length, n[0].length);
    }
    public static void test4(){
        int n[][]=new int[3][2];
        creatMatrix(n);
        printMatrix(n);
        PrintMatrix(n, n.length, n[0].length);
    }
    public static void test5(){
        int n[][]=new int[5][5];
        creatMatrix(n);
        printMatrix(n);
        PrintMatrix(n, n.length, n[0].length);
    }
    public static void test6(){
        int n[][]=new int[1][1];
        creatMatrix(n);
        printMatrix(n);
        PrintMatrix(n, n.length, n[0].length);
    }
    public static void test7(){
        int n[][]=new int[3][1];
        creatMatrix(n);
        printMatrix(n);
        PrintMatrix(n, n.length, n[0].length);
    }
}
