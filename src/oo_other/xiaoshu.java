package oo_other;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

//四舍五入保留几位小数
public class xiaoshu {
    double d=111231.5584;
    /**
     * 五舍六入
     */
    public void m1() {
        BigDecimal bg = new BigDecimal(d);
        double f1 = bg.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }
    /**
     * 五舍六入
     */
    public void m2() {
        DecimalFormat df = new DecimalFormat("#.000");
        System.out.println(df.format(d));
    }
    /**
     * 四舍五入
     */
    public void m3() {
        System.out.println(String.format("%.3f", d));
    }
    //五舍六入
    public void m4() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(3);
        System.out.println(nf.format(d));
    }
    public static void main(String[] args) {
        xiaoshu retainTwoDecimal = new xiaoshu();
        retainTwoDecimal.m1();
        retainTwoDecimal.m2();
        retainTwoDecimal.m3();
        retainTwoDecimal.m4();
    }
}
