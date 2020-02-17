package oo_XiaomI;

import java.util.Scanner;

public class TWO {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();//件数
        int m[]=new int[n];//存件数的数组
        for(int i=0;i<n;i++){
            m[i]=scanner.nextInt();
        }
        int price=scanner.nextInt();
        mergesort(m,0,m.length-1);
        int biaoji=0;
        for(int i=0;i<n;i++){
            if(m[i]<=0){
                biaoji++;
            }
        }
        int temp=0;
        if(biaoji>0){
            int xin[]=new int[biaoji];
            for(int i=0;i<n;i++){
                if(m[i]>0){
                    xin[temp]=m[i];
                    temp++;
                }
            }
            System.out.println(max(xin,biaoji,price));
            return;
        }

        System.out.println(max(m,n,price));
    }
    public static void mergesort(int []a,int l,int r){
        if(l>=r)//递归到底了，就return
            return;
        int mid=(l+r)/2;
        mergesort(a,l,mid);
        mergesort(a,mid+1,r);
        merge(a,l,mid,r);//进行归并
    }
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
    public static int max(int m[],int n,int price){
        if(m==null||m.length==0)
            return 0;
        int maxCount=0;
        int shengyu=0;
        int dangqian=0;
        //int biaoji=0;
        for(int i=0;i<n;i++){
            if(m[i]>price)
                return -1;
        }
        for(int i=n-1;i>=0;i--){
            maxCount+=price/m[i];
            dangqian=price/m[i];
            shengyu=price-dangqian*m[i];
            price=shengyu;
        }
        if(maxCount==0)
            return -1;
        return maxCount;
    }
}
