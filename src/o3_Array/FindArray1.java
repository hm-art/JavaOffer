package o3_Array;
//从右上角开始找
public class FindArray1 {
    public static void main(String[] args) {
        int [][]n={{1,2,3,4},
                   {2,6,7,8},
                   {7,10,11,12},
                   {13,14,15,16}
                  };
//        int num=2;
//        if(findNum(n,num)==false){
//            System.out.println("未找到");
//        }else if(findNum(n,num)==true){
//            System.out.println("找到了");
//        }
        System.out.println(findNum(n,1));
        System.out.println(findNum(n,9));
        System.out.println(findNum(n,20));
        System.out.println(findNum(n,10));
        System.out.println(findNum(n,16));
    }
    public static boolean findNum(int [][]n,int num){
        if(n.length<=0||n==null||n[0].length<1){//n[0].length<1:代表第一行没有列数
            return false;
        }
        int hang=n.length;//数组的行数
        int lie=n[0].length;//数组的列数
        int row=0;//查找时的起始行数
        int col=lie-1;//查找时起始的列数
        //int i=0;
        while (row>=0&&row<hang&&col>=0&&col<lie){//必须是>=,不能只有大于号
            if(n[row][col]==num){
                //i++;
                //System.out.println("在"+row+"行"+col+"列");
                return true;
                //break;
            }else if(n[row][col]>num){
                col--;
            }else if(n[row][col]<num){
                row++;
            }
        }
        return false;
    }
}

