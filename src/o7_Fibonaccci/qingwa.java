package o7_Fibonaccci;

/**
 * 1 2 3 5 8 13 21 34
 */
public class qingwa {
    public static void main(String[] args) {
        System.out.println(qingwatiao1(4));
        System.out.println(qingwatiao(10));

    }
    public static long qingwatiao(int n){
        if(n<=0)
            return 0;
        else if(n==1)
            return 1;
        else if(n==2)
            return 2;
        else
            return qingwatiao(n-1)+qingwatiao(n-2);
    }
    public static long qingwatiao1(int n){
        if(n<=0)
            return 0;
        else if(n==1)
            return 1;
        else if(n==2)
            return 2;
        long pre=2;
        long prepre=1;
        long current=2;
        for(int i=3;i<=n;i++){
            current=pre+prepre;
            prepre=pre;
            pre=current;
        }
        return current;
    }
}
