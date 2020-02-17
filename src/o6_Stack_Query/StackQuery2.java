package o6_Stack_Query;

import java.util.Stack;

public class StackQuery2 {
    public static class MyStack<T>{
        private Stack<T> stack1=new Stack();
        private Stack<T> stack2=new Stack();//是一个临时的栈

        public void appendTail(T t){//从队列尾部插入
            stack1.push(t);//boolean
        }
        public void deleteHead(){
            if(stack1.isEmpty()){
                System.out.println("无元素");
            }else{
                if(stack2.isEmpty()){
                    while(!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
            }
            while (!stack2.isEmpty()){
                System.out.println("删除了队列头节点"+stack2.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyStack<Character> myStack=new MyStack<Character>();
        myStack.appendTail('a');
        myStack.appendTail('b');
        myStack.appendTail('c');
        myStack.deleteHead();
    }
}
