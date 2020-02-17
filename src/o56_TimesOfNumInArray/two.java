package o56_TimesOfNumInArray;
//找到只出现一次
public class two {
    public static void main(String[] args) {
        int n[]={1,2,3,1,2,0,3,1,2,3};
        System.out.println(findOnce(n));//0
        int n1[]={2,1,-1,3,1,2,3,1,2,3};
        System.out.println(findOnce(n1));//-1
        int n2[]={2,1,3,1,2,3,100,1,2,3};
        System.out.println(findOnce(n2));//100
    }
    public static int findOnce(int arr[]){
        if(arr==null||arr.length==0)
            throw new RuntimeException("Input error");
        int pinlv[]=new int[32];
        for(int i=0;i<32;i++)
            pinlv[i]=0;
        //设置一个长度为32得数组，存二进制中每一位得和
        //从最低位开始计算每一位出现1得频率和，pinlv[31]存最低位
        //从二进制转成十进制，则是从左向右，从最高位开始，
        for(int i=0;i<arr.length;i++){
            int bitmask=1;
            for(int j=31;j>=0;j--){
                int bit=arr[i]&bitmask;
                if(bit!=0){
                    //代表arr[i]这一位得二进制是1
                    pinlv[j]++;
                }
                bitmask=bitmask<<1;
            }
        }
        //比如一个数组是4 4 4 5 6 6 6，经过上述操作后，pinlv[]中存的就是
        //00000000 00000000 00000000 00000731
        //以下函数是二进制转十进制
        int result=0;
        for(int i=0;i<32;i++){
            result=result<<1;
            result+=pinlv[i]%3;
        }
        return result;
    }
}
