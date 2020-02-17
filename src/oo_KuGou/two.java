package oo_KuGou;

import java.util.Scanner;
import java.util.Stack;

public class two {
    public static void main(String[] args) {
        //1+2)*3-4)*5-6)))
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String s1=convert(s);
        System.out.println(s1);
    }
    public static String convert(String param){
        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();
        char[] chars = param.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //操作符入右栈
            if(c == '+' || c=='-'||c=='*' ||c=='/'){
                rightStack.add(String.valueOf(c));
            }
            //遇到右括号，要把左栈的2个操作数pop出，连接右栈操作符，然后补齐左右括号
            else if(c == ')'){
                String left2 = leftStack.pop();
                String left1 = leftStack.pop();
                leftStack.add("("+left1+rightStack.pop()+left2+")");
            }
            //其余的是操作数，要注意2位数及以上的，要拼起来
            else{
                String num = c+"";
                while((i+1)<chars.length
                        &&Character.isDigit(chars[i+1])) {
                    num += c;
                    i++;
                }
                leftStack.add(num);
            }
        }
        //正常来说，遍历结束后，右栈都会留有一个操作符
        while(rightStack.size()>0){
            String left2 = leftStack.pop();
            String left1 = leftStack.pop();
            leftStack.add(left1+rightStack.pop()+left2);
        }
        //这里记得要按顺序pop出来，栈中越靠栈顶的，排位越往右
        String result = "";
        while(leftStack.size()>0){
            result = leftStack.pop()+result;
        }
        return result;
    }
}
