package oo_niuke;
//余数是要的
//第一次235/15=15。。10 第二次 15/15=1...0 第三次1/15=0.。。1 结束
//10（即A）为个位 0为十位 1为百位
//所以结果为哦10A
public class TenTo15 {
    public static void main(String[] args) {
        TenTo15 tenTo15=new TenTo15();
        int a=235;
        tenTo15.change(a);
    }
    public static void change(int a){
        if(a==0){
            return;
        }
        int x=a%15;
        int m=a/15;
        change(m);
        if(x<10)
            System.out.print(x);
        else{
            switch (x){
                case 10:
                    System.out.print('A');
                    break;
                case 11:
                    System.out.print('B');
                    break;
                case 12:
                    System.out.print('C');
                    break;
                case 13:
                    System.out.print('D');
                    break;
                case 14:
                    System.out.print('E');
                    break;
            }
        }
    }
}
