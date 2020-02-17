package o43_TimesOfOne_FromOneToN;

//43.1~n整数中1出现的次数
public class TimesOfOne_FromOneToN {
    public static void main(String[] args) {
//        int n=5;
//        int n=10;
//        int n=55;
//        int n=99;
//        int n=0;
//        int n=1;
//        int n=10000;
       int n=21034;
        System.out.println(numberOfInt1(n));

    }
    public static int numberOfInt1(int n){
        if(n<=0){
            return 0;
        }
        int count=0;
        for(int i=1;i<=n;i*=10){
            int high=(n/(i*10));
            int low=(n%i);
            int cur=(n/i)%10;
            if(cur==0){
                count+=high*i;
            }else if(cur==1){
                count+=high*i+(low+1);
            }else{
                count+=(high+1)*i;
            }
        }
        return count;
    }
}
