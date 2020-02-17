package o31_StackPushPop;

import java.util.Stack;

//30.栈的压入弹出序列
public class StackPushPop {
    public static void main(String[] args) {
         test1();
         test2();
         test3();
         test4();
         test5();
    }
    public static boolean stackPushPopOrder(int pusho[],int popo[]){
        if(pusho==null||popo==null)
            return false;
        if(pusho.length!= popo.length)
            return false;
        if(pusho.length==popo.length&&pusho.length==0)
            return false;
        Stack<Integer> stack=new Stack<Integer>();
        int popIndex=0;
        for(int pushindex=0;pushindex<pusho.length;pushindex++){
            stack.push(pusho[pushindex]);
            while(!stack.isEmpty()&&stack.peek()==popo[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
    public static void test1(){//f
        int pusho[]=null;
        int popo[]={1};
        System.out.println(stackPushPopOrder(pusho,popo));
    }
    public static void test2(){//t
        int pusho[]={1};
        int popo[]={1};
        System.out.println(stackPushPopOrder(pusho,popo));
    }
    public static void test3(){//t
        int pusho[]={1,2,3,4,5};
        int popo[]={4,5,3,2,1};
        System.out.println(stackPushPopOrder(pusho,popo));
    }
    public static void test4(){//f
        int pusho[]={1,2,3,4,5};
        int popo[]={4,3,5,1,2};
        System.out.println(stackPushPopOrder(pusho,popo));
    }
    public static void test5(){//f
        int pusho[]={1,2};
        int popo[]={1};
        System.out.println(stackPushPopOrder(pusho,popo));
    }

}
