package o30_MinOfStack;

import java.util.Stack;
//
//30.包含min函数的栈
//   得到数据栈中剩余元素的最小元素
//    peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
public class MinOfStack {
    Stack<Integer> stack_data=new Stack<Integer>();//数据栈
    Stack<Integer> stack_min=new Stack<Integer>();//辅助栈
    public static void main(String[] args) {
        MinOfStack stack=new MinOfStack();
        stack.push(3);
        System.out.println(stack.min()==3);
        stack.push(4);
        System.out.println(stack.min()==3);
        stack.push(2);
        System.out.println(stack.min()==2);
        stack.push(3);
        System.out.println(stack.min()==2);
        stack.pop();
        System.out.println(stack.min()==2);
        stack.pop();
        System.out.println(stack.min()==3);
        stack.push(0);
        System.out.println(stack.min()==0);
    }
    public void push(int node){
        stack_data.push(node);
        if(stack_min.isEmpty()||stack_min.peek()>node){
            stack_min.push(node);
        }else{
            stack_min.push(stack_min.peek());
        }
    }
    public void pop(){
        if(!stack_data.isEmpty()){
            stack_data.pop();
            stack_min.pop();
        }
    }
    public int min(){
        return stack_min.peek();
    }
}
