package o61_ShunZiOfPuKe;

import java.util.Arrays;

public class ShunZi {
    public static void main(String[] args) {
        int arr[]={};
        int arr1[]=null;
        int arr2[]={1,3,5,0,6};//false
        int arr3[]={1,3,0,4,5};//true
        int arr4[]={3,1,3,0,2};//false;
        System.out.println(isShunZi(arr));
        System.out.println(isShunZi(arr1));
        System.out.println(isShunZi(arr2));
        System.out.println(isShunZi(arr3));
        System.out.println(isShunZi(arr4));

    }
    public static boolean isShunZi(int arr[]){
        if(arr==null|| arr.length<=0)
            return false;
        //1.将数组排序
        Arrays.sort(arr);
        //2.统计数组中0得个数
        int l=arr.length;
        int zero=0;
        for(int i=0;i<l;i++){
            if(arr[i]==0)
                zero++;
        }
        //3.判断数组是否连续
        //   有顺子则直接返回
        //   有相隔则判断相隔数字个数是否大于0得个数
        int small=zero;//把0空过去 例如 0 0 1 3 4 则small=2
        int big=small+1;
        int numofGap=0;//统计空格数
        while(big<l){
            if(arr[small]==arr[big])//有对子
                return false;
            numofGap+=arr[big]-arr[small]-1;
            small=big;
            big++;
        }
        return numofGap<=zero?true:false;
    }

}
