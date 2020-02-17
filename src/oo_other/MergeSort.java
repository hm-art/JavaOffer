package oo_other;

/**
 * 分成好多个一半，再归并
 * 归并排序
 * t：nlog(n) 空间：还需要开一个临时数组
 * 因为利用了二分法所以log(n)
 */
public class MergeSort {
    public static void main(String[] args) {
        int []a={3,1,5,2,4,7,9};
        mergesort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    //递归使用归并排序,对[l..r]范围内的数组进行排序
    public static void mergesort(int []a,int l,int r){
        if(l>=r)//递归到底了，就return
            return;
        int mid=(l+r)/2;
        mergesort(a,l,mid);
        mergesort(a,mid+1,r);
        merge(a,l,mid,r);//进行归并
    }
    //将[l..mid]和[mid+1..r]两部分进行归并
    //利用一个临时数组和原数组空间大小一样
    //假设左右两部分都已经排好序，p1指向左部分得最左面，p2指向右部分得最左面
    //有一个指针p指向辅助数组得第0个(假设排成从小到大)
    //比较p1和p2所指向的值
    //若p1.val>p2.val  则l1.val=p2.val p2++ l1++
    //在这里我们设置成前闭(l)后闭(r)得空间
    private static void merge(int[] a, int l, int mid, int r) {
        int temp[]=new int[r-l+1];//因为是前闭(l)后闭(r)得空间，所以+1
        for(int i=l;i<=r;i++){
            temp[i-l]=a[i];//把原数组的值复制到辅助数组中
            //便于之后用temp进行遍历，将排好序的放入原来的a中
        }
        int i=l;//左部分得最左面
        int j=mid+1;//右部分得最左面
        //k表示在有序数组中下一个需要放的位置
        for(int k=l;k<=r;k++){
            //要考虑越界问题，有可能左半部分已经遍历完了，但右半部分还有，即i>mid
            //那么下一个k要放的就是右半部分中的下一个
            if(i>mid){
                a[k]=temp[j-l];
                j++;
            }else if(j>r){
                //同理，右半部分已经遍历完了，那k得下一个放的就是左半部分中的下一个
                a[k]=temp[i-l];
                i++;
            }
            else if(temp[i-l]<temp[j-l]){//-l是因为有l得偏移量
                a[k]=temp[i-l];
                i++;
            }else{
                a[k]=temp[j-l];
                j++;
            }
        }


    }
}
