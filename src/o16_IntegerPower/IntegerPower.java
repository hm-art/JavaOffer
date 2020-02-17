package o16_IntegerPower;

import java.math.BigDecimal;
import java.util.Scanner;

//数值得整数次方
public class IntegerPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            double base = scanner.nextDouble();
            int expoent = scanner.nextInt();
            System.out.println(Power(base, expoent));
        }
    }

    public static double Power(double base, int expoent) {
        BigDecimal data1 = new BigDecimal(base);
        BigDecimal data2 = new BigDecimal(0.0);
        //结果为0则表示相等，>0表示d大于d1,<0表示d小于d1
        if (data1.compareTo(data2) == 0 && expoent < 0) {
            System.out.println("基数为0且次方为负，无法计算");
            return 0.0;
        }
        if(data1.compareTo(data2) == 0 && expoent == 0){
            System.out.println("基数为0且次方为0，0的0次方无意义");
            return 0.0;
        }
        double result = 0.0;
        int temp = 0;
        if (expoent < 0) {
            temp = -expoent;
            //result=PowerWithExpoent(base,temp);
            result = GoodPowerWithExpoent(base, temp);

        } else if (expoent >= 0) {
            //result=PowerWithExpoent(base,expoent);
            result = GoodPowerWithExpoent(base, expoent);
        }
        if (expoent < 0)
            result = 1.0 / result;
        return result;

    }

    //优化前的
    private static double PowerWithExpoent(double base, int expoent) {
        double result = 1.0;
        for (int i = 1; i <= expoent; i++) {
            result *= base;
        }
        return result;
    }

    //优化后的
    private static double GoodPowerWithExpoent(double base, int expoent) {
        //0x1就是最后一位肯定是1。偶数的二进制表示中最后一位肯定是0，如果是奇数那肯定是1，
        // 所以一个整数与0x1做按位与运算得到的结果是0或者1就可以判断出这个整数是偶数还是奇数。
        if (expoent == 0)
            return 1;
        if (expoent == 1)
            return base;
        double result = GoodPowerWithExpoent(base, expoent>>1);//右移=除2；3/2=1
        result *= result;
        if ((expoent & (0x1)) == 1)
            result *= base;
        return result;
    }
}