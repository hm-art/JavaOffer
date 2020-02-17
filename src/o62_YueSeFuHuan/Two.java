package o62_YueSeFuHuan;
//方法二：
//公式法：记住就行了
//f(1,m)=0   n=1
//f(n,m)=[f((n-1,m)+m)]%n

public class Two {
    public static void main(String[] args) {
        int n=5;
        int m=3;
        System.out.println(lastOne(n,m));
    }
    public static int lastOne(int n,int m){
        if(n<=0||m<=0)
            return -1;
        int f=0;
        for(int i=2;i<=n;i++){
            f=(f+m)%i;
        }
        return f;
    }
}
