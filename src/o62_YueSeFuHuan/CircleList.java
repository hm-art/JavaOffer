package o62_YueSeFuHuan;

import java.util.LinkedList;
import java.util.List;

//62.约瑟夫环
//   方法1：利用循环链表
//   循环的条件是链表里剩余元素个数>1,一旦<=1，就退出循环了
//   每次遍历m次，删除第m个
//   一旦删除的索引号p=list.size(),代表已经走到了链表尾部
//   就将p还原至0，即再次从头开始，这就变成了一个循环链表
//   时间复杂度O(mn)   空间复杂度O(n)

public class CircleList {
    public static void main(String[] args) {
        int n=5;
        int m=3;
        System.out.println(LastOne(n,m));
    }
    public static int LastOne(int n,int m){
        //n个人，每次都删除第m个
        if(n<=0||m<=0){
            return -1;
        }
        int p=0;//删除的那个人的索引号
        List<Integer> list=new LinkedList<>();
        //初始化每个人的索引号
        for(int i=0;i<n;i++){
            list.add(i);
        }
        while(list.size()>1){
            for(int i=0;i<m-1;i++){
                p++;
                if(p==list.size())
                    p=0;
            }
            list.remove(p);
            if(p==list.size())
                p=0;
        }
        return list.get(0);//最后剩的唯一的元素就是我们要的
    }
}
