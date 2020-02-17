package o23_EntranceOfRing;
//23.链表中环的入口（高频题）
//   有两个要点：
//   1.如歌判断环的存在->引申问题是如何判断环中有几个节点
//     定义两个指针，一个一次走两步，一个一次走一步，走的快的遇到了走的慢的
//     就说明存在环（必须同步走，两个一起走）
//
//   2.判断完环存在后如何找到他的入口
//     定义两个指针p1和p2，开始都指向头，在1中可求出环中有n个节点，
//     p1先走n步，二者再同步走，二者相遇的节点就是环的入口
//
//   最后考虑鲁棒性
public class EntranceofRing {
    public static class List{
        int val;
        List next;
        List(int val){
            this.val=val;
        }
    }

    public static void main(String[] args) {
           test1();//无
           test2();//无
           test3();//无
           test4();//1
           test5();//3
    }
    //判断链表中是否有环，有则返回任意一个环中的节点，没有则返回空
    public static List isRing(List head){
        if(head==null)//鲁棒性
            return null;
        List slow=head;
        List flast=head;
        while(slow!=null&&flast!=null){
            slow=slow.next;
            flast=flast.next;
            if(flast!=null){
                flast=flast.next;
            }
            if(flast==slow&&slow!=null){
                return slow;
            }
        }
        return null;
    }
    //找到环的入口结点
    public static int numberOfRing(List head){//计算环中节点个数
        List meetNode=isRing(head);
        if(meetNode==null){//说明没有环，返回-1
            return -1;
        }
        int count=1;
        List temp=meetNode.next;
        while(temp!=meetNode){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public static List FindEntrance(List head){//找到环的入口
        int bu=numberOfRing(head);
        if(bu==-1){//证明无环，则返回空
            return null;
        }
        List p1=head;
        List p2=head;
        for(int i=0;i<bu;i++){
            p1=p1.next;
        }
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;//return p1 p2都一样
    }
    //测试用例
    public static void test1(){//没有节点
        List head=null;
        if( FindEntrance(head)==null){
            System.out.println("无环，找不到入口");
        }else{
            List entrance=FindEntrance(head);
            System.out.println("入口值为" + entrance.val);
        }

    }
    public static void test2(){//只有一个节点
        List head=new List(1);
        head.next=null;
        if( FindEntrance(head)==null){
            System.out.println("无环，找不到入口");
        }else{
            List entrance=FindEntrance(head);
            System.out.println("入口值为" + entrance.val);
        }
    }
    public static void test3(){//有多个节点，但无环
        List l2=new List(3);
        List l1=new List(2);
        List head=new List(1);
        head.next=l1;
        l1.next=l2;
        l2.next=null;
        if( FindEntrance(head)==null){
            System.out.println("无环，找不到入口");
        }else{
            List entrance=FindEntrance(head);
            System.out.println("入口值为" + entrance.val);
        }
    }
    public static void test4(){//整个是一个环,入口值为1
        List l2=new List(3);
        List l1=new List(2);
        List head=new List(1);
        List l4=new List(4);
        head.next=l1;
        l1.next=l2;
        l2.next=l4;
        l4.next=head;
        if( FindEntrance(head)==null){
            System.out.println("无环，找不到入口");
        }else{
            List entrance=FindEntrance(head);
            System.out.println("入口值为" + entrance.val);
        }
    }
    public static void test5(){//有环，环是从中间开始的,入口值为3
        List l2=new List(3);
        List l1=new List(2);
        List head=new List(1);
        List l3=new List(4);
        List l4=new List(5);
        List l5=new List(6);
        head.next=l1;
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l2;
        if( FindEntrance(head)==null){
            System.out.println("无环，找不到入口");
        }else{
            List entrance=FindEntrance(head);
            System.out.println("入口值为" + entrance.val);
        }
    }
}
