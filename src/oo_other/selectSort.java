package oo_other;
//选择排序
public class selectSort {
    public static void main(String[] args) {
        int n[]={3,1,2,5,4,6};
        selectsort(n);
        for(int i=0;i<n.length;i++){
            System.out.println(n[i]);
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
