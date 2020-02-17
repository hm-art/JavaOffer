package o7_Fibonaccci;
/**方法2：循环
 * 比递归快，效率高
 * 1 1 2 3 5 8 13 21 34
 */
public class fibonacci2 {
    public static void main(String[] args) {
        //System.out.println(countF(6));
    }

    public static long countF(int n){
        if(n<=0)
            return 0;
        else if(n==1||n==2)
            return 2;
        long pre=1;
        long prepre=1;
        long current=2;
        //else
            for(int i=3;i<=n;i++){
                current=pre+prepre;
                prepre=pre;
                pre=current;
            }
            return current;

    }
}
