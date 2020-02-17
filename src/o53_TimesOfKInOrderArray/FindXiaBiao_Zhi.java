package o53_TimesOfKInOrderArray;
//三、找到下标和该下标对应的值相等下标
public class FindXiaBiao_Zhi {
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        test5();
        test6();
        test7();
    }
    public static int find(int n[]){
        if(n==null||n.length==0)
            return -1;
        int l=0;
        int r=n.length-1;
        while(l<=r) {
            int mid = l + ((r - l) >> 1);
            if(mid==n[mid])
                return mid;
            else if(mid<n[mid])
                r=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }
    public static void test1(){
        int n[]=null;
        System.out.println(find(n));//-1
    }
    public static void test2(){
        int n[]={1,2,3,4,5};
        System.out.println(find(n));//-1
    }
    public static void test3(){
        int n[]={0};
        System.out.println(find(n));//0
    }
    public static void test4(){
        int n[]={2};
        System.out.println(find(n));//-1
    }
    public static void test5(){
        int n[]={-1,0,2,7};
        System.out.println(find(n));//2
    }
    public static void test6(){
        int n[]={0,2,3,4,5};
        System.out.println(find(n));//0
    }
    public static void test7(){
        int n[]={-1,0,1,2,4};
        System.out.println(find(n));//4
    }
}
