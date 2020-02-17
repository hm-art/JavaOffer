package o40_MinKNum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//40.最小的K个数
//   方法一：同39思路，没做 O(N)
//   方法二：设计一个容量为k得容器  O(NlogK)
//           容器中已有得未达到k个，则往里存
//           达到了k个之后，就用现在待插入的值和容器中最大值进行比较
//           小于最大值则替换掉当前最大值，大于最大值则继续比较下一个
//           适合处理海量数据
//           Java中内置优先队列，就是用最小堆实现的，将其Comparator.reverseOrder()就是最大堆
//           PriorityQueue<Integer>  maxheap=new PriorityQueue<>(Comparator.reverseOrder());
public class Second_FangFa {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
    //建立一容器，容器中存最小的K个数(题中三部用这一个函数实现了)
    public static ArrayList<Integer> BaoCunMinKNumber(int []input,int k){
        ArrayList<Integer> arrayList=new ArrayList<>();
        if(input==null||input.length==0||k>input.length||k==0){
            return null;
        }
        PriorityQueue<Integer>  maxheap=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i:input){
            maxheap.offer(i);
            if(maxheap.size()>k){//大于k则删掉最大的元素
                maxheap.poll();//
            }
        }
        arrayList.addAll(maxheap);//是addAll()而不是add()
        return arrayList;
    }
    public static void test1(){
        int input[]=null;
        int k=4;
        if(BaoCunMinKNumber(input,k)==null){
            System.out.println("输入错误");
            return;
        }
        System.out.println(BaoCunMinKNumber(input,k));
    }
    public static void test2(){
        int input[]={1,2,3};
        int k=0;
        if(BaoCunMinKNumber(input,k)==null){
            System.out.println("输入错误");
            return;
        }
        System.out.println(BaoCunMinKNumber(input,k));
    }
    public static void test3(){
        int input[]={1,0,7,5,2};
        int k=10;
        if(BaoCunMinKNumber(input,k)==null){
            System.out.println("输入错误");
            return;
        }
        System.out.println(BaoCunMinKNumber(input,k));
    }
    public static void test4(){
        int input[]={1,0,7,5,2};
        int k=2;
        if(BaoCunMinKNumber(input,k)==null){
            System.out.println("输入错误");
            return;
        }
        System.out.println(BaoCunMinKNumber(input,k));
    }
    public static void test5(){
        int input[]={1,0,7,5,2};
        int k=5;
        if(BaoCunMinKNumber(input,k)==null){
            System.out.println("输入错误");
            return;
        }
        System.out.println(BaoCunMinKNumber(input,k));
    }
}
