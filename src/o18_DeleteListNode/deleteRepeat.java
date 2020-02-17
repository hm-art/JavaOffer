package o18_DeleteListNode;
//删除链表内重复节点
//112334---24
//122344--13
//11--空了
//123454--无重复
public class deleteRepeat {
    public static class List{
        int val;
        List next=null;
        List(int val,List next){
            this.val=val;
            this.next=next;
        }
    }

    public static void main(String[] args) {
           //test1();
           //test2();
           //test3();
           test4();
    }
    public static void test1(){//测试用例
        List p4=new List(3,null);
        List p3=new List(2,p4);
        List p2=new List(2,p3);
        List p1=new List(1,p2);
        Test(p1);
    }
    public static void test2(){//p1->p2->p3->p4
        List p4=new List(3,null);
        List p3=new List(2,p4);
        List p2=new List(1,p3);
        List p1=new List(1,p2);
        Test(p1);
    }
    public static void test3(){//p1
        List p1=new List(1,null);
        Test(p1);
    }
    public static void test4(){//p1->p2->p3->p4->p5->p6
        List p6=new List(4,null);
        List p5=new List(3,p6);
        List p4=new List(3,p5);
        List p3=new List(2,p4);
        List p2=new List(1,p3);
        List p1=new List(1,p2);
        Test(p1);
    }
    public static void Test(List head){
        System.out.println("原始链表");
        List curNode=head;
        while(curNode!=null){
            System.out.print(curNode.val+" ");
            curNode=curNode.next;
        }
        System.out.println();
        System.out.println("------------------");
        List phead=DeleteRepaet(head);
        System.out.println("去重后");
        while(phead!=null){
            System.out.print(phead.val+" ");
            phead=phead.next;
        }
        System.out.println();
        System.out.println("------------------");
    }
    public static List DeleteRepaet(List head){
       if(head==null||head.next==null){
           //说明链表中只有1个或0个结点,就不需要删除了
           return head;
       }
       List preNode=null;
       List curNode=head;
       //做一个遍历
        while(curNode!=null){
            boolean needDelete=false;//默认为false，不重复，不需要删除
            if(curNode.next!=null){
                if(curNode!=null&&(curNode.val==curNode.next.val)){
                //当前节点的值等于下一结点的值，则重复了
                needDelete=true;
                }
            }
            if(!needDelete){//needDelete为false代表没有重复
                preNode=curNode;
                curNode=curNode.next;
            }else{//needDelete为true代表有重复，需要删除
                int val=curNode.val;
                List toBeDE=curNode;
                while(curNode!=null&&toBeDE.val==val){
                    //找到第一组挨着的重复后，再继续向下找，知道找到一个与当前节点值不同的
                    //例：123334 则第一3为curNode，一直往后找到4
                    toBeDE=toBeDE.next;
                }
                if(preNode==null){//说明头节点和头节点得下一个节点重复了
                    head=toBeDE;//那么首节点就是要删除的节点
                }else{//说明头节点和头节点得下一个节点没重复
                    preNode.next=toBeDE;//例：123334 2连4
                }
                curNode=toBeDE;////例：1233445第一遍去重后让curNode为第一个4，在进行第二轮去重
            }
        }
        return head;
    }
}
