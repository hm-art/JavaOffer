package o10_BackTracking;
//矩阵中的路径
public class backTracking {
    public static void main(String[] args) {
        char b[][]=new char[][]{
                  {'a','b','t','g'},
                  {'c','f','c','s'},
                  {'g','d','e','h'}
                  };
        char a[]={'t','c','e','h'};
        //char a[]={'a','b','t','g','s','c','f','c','g','d','e'};
        System.out.println(findLine(a,b,b.length,b[0].length));
    }
    public static void defArray(boolean a[][]){//初始化标记数组 标记是否走过
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                a[i][j]=false;//没走过
            }
        }
    }
    public static boolean findLine(char a[],char b[][],int row,int col){
        boolean result=false;
        if(row<1||col<1||a==null||b==null)
        {
            System.out.println("输入错误");
            return result;
        }
        boolean flag[][]=new boolean[b.length][b[0].length];
        int sum=0;
        defArray(flag);
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                if(a[0]==b[i][j]){
                    //flag[i][j]=true;
                    //System.out.println(i+" "+j);
                    result=digui(i,j,a,b,flag,sum);
                    if(result==true){
                        return result;
                    }
                }
            }
        }
        return result;
    }
    private static boolean digui(int i, int j, char[] a, char[][] b, boolean[][] flag,int sum) {
        System.out.println(i+" "+j);
        if(i<0||j<0||i>b.length-1||j>b[0].length-1||flag[i][j]==true){
            //同与操作类似，||表示短路或，当运算符左边的值为true时，右边的表达式不会进行运算
            return false;
        }
        //System.out.println(flag[i][j]);
        if(a[sum]==b[i][j]){
            flag[i][j]=true;
            //System.out.println(sum);
            //System.out.println(sum+" "+b[i][j]);
            if(sum==a.length-1){
                return true;//找到了
            }
            //System.out.println(i+" "+j);
            sum+=1;
            //上 左 下 右
            return (digui(i-1,j,a,b,flag,sum)||
                    digui(i,j-1,a,b,flag,sum)||
                    digui(i+1,j,a,b,flag,sum)||
                    digui(i,j+1,a,b,flag,sum));
        }
        return false;
    }

}
