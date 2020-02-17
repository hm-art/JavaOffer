package o53_TimesOfKInOrderArray;
//53
//二、消失的数字
public class MeiLeDeNumber {
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        test4();
        test5();
        test6();
    }
    public static int findXiaoShiDeNumber(int n[]){
        if(n==null||n.length<=0)
            return -1;
        int start=0;
        int end=n.length-1;
        while(start<=end){
            int mid=start+((end-start)>>1);//(end-start)>>1必须括上
            if(mid==n[mid]){
            //如果中间的下标和数组的值一致，那么下一步要从数组的右半边找
                start=mid+1;
            }else if(mid!=n[mid]){
            //如果中间的下标和数组的值不一致，但mid-1和这个位置的值一致，说明mid这个位置就是缺失的位置
                if(mid==0||n[mid-1]==mid-1)
                    return mid;
            //若mid-1！=n[mid-1],则接着往左找
                end=mid-1;
            }
        }
        return -2;//各种无效输入都输出-2,包括这个数组中什么也不缺的情况
    }
    //测试
    public static void test1(){
        int n[]=null;
        System.out.println(findXiaoShiDeNumber(n));//-1
    }
    public static void test2(){
        int n[]={0};
        System.out.println(findXiaoShiDeNumber(n));//-2
    }
    public static void test3(){
        int n[]={1,2,3,4,5};
        System.out.println(findXiaoShiDeNumber(n));//0
    }
    public static void test4(){
        int n[]={0,1,2,4,5};
        System.out.println(findXiaoShiDeNumber(n));//3
    }
    public static void test5(){
        int n[]={0,1,2,3,5};
        System.out.println(findXiaoShiDeNumber(n));//4
    }
    public static void test6(){
        int n[]={0,1,2,3};
        System.out.println(findXiaoShiDeNumber(n));//-2
    }
}
