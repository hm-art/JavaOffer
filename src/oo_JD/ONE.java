package oo_JD;
import java.util.*;

public class ONE {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int ship[]=new int[m*2];
        //List<Integer> list=new ArrayList<>();
        Queue<Integer> queue=new PriorityQueue<>();
        for(int i=0;i<2*m;i++){
            ship[i]=scanner.nextInt();
        }
        if(m>2*n)
            return;
        if(m==1){
            System.out.println(ship[0]);
            System.out.println(1);
        }else {
            selectsort(ship);
//        for(int i=0;i<ship.length;i++){
//            System.out.println(ship[i]);
//        }
            int all = 0;
            for (int i = 2 * m - 1; i >= 0; i--) {
                if (ship[i] == ship[i - 1]) {
                    all++;
                    //list.add(ship[i]);
                    queue.add(ship[i]);
                    i = i - 1;
                }
            }
//        for(int i=0;i<list.size();i++){
//            System.out.println(i);
//        }
            //int result[]=new int[queue.size()];
            // int i=0;
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
            System.out.println(all);
        }
    }
    public static void selectsort(int n[]){
        for(int i=0;i<n.length;i++){
            int minIndex=i;
            for(int j=i+1;j<n.length;j++){
                if(n[j]<n[minIndex]){
                    minIndex=j;
                }
            }
            swap(n,i,minIndex);
        }
    }

    private static void swap(int[] n, int i, int i1) {
        int temp=n[i];
        n[i]=n[i1];
        n[i1]=temp;
    }
}
