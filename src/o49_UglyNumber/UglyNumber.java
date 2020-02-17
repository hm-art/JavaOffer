package o49_UglyNumber;
//49.丑数
//方法一：如下所示的两个方法isUgly() ,count()
//时间效率太低，由于是从小到大挨个计算的，所以即使不是丑数的数，也参与了计算
//因为每次都从1开始重新计算了一遍
//方法二：用空间换时间,参与计算的只有丑数
public class UglyNumber {
    public static void main(String[] args) {
//        System.out.println(count(1));//1
//        System.out.println(count(2));//2
//        System.out.println(count(0));//0
//        System.out.println(count(3));//3
//        System.out.println(count(8));//9
//        System.out.println(count(1500));//859963392
        System.out.println(getUgly(1));
        System.out.println(getUgly(2));
        System.out.println(getUgly(0));
        System.out.println(getUgly(3));
        System.out.println(getUgly(8));
        System.out.println(getUgly(1500));
    }
    //方法一：如下所示的两个方法isUgly() ,count()
    //时间效率太低，由于是从小到大挨个计算的，所以即使不是丑数的数，也参与了计算
    public static boolean isUgly(int number){
        while(number%2==0)
            number/=2;
        while(number%3==0)
            number/=3;
        while(number%5==0)
            number/=5;
        return (number==1)?true:false;
        //是丑数则返回true，不是则返回false
    }
    public static int count(int range){//求第range个丑数
        if(range<=0)
            return 0;
        int choushugeshu=0;//找到的丑数个数
        int findchoushu=0;//找到的丑数
        while(choushugeshu<range){
            findchoushu++;
            if(isUgly(findchoushu))
                choushugeshu++;
        }
        return findchoushu;
    }
    //以下是方法二：
    public static int getUgly(int index){
        if(index<=0)
            return 0;
        int ugly[]=new int[index];
        int t2=0;
        int t3=0;
        int t5=0;
        ugly[0]=1;//第1个丑数是1
        for(int i=1;i<index;i++){
            int m2=ugly[t2]*2;
            int m3=ugly[t3]*3;
            int m5=ugly[t5]*5;
            ugly[i]=Math.min(Math.min(m3,m5),m2);
            if(ugly[i]==m2)
                t2++;
            if(ugly[i]==m3)
                t3++;
            if(ugly[i]==m5)
                t5++;
        }
        return ugly[ugly.length-1];
    }
}
