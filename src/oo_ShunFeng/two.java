package oo_ShunFeng;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class two {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        //getMax(arr,n);
        getMax(arr);
    }
//    public static void getMax(int a[],int n){
//        int []temp=new int[n];
//        temp[0]=1;
//        int max=1;
//        List<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
//        int index=-1;
//        ArrayList<Integer> arrayList=new ArrayList<Integer>();
//        arrayList.add(a[0]);
//        list.add(arrayList);
//        for(int i=1;i<n;i++){
//            index=-1;
//            arrayList=new ArrayList<Integer>();
//            for(int j=0;j<i;j++){
//                if(a[i]>a[j]){
//                    if(temp[j]>temp[i]){
//                        temp[i]=temp[j];
//                        index=j;
//                    }
//                }
//            }
//                ++temp[i];
//                if(index>-1){
//                    arrayList.addAll(list.get(index));
//                }
//                arrayList.add(a[i]);
//                list.add(arrayList);
//                if(temp[i]>max){
//                    max=temp[i];
//                }
//
//        }
//        System.out.println(max);
//    }
    public static void getMax(int a[]){
        TreeSet<Integer> set=new TreeSet<Integer>();
        for(int i:a){
            Integer ceil=set.ceiling(i);
            if(ceil!=null){
                set.remove(ceil);
            }
            set.add(i);
        }
        System.out.println(set.size());
    }
}
