package oo_other;
//o(n^2)
public class quicksort {
    public static void main(String[] args) {
        int a[]={5,3,4,1,2,9};
        qsort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static int partition(int []a,int l,int r){
        int p=a[l];
        int j=l;
        for(int i=l+1;i<=r;i++){
            if(a[i]<p){
                int temp=a[j+1];
                a[j+1]=a[i];
                a[i]=temp;
                j++;
            }
        }
        int temp=a[j];
        a[j]=a[l];
        a[l]=temp;
        return j;
    }
    public static void qsort(int []a,int l,int r){
        if(l>=r){
            return;
        }else{
            int p=partition(a,l,r);
            qsort(a,l,p-1);
            qsort(a,p+1,r);
        }
    }
}
 