package o8_FindandSort;

public class quickSort {
    public static void main(String[] args) {
        int a[]={5,3,6,1,2,9};
        quicksort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void swap(int a[],int i,int j){
        int remp=a[i];
        a[i]=a[j];
        a[j]=remp;
    }
    public static int partition(int a[],int start,int end){
        int p=a[start];
        int j=start;
        for(int i=start+1;i<=end;i++){//必须是<=end而不是end-1;若为end-1会少交换一次
            if(a[i]<p){
                swap(a,i,j+1);
                j++;
            }
        }
        //System.out.println(j+" "+start);
        swap(a,start,j);
        return j;
    }
    public static void quicksort(int []a,int start,int end){
        if(start>=end)
            return;
        int index=partition(a,start,end);
        quicksort(a,start,index-1);
        quicksort(a,index+1,end);

    }
}
