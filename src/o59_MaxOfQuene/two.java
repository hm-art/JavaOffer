package o59_MaxOfQuene;

import java.util.Deque;
import java.util.LinkedList;

public class two {
    public static void main(String[] args) {
        two t=new two();
        //{1}
        t.push_back(1);
        t.max();//1
        //{1,2}
        t.push_back(2);
        t.max();//2
        //{1,2,6}
        t.push_back(6);
        t.max();//6
        //{1,2,6,4}
        t.push_back(4);
        t.max();//6
        //{2,6,4}
        t.pop_front();
        t.max();//6
    }
    private Deque<Integer> dataqueue=new LinkedList<>();
    private Deque<Integer> maxqueue=new LinkedList<>();
    public void push_back(int num){
         dataqueue.offerLast(num);
         while(!maxqueue.isEmpty()&&maxqueue.getLast()<num){
             maxqueue.removeLast();
         }
         maxqueue.addLast(num);
    }
    public void pop_front(){
        if(dataqueue.isEmpty()) {
            throw new RuntimeException("队列空了");
        }
        int i=dataqueue.pollFirst();
        if(i==maxqueue.getFirst()){
            maxqueue.removeFirst();
        }
    }
    public void max(){
        if(maxqueue.isEmpty()){
            System.out.println("空了");
            return;
        }
        System.out.println(maxqueue.getFirst());
    }
}
