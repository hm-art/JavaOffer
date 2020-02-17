package o20_judgeInterger;
//20.判断是否是表示数值得字符串（重点：分析规律）
public class NumericStrings {
    public static void main(String[] args) {
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }
    public static void test(String testName,char []str,boolean excpect){
        System.out.println(testName+":");
        if(isNumber(str)==excpect){
            System.out.println("测试通过");
        }
        else{
            System.out.println("失败，有错");
        }
    }
    public static boolean isNumber(char []str){
        int index[]=new int[1];
        //这个index必须用数组，
        // 不能是单纯int整形，若为单纯int整形，index的值不会随着赋值而改变，一直是0
        index[0]=0;
        if(str==null||str.length==0){
            return false;
        }

        boolean isnumber;//最后的返回值，若是true则证明是表述数值的字符串
        //判断A部分（可是是有符号整数，也可以是无符号整数）
        //为true证明A部分存在且符合要求，false则代表A部分不存在，这是个无整数部分的小数，也符合要求
        isnumber=isInterger(str,index);
        //判断b部分,小数点以后的部分,判断是否是无符号整数
        if(index[0]<str.length&&str[index[0]]=='.'){
            index[0]++;
            //二者有一个为true就是true，也就是两种情况
            //1。 1.234
            //2。  .234
            //这两种情况都可以
            isnumber=isUnsignInterger(str,index)||isnumber;
        }
        //判断C部分
        if(index[0]<str.length&&(str[index[0]]=='e'||str[index[0]]=='E')){
            index[0]++;
            isnumber=isInterger(str,index)&&isnumber;
            //为true则证明e/E之后符合规则是无符号整数或有符号整数
        }
        if(isnumber==true&&index[0]==str.length){
            //所有情况都判断完并符合条件，并且遍历到数组尾了，就结束了，返回真
            return true;
        }
        return false;
    }
//    判断第一位是否是+ -号
//    如果有符号，则index+1 判断之后的整数是否为无符号整数
    //如果没符号，直接从当前index判断是否是0-9之间的整数
    private static boolean isInterger(char[] str, int index[]) {
        if(index[0]<str.length&&(str[index[0]]=='+'||str[index[0]]=='-')){
            index[0]++;
        }
        return isUnsignInterger(str,index);
    }
    //判断是否是0-9之间的整数
    private static boolean isUnsignInterger(char[] str, int index[]) {
        int start=index[0];
        while(index[0]<str.length&&(str[index[0]]-'0'>=0&&str[index[0]]-'0'<=9)){
            //判断是否是0-9之间的数
            index[0]++;
        }
        //不是则跳出循环。判断下一位是否是小数点
        if(index[0]>start)//证明A部分存在且符合要求
            return true;
        else
            return false;//证明只有小数部分，则进入判断B的部分
    }
    //测试用例
    public static void test2(){
        char c[]={};
        test("test2",c,false);
    }
    public static void test3(){
        char c[]=null;
        test("test3",c,false);
    }
    public static void test4(){
        String s="3e1.2";
        char c[]=s.toCharArray();
        test("test4",c,false);
    }
    public static void test5(){
        String s="e3";
        char c[]=s.toCharArray();
        test("test5",c,false);
    }
    public static void test6(){
        String s="1.2e3";
        char c[]=s.toCharArray();
        test("test6",c,true);
    }
    public static void test7(){
        String s="-.2e3";
        char c[]=s.toCharArray();
        test("test7",c,true);
    }
    public static void test8(){
        String s="5e2";
        char c[]=s.toCharArray();
        test("test8",c,true);
    }
}
