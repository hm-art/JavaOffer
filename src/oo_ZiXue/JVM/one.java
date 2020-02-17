package oo_ZiXue.JVM;

public class one {
    public static void main(String[] args) {

//        String s1 = new StringBuilder("go").append("od").toString();
        String s3="good";
//        //System.out.println(s1.intern()==s3);
//        System.out.println(s1);
//        System.out.println(s1.intern());
//        System.out.println(s1.intern() == s1);
//        String s2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(s2.intern() == s2);
        System.out.println(Math.round(11.4));//11
        System.out.println(Math.round(11.5));//12
        System.out.println(Math.round(-11.4));//11
        System.out.println(-Math.round(11.5));//11
        System.out.println(Math.round(-11.6));//11
        System.out.println(System.identityHashCode(s3));
    }
}
