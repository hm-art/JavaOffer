package o4_reverseList;

public class Recursion {
    public static class listnode {
        int val;
        listnode next;
    }

    public static void main(String[] args) {
        listnode l1;
        l1 = new listnode();
        listnode ll = l1;
        l1.val = 1;
        int n = 5;
        while (n-- > 1) {
            l1.next = new listnode();
            l1 = l1.next;
            l1.val = n;
        }
        Recursion h1 = new Recursion();

        h1.list1(ll);
    }

    public static void list1(listnode l) {
        if (l != null) {
            list1(l.next);
            System.out.println(l.val);
        }
    }
}
