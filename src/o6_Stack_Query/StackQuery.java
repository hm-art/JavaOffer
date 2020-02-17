package o6_Stack_Query;

import java.util.Stack;

public class StackQuery {
    public static class MyStack<T>{
        private Stack<T> stack1=new Stack();
        private Stack<T> stack2=new Stack();//是一个临时的栈

        public void appendTail(T t){//从队列尾部插入
            stack1.push(t);//boolean
        }
        public T deleteHead(){//从队列头部删除
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){//必须是循环的
                    //System.out.println("删除头部节点 ");
                    stack2.push(stack1.pop());
                }if(stack1.isEmpty()){
                    System.out.println("ERROR");
                }
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        MyStack<Character> myStack=new MyStack<Character>();
        myStack.appendTail('a');
        myStack.appendTail('b');
        myStack.appendTail('c');
        char s=myStack.deleteHead();
        System.out.println(s);
        char s2=myStack.deleteHead();
        System.out.println(s2);
        char s3=myStack.deleteHead();
        System.out.println(s3);
        char s4=myStack.deleteHead();
        System.out.println(s4);
    }

}
