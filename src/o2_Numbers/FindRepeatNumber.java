package o2_Numbers;

import java.util.Arrays;

public class FindRepeatNumber {
    //找出数组中任意一个重复的数字
    //方法1：先排序，相邻的两两比较，t:O(nlog(n))
//    public static void findR(int n[],int length,int r[]){
//        if(n==null||length==0){//鲁棒性
//            return;
//        }
//        Arrays.sort(n);//用的快排
//        int j=0;
//        for(int i=0;i<length-1;i++){
//            if(n[i]==n[i+1]){
//                r[j]=n[i];
//                j++;
//            }
//        }
//    }


    //方法2：t:o(n);s:o(1)
    public static void findR1(int []n,int length,int []r){
        if(n==null||length<0){
            return;
        }//鲁棒性
        int j=0;
        for(int i=0;i<length;i++){
            if(n[i]<0||n[i]>length-1){
                return;
            }
            while(n[i]!=i){
                if(n[i]==n[n[i]]){
                    r[j]=n[i];
                    System.out.println(r[j]);
                    //j++;//无这句，只能找到一组重复数组，有就可以找到全部重复数字
                    break;
                }
                swap(n,i,n[i]);

            }
        }
    }
    public static void swap(int n[],int p,int q){
        int temp=n[p];
        n[p]=n[q];
        n[q]=temp;
    }

    public static void main(String[] args) {
        int []n={1,2,4,2,4};
        int []r=new int[n.length];
        FindR2(n,n.length,r);
        System.out.println(Arrays.toString(r));
//        findR1(n,n.length,r);
//        System.out.println(Arrays.toString(r));
    }

    public static void FindR2(int []n,int length,int []r){
        if(n.length==0||n==null){
            return ;
        }
        int start=1;
        int end=length-1;
        while(end>=start){
            int mid=(start+end)/2;
            //System.out.println(mid);

            int co=count(n,n.length,start,mid);
            //System.out.println(co);
            if(end==start){
                if(co>1){
                    r[0]=start;
                    System.out.println(r[0]);
                    break;
                }else{
                    break;
                }
            }
            if(co>(end-start+1)){
                end=mid;
            }else{
                start=mid+1;
            }
        }
    }
    public static int count(int n[],int length,int s,int e){
        int c=0;
        if(n==null){

            return 0;
        }
        for(int i=0;i<length;i++){
            //System.out.println(1);
            System.out.println(s+" "+e+" "+n[i]);
            if(n[i]>=s&&n[i]<=e){
                //System.out.println(2);
                c+=1;
            }
        }
        return c;
    }

}
