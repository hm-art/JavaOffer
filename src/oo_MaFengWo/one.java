//package oo_MaFengWo;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class one {
//    public static void main(String[] args) {
//        Stack s=new
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        int r=scanner.nextInt();
//        char c[] = s.toCharArray();
//        ArrayList<Character> arrayList = new ArrayList<>();
//        for (int i = 0; i < c.length; i++) {
//            if (c[i] == ',') {
//                arrayList.add(' ');
//            } else {
//                arrayList.add(c[i]);
//            }
//        }
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < arrayList.size(); i++) {
//            str.append(arrayList.get(i));
//        }
//        String s1 = str.toString();
//        int n[] = stringToInt(s1);
//        findPeak(n);
//    }
//    public static int[] stringToInt(String s){
//        String[] strings=new String[s.length()];
//        int i,k=0,count=0;
//        for(i=0;i<s.length();i++){
//            if(s.charAt(i)!=' '){
//                if(strings[k]==null) //如果是第一个计数的数字则直接赋值
//                    strings[k]=String.valueOf(s.charAt(i));
//                else //否则直接添加到其后面
//                    strings[k]=strings[k]+s.charAt(i);
//            }
//            else{ //如果是第一次出现的空格，则k+1，这一次空格（可能有多个连续空格）后面出现的数字存储到strings的下一个元素中
//                if(s.charAt(i-1)!=' ')
//                    k++;
//            }
//        }
//        for(i=0;i<s.length();i++){ //得到strings中存储了数字（不是null）的元素个数
//            if(strings[i]!=null)
//                count++;
//        }
//        int [] a=new int[count];
//        for(i=0;i<count;i++){ //将strings中存储了数字的元素赋值给a中的元素
//            a[i]=Integer.parseInt(strings[i]);
//        }
//        return a;
//    }
//    public static void findPeak(int[] A) {
//        // write your code here
//        if(A.length==0){
//            return;
//        }
//        int result=0;
//        for(int i=1;i<A.length-1;i++){
//            if(A[i]>A[i-1]&&A[i]>A[i+1]){
//                result=i;
//                System.out.println(result);
//            }
//        }
//    }
//}
