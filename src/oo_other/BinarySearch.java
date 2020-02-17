package oo_other;

/**
 * 二分查找法
 * t:log(n)
 */
public class BinarySearch {
    public static void main(String[] args) {
        //System.out.println(-1);
        int t=3;
        int []a={1,2,3,5,6,7,9};//前提是数组有序
        System.out.println(binarySearch(a,a.length,t));//索引值
    }
    //[l...r]
    //注意各变量的含义
    public static int binarySearch(int []a,int n,int t){
        int l=0;
        int r=n-1;
        while(l<=r){//这种细小的边界判断要注意
            //int mid=(l+r)/2;
            int mid=l+(r-l)/2;//避免L+R过大产生溢出，所以用这样得减法解决溢出的问题

            //必须放while循环里
            if(a[mid]==t){
                return mid;
            }
            else if(a[mid]>t){//l..mid-1
                r=mid-1;
            }else{//mid+1..r
                l = mid + 1;
            }
        }
        return -1;
    }

}
