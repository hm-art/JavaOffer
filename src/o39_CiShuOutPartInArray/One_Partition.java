package o39_CiShuOutPartInArray;
//39.数组中数字出现次数超过数组长度一半的数字
//   常规想法是排序后找第n/2个，但这样时间复杂度为O(nlogn),时间复杂度高了
//   所以想以下几种方式
//方法一：Partition() ------ O(n)
//       分析可知，给数组排序后，中位数就是我们要找的数字
//       需要如下几个函数：
//       1.用于判断数组长度是否有效CheckInvalidArray()
//       2.检查所得得中位数find在数组中出现次数是否超过了数字长度的一半
//         若没超过，别忘了修改flag为true，因为这种情况下输入数组的长度也无效
//       3.快速排序
//方法二：没做
public class One_Partition {
    public static void main(String[] args) {
        //int n[]={1,2,3,2,2,2,5,4,2};//2
        int n[]={1,2};//0
        //int n[]={1};//1
        //int n[]=null;
        System.out.println(MoreThanHalfNum(n));

    }
    static boolean flag=false;//f代表输入数组长度有效
    //用于判断数组长度是否有效
    public static boolean CheckInvalidArray(int n[]){
        flag=false;
        if(n==null||n.length==0)//或得顺序不可以错
            flag=true;//T代表输入数组长度无效
        return flag;
    }
    //检查所得得中位数find在数组中出现次数是否超过了数字长度的一半
    //若没超过，别忘了修改flag为true，因为这种情况下输入数组的长度也无效
    public static boolean CheckMoreThanHalf(int n[],int length,int find){
        int time=0;
        boolean moreThanHalf=true;//t表示find在数组中出现次数超过了数字长度的一半
        for(int i=0;i<length;i++){
            if(n[i]==find)
                time++;
        }
        if(time*2<=length){//time*2必须>length
            flag=true;
            moreThanHalf=false;//f表示find在数组中出现次数没超过了数字长度的一半
        }
        return moreThanHalf;
    }
    //找出数组中位数，其中排序用到的是快排
    public static int MoreThanHalfNum(int n[]){
        if(CheckInvalidArray(n)){//输入数组无效
             return 0;
        }
        int length=n.length;
        int start=0;
        int end=length-1;
        int mid=length>>2;//length/2
        //index是被选中数字得下标
        int index=Partiton(n,start,end);
        if(index==-1){
            return n[0];
        }
        while(index!=mid){
            if(index>mid){
                end=index-1;
                index=Partiton(n,start,end);
            }
            else{
                start=index+1;
                index=Partiton(n,start,end);
            }
        }
        int find=n[mid];
        if(CheckMoreThanHalf(n,length,find))
            return find;
        return 0;
    }
    //快排的核心
    private static int Partiton(int[] n, int start, int end) {
        int i=start;
        int j=end;
        if(i>=j)
            return -1;
        boolean biaoji=true;//代表的是 右->左
        while(i!=j){
            if(n[i]>n[j]){
                swap(n,i,j);
                biaoji=(biaoji==true)?false:true;
            }
            if(biaoji)
                j--;
            else{
                i++;
            }
        }
        return j;
    }

    private static void swap(int n[],int i,int j) {
        int temp=n[i];
        n[i]=n[j];
        n[j]=temp;
    }
}
