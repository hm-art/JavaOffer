package o57_SumEqualS;
//题一：
//在一个递增排序数组中找一对和为S的
//注意，题中给出的前提是有序
//若有多对，则返回其中任意一对
//第一反应是o（n^2）面试的时候想到就说
//用两个指针分别指向头和尾 o(n)
// 若现在二者之和>s，则最后一个指针向前移动
public class one {
    public static void main(String[] args) {
        int n[]={1,2,3,14,15};
        int s=3;
        int left[]=new int[1];
        int right[]=new int[1];
        if(find(n,s,left,right)==true){
            System.out.println(n[left[0]]+"+"+n[right[0]]+"="+s);
        }else{
            System.out.println("输入错误/不存在符合条件的值");
        }
    }
    public static boolean find(int []arr,int s,int left[],int right[]){
        if(arr==null||arr.length<=0)
            return false;
        left[0]=0;
        right[0]=arr.length-1;
        while(left[0]<right[0]){
            if(arr[left[0]]+arr[right[0]]==s){

                return true;
            }
            else if(arr[left[0]]+arr[right[0]]>s){
                right[0]--;
            }else{
                left[0]++;
            }
        }
        return false;
    }
}
