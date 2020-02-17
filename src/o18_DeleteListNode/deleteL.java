package o18_DeleteListNode;

public class deleteL {
    public static class List{
        int val;
        List next;
        public List(int value){
            val=value;
        }
    }
    public static void main(String[] args) {
//         List head=new List(1);
//         List a1=new List(2);
//         List a2=new List(3);
//         List a3=new List(4);
//         head.next=a1;
//         head.next.next=a2;
//         head.next.next.next=a3;
//         List de=head;//删除头
////         List de=a1;//删除中间任意一个
//         Print(head);
//         deleteList(head,de);
//         Print(head);

        List head1=new List(1);
        List de=head1;//只有头时删除头
        //删除头后无法将结点置空，只能输出提醒已经删掉了，链表空了，然后链表中的内容由jvm自动回收
        Print(head1);
        deleteList(head1,de);
        Print(head1);
    }

    private static void Print(List head) {
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }

    public static void deleteList(List head,List de){
        if(head==null||de==null){
            return;
        }
        //要删除的节点不是尾节点，整个链表不光只有头节点
        if(de.next!=null){
            de.val=de.next.val;
            de.next=de.next.next;
        }
        //链表只有头节点
        else if(de==head&&head.next==null){
            System.out.println("链表中只有头节点，且头节点就是要删除的节点，已经删除成功了");
        }
        //链表里有多个节点，删除尾节点
        else {
            List temp=head;
            while(head.next.val!=de.val){
                temp=temp.next;
            }
            temp.next=null;
        }
    }
}
