package o9_Array;


/**
 * 旋转数组中最小元素
 * 是 二分查找 的变形
 */
public class minNum {
    public static void main(String[] args) {
        int []a1={3,4,5,1,2};
        int []a2={1,1,1,0,1};
        int []a3={1,0,1,1,1};
        int []a4={1,2,3,4,5};
        FindMinNum(a1,a1.length);
        FindMinNum(a2,a2.length);
        FindMinNum(a3,a3.length);
        FindMinNum(a4,a4.length);
    }
    public static void FindMinNum(int []a,int length){
        if(a==null||a.length<=0)
            throw new RuntimeException("ERROR");
        int start=0;
        int end=a.length-1;
        int mid=start;
        if(a[start]<a[end])//数组是从小到大排好序的 1 2 3 4 5
            System.out.println("min: "+a[start]);
        else {
            while(a[start]>=a[end]){
                if(end-start==1) {
                    mid=end;
                    System.out.println("min: "+a[end]);
                    break;
                }
                mid=(start+end)/2;
                if(a[mid]==a[start]&&a[mid]==a[end]){
                    // 1 0 1 1 1     1 1 1 0 1 都可以看成0 1 1 1 1的旋转
                    int p=orderCount(a,start,end);
                    System.out.println("min: "+p);
                    break;
                }
                if(a[mid]>=a[start]){
                    start=mid;
                }else if(a[mid]<=a[end]){
                    end=mid;
                }
            }
        }

    }
    public static int orderCount(int []a,int index1,int index2){
        int result=a[index1];
        for(int i=index1+1;i<=index2;i++){
            if(a[i]<result){
                result=a[i];
            }
        }
        return result;
    }
}
