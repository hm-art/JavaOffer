package o4_reverseList;

import java.util.Stack;

public class UseStack {
    public static class listnode{
        int val;
        listnode next;
    }

    public static void main(String[] args) {
        listnode l1;
        l1=new listnode();
        listnode ll=l1;
        l1.val=1;
        int n=5;
        while(n-->1){
            l1.next=new listnode();
            l1=l1.next;
            l1.val=n;
        }
        UseStack h1=new UseStack();
        h1.ruzhan(ll);

    }
    public static void ruzhan(listnode l){
        Stack s=new Stack();
        while(l!=null){
            s.push(l.val);
            l=l.next;
        }
        while (!s.empty()){
            System.out.println(s.pop());


        }
    }
}
