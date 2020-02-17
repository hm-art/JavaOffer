package oo_ZiXue.InnerOuter;

class Outer{
    private String str ="外部类中的字符串";
    //**************************
    //定义一个内部类
    class Inner{
        private String inStr= "内部类中的字符串";
        //定义一个普通方法
        public void print(){
            //调用外部类的str属性
            System.out.println(str);
        }
    }
    //**************************
    //在外部类中定义一个方法，该方法负责产生内部类对象并调用print()方法
    public void fun(){
        //内部类对象
        Inner in = new Inner();
        //内部类对象提供的print
        in.print();
    }
}
public class Test{
    public static void main(String[] args)
    {
        Integer num1 = 100;
        int num2 = 100;
        Long num3 = 200l;
        System.out.println(num1 + num2);  //200
        System.out.println(num3 == (num1 + num2));  //true
        System.out.println(num3.equals(num1 + num2));  //false
    }
}
