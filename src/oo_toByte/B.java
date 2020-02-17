//package oo_toByte;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class B {
//    public static void main(String[] args) {
//
//    }
//    public static String getRandom(int min, int max){
//        Random random = new Random();
//        int s=0;
//        if(min>max){
//            //biaoji:
//            s = random.nextInt(min) % (min - max + 1) + max+1;
//            if(s==max)
//              s=s+1;
//        }else {
//            s = random.nextInt(max) % (max - min + 1) + min;
//            if(s==min)
//                s=s+1;
//        }
//
//        return String.valueOf(s);
//    }
//}
//输入包含两个整数l和r
