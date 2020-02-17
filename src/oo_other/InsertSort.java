package oo_other;
//插入排序
public class InsertSort {
    public static void main(String[] args) {
        int n[]={3,1,2,5,4,6};
        insertSort(n);
        for(int i=0;i<n.length;i++){
            System.out.println(n[i]);
        }
    }
    public static void insertSort(int n[]){
        for(int i=1;i<n.length;i++){
            for(int j=i;j>0;j--){
                if(n[j]<n[j-1])
                    swap(n,j,j-1);
                else
                    break;
            }
        }
    }
    private static void swap(int[] n, int i, int i1) {
        int temp=n[i];
        n[i]=n[i1];
        n[i1]=temp;
    }
}
