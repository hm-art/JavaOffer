package o46_NumTranToChar;
//46.把数字翻译为字符串
//   利用递归，从小问题计算得出大问题的答案，也就是从右到左翻译
public class NumTranToChar {
    public static void main(String[] args) {
        int n=0;
        System.out.println( getTransalteCount(n));//1
        int n1=1;
        System.out.println( getTransalteCount(n1));//1
        int n2=-1;
        System.out.println( getTransalteCount(n2));//0
        int n3=12258;
        System.out.println( getTransalteCount(n3));//5
        int n4=25;
        System.out.println( getTransalteCount(n4));//2
        int n5=58;
        System.out.println( getTransalteCount(n5));//1
    }
    public static int getTransalteCount(int n){
        if(n<0)
            return 0;
        return count(String.valueOf(n));
    }

    private static int count(String s) {
        //例：1 2 2 5 8
        //    0 1 2 3 4
        //    8所在的位置就是len-1，最后一位之后这一种翻译方式,所以count[length-1]=1;
        int length=s.length();
        int count[]=new int[length];
        count[length-1]=1;
        for(int i=length-2;i>=0;i--){
            int high=s.charAt(i)-'0'; //5
            int low=s.charAt(i+1)-'0';//8
            if(high*10+low<=25&&high*10+low>=10){
                if(i==length-2){
                    //例如12125 i=length-2就是5的位置
                    //    若用count[i]=count[i+1]+count[i+2]则i+2会下标溢出
                    //    而且后两位25满足high*10+low<=25&&high*10+low>=10
                    //    那25就一定有两种翻译方式
                    count[i]=2;//count[i]=count[i+1]+1;
                }else{
                    count[i]=count[i+1]+count[i+2];
                }
            }else{
                count[i]=count[i+1];
            }
        }
        return count[0];
    }
}

