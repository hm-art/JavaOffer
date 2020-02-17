package o41_MidNumOfDataString;

import java.util.Comparator;
import java.util.PriorityQueue;

//41.数据流中的中位数
//   注意：从数据流中读数是一个个读的
//   一个最大堆，一个最小堆，两个堆中数据数目之差不能超过1
//   最大堆得最大值(根)<最小堆得最小值(根)
//   两个堆中数据之和是偶数时，下一个数字就插入到小顶堆
//   插入之前判断，如果这个数小于大顶堆得最大值(根)
//   那么就把这个数先插入大顶堆，大顶堆中最大值拿出来插入小顶堆
//   两个堆中数据之和是奇数时，下一个数字就插入到大顶堆，需要判断的同理

public class MidNumOfDataString {
    PriorityQueue<Integer> maxheap=new PriorityQueue<>(11,Comparator.reverseOrder());
    PriorityQueue<Integer> minheap=new PriorityQueue<>();//小顶堆得默认容量是11

    public void insert(Integer num){
        if(((maxheap.size()+minheap.size())&1)==0){//括号一层都不能少！
            //==0为偶数，则存小顶堆
            if(!maxheap.isEmpty()&&maxheap.peek()>num){
                maxheap.offer(num);
                num=maxheap.poll();
            }
            minheap.offer(num);
        }else{//总数是奇数
            if(!minheap.isEmpty()&&minheap.peek()<num){
                minheap.offer(num);
                num=minheap.poll();
            }
            maxheap.offer(num);
        }
    }
    //获得中位数
    public Integer getMid(){
        if(maxheap.size()+minheap.size()==0){
            throw new RuntimeException();
        }
        int mid=0;//栈
        if(((maxheap.size()+minheap.size())&1)==0){
            int l1=maxheap.peek();
            int l2=minheap.peek();
            mid=(l1+l2)>>1;
        }else{
            mid=minheap.peek();
        }
        return mid;
    }
    //测试
    public void test(String testname,int except){
        if(testname!=null)
            System.out.printf("%s begin:",testname);
        if(except==getMid())
            System.out.println("pass");
        else{
            System.out.println("error");
        }
    }
    public static void main(String[] args) {
        MidNumOfDataString stream=new MidNumOfDataString();
        stream.insert(5);
        stream.test("test1",5);//5
        stream.insert(2);
        stream.test("test2",3);//2+5 /2=3
        stream.insert(3);
        stream.test("test3",3);//2 3 5--3
        stream.insert(4);
        stream.test("test4",3);//2 3 4 5--3+4 /2=3
        stream.insert(1);
        stream.test("test5",3);//1 2 3 4 5----3
    }
}
