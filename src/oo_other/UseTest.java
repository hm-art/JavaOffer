//package oo_other;
//
//public class UseTest {
//    public static void main(String[] args) {
//        //int i=41;
//        int j=200;
//        int i=1;
//        System.out.println(AddXY(i,j));
//    }
//    public static int AddXY(int i,int j){
//        int sum=0;
//
//        while(i/10!=0){
//            sum+=i%10;
//            i=i/10;
//        }
//        sum+=i%10;
//        int sum1=0;
//
//        while(j/10!=0){
//            sum1+=j%10;
//            j=j/10;
//        }
//        sum1+=j%10;
//        return sum1+sum;
//    }
//}
package oo_other;

public class UseTest {
    public static void main(String[] args) {
        int n=19;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(count(n));
        System.out.println(goodCount(n));
    }
    public static int goodCount(int i){
        int count=0;
        while(i!=0){
            count++;
            i=i&(i-1);
        }
        return count;
    }
    public static int count(int i){
        int num=0;
        int f=1;
        while(f!=0){
            //System.out.println(Integer.toBinaryString(i&f));
            if((i&f)!=0) {
                num++;
            }
            f=f<<1;
        }

        return num;
    }
}
