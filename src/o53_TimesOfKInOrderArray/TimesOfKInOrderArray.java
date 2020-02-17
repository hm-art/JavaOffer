package o53_TimesOfKInOrderArray;
//53.在排序数组中查找数字
//一、查找某一数字重复的次数
//    用二分查找法找到该数字第一次出现的索引first
//    用二分查找法找到该数字第一次出现的索引last
//    出现次数times=last-first+1
public class TimesOfKInOrderArray {
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }
    public static int getTimes(int n[],int k){
        if(n==null||n.length<=0)
            return -1;
        int times=0;
        if(n!=null&&n.length>0){
            int first=getFirst(n,0,n.length-1,k);
            int last=getLast(n,0,n.length-1,k);
            if(first>-1&&last>-1)
             times=last-first+1;
        }
        return times;
    }
    public static int getFirst(int n[],int start,int end,int k){
        if(n==null||n.length==0)
            return -1;
        int l=start;
        int r=end;
        if(l>r)
            return -1;
        int midIndex=l+(r-l)/2;
        int midData=n[midIndex];
        if(midData==k){
            if(midIndex==0||(midIndex>0&&n[midIndex-1]!=k)){
                //已经遍历到了第0个或者是未到0但它的前一个不等于K，那么当前得index就是第一个k出现的位置
                return midIndex;
            }
            else{
                r=midIndex-1;
            }
        }
        else if(midData>k){
            r=midIndex-1;
        }else{
            l=midIndex+1;
        }
        return getFirst(n,l,r,k);
    }
    public static int getLast(int n[],int start,int end,int k){
        if(n==null||n.length==0)
            return -1;
        int l=start;
        int r=end;
        if(l>r)
            return -1;
        int midIndex=l+(r-l)/2;
        int midData=n[midIndex];
        if(midData==k){
            //注意一下if中的判断条件
            if(midIndex==n.length-1||(midIndex<n.length-1&&n[midIndex+1]!=k)){
                //已经遍历到了最后一额或者是未到最后一个但它的后一个不等于K，那么当前得index就是最后一个k出现的位置
                return midIndex;
            }
            else{
                l=midIndex+1;
            }
        }
        else if(midData>k){
            r=midIndex-1;
        }else{
            l=midIndex+1;
        }
        return getLast(n,l,r,k);
    }
    //测试
    public static void test1(){
        int n[]=null;
        System.out.println(getTimes(n,1));
    }
    public static void test2(){
        int n[]={1,2,2,3,3,3,4,4};
        //System.out.println(getTimes(n,3));//3
        //System.out.println(getTimes(n,5));
        //System.out.println(getTimes(n,1));
        System.out.println(getTimes(n,4));
    }
    public static void test3(){
        int n[]={1};
        System.out.println(getTimes(n,1));
        System.out.println(getTimes(n,0));
    }

}

