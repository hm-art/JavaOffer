package o56_TimesOfNumInArray;
//56.数组中数字出现的次数
//题一：
//每个数字只出现一次或两次，一个数组中只有两个数只出现一次
//找到这两个数字
//想到把这个数组分成两组，每组包含一个只出现一次的数字
//用异或运算，^,任何数字异或他自己都=0
//先从头到位异或数组中每个数字，得到一个结果，计算这个结果得第n位是1
//然后根据数组中数字第n位是0还是1，将数组分为两组
//分完两组之后，每一组异或得结果就是我们要的结果
//三个计算
//        1.求出异或后第n位是1
//        2.求出数组中数字第n位是1/0的数字，将数组分成两部分
//        3.两部分分别异或
public class one {
    //num1和num2分别用来存放两个只出现一次的数
    //之所以是长度为1得数组，是因为最后要获得他们的值，所以不能用普通得int行
    public static void main(String[] args) {
        test1();
    }
    public static void times(int arr[],int num1[],int num2[] ){
        if(arr==null|| arr.length==0)
            return;
        int result=0;//异或后的结果
        for(int i=0;i<arr.length;i++)
            result^=arr[i];
        int indexOf1=0;//代表从右往左哪一位为1
        //1.求出异或后第indexOf1位是1
        while(((result&1)==0)&&indexOf1<=4*8){
            //int型为32位所以indexOf1<=4*8
            //(result&1)==0,代表该位为0，不是我们要的
            result>>=1;
            indexOf1++;
        }
        //先初始化一下，清空里面的内容
        num1[0]=0;
        num2[0]=0;
        for(int i=0;i<arr.length;i++){
            if(((arr[i]>>indexOf1)&1)==1){
                num1[0]^=arr[i];
            }else {
                num2[0]^=arr[i];
            }
        }
    }
    public static void test1(){
        //int n[]={1,2};
        int n[]={2,4,3,6,3,2,5,5};//4 6
        int num1[]=new int[1];
        int num2[]=new int[1];
        times(n,num1,num2);
        System.out.println(num1[0]+" "+num2[0]);
    }
}
