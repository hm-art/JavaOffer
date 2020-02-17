package o44_XuLieHuaShuZi;
//44.数字序列中某一位的数字
//   1.是n位数，计算出n位数的序列化数字个数,一位数有10个，0-9,两位数,则返回9*10^(2-1)=90,两位数有90个 10-99
//   2.根据想要求出的第多少位位，和当前得到的包含该位的几位数位的数，得到想要的
//   3.返回某个数的第i位是什么 第0位是个位 第1位是十位
public class XuLieHuaShuZi {
    public static void main(String[] args) {
       new XuLieHuaShuZi().test("test1",0,0);
        new XuLieHuaShuZi().test("test2",1,1);
        new XuLieHuaShuZi().test("test3",9,9);
        new XuLieHuaShuZi().test("test4",10,1);
        new XuLieHuaShuZi().test("test5",11,0);
        new XuLieHuaShuZi().test("test6",189,9);
        new XuLieHuaShuZi().test("test7",190,1);
        new XuLieHuaShuZi().test("test8",1000,3);
        new XuLieHuaShuZi().test("test9",1001,7);
    }
    //计算出
    public static int seqOfNum(int index){
        //index是想要得到的位数
        if(index<0)
            return -1;
        int digit=1;
        while(true){
            int numbers=numOfRang(digit);
            if(numbers*digit>index){
                return digitAt(index,digit);
            }
            index-=numbers*digit;
            digit++;
        }
    }
    //锁定范围后，根据位数，就能求出包含index处那位数的数字，从中找到那位数
    //根据想要求出的第index位，和当前得到的包含该位的digit位的数，得到想要的
    private static int digitAt(int index, int digit) {
        //int yushu=index%digit;
        int dijige=index/digit+beginOfDigit(digit);
        return weishuofn(dijige,digit-1-index%digit);

    }

    private static int beginOfDigit(int digit) {
        if (digit==1) //一位数从0开始
            return 0;
        return (int)Math.pow(10,digit-1);
    }

    //返回某个数的第i位是什么 第0位是个位 第1位是十位
    private static int weishuofn(int dijige, int i) {
        int n= dijige/(int)(Math.pow(10,i)) %10;
        return n;
    }

    //若是n位数，计算出n位数的序列化数字个数,一位数有10个，0-9,两位数,则返回9*10^(2-1)=90,两位数有90个 10-99
    public static int numOfRang(int n){
        if(n==1)
            return 10;//一位数有10个，0-9
        else{
            return (int)(9*Math.pow(10,n-1));
            //比如是两位数,则返回9*10^(2-1)=90  两位数有90个 10-99
        }
    }
    //测试
    public void test(String testname,int input,int except){
        System.out.println(seqOfNum(input));
        if(seqOfNum(input)==except){
            System.out.println(testname+" passsed");
        }else{
            System.out.println(testname+" error");
        }
    }
}
