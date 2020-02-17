package oo_VIPKID;


import java.util.ArrayList;
import java.util.Scanner;

public class ONE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //System.out.println(s);
        char c[] = s.toCharArray();
        //System.out.println(c);
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ',') {
                arrayList.add(' ');
            } else {
                arrayList.add(c[i]);
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            //System.out.print(arrayList.get(i));
            str.append(arrayList.get(i));
        }
        String s1 = str.toString();
        int n[] = stringToInt(s1);
        mergesort(n, 0, n.length - 1);
        int left[] = new int[1];
        int right[] = new int[1];
        System.out.println(find(n, left, right));
    }
    public static void mergesort(int []a,int l,int r){
        if(l>=r)//递归到底了，就return
            return;
        int mid=(l+r)/2;
        mergesort(a,l,mid);
        mergesort(a,mid+1,r);
        merge(a,l,mid,r);//进行归并
    }
    public static int[] stringToInt(String s){
              // String s="-1  2 4   5 -2 ";

        String[] strings=new String[s.length()];
        int i,k=0,count=0;
        for(i=0;i<s.length();i++){
//如果是数字则将其记录到strings数组中

            if(s.charAt(i)!=' '){

                if(strings[k]==null) //如果是第一个计数的数字则直接赋值

                    strings[k]=String.valueOf(s.charAt(i));

                else //否则直接添加到其后面

                    strings[k]=strings[k]+s.charAt(i);

            }

            else{ //如果是第一次出现的空格，则k+1，这一次空格（可能有多个连续空格）后面出现的数字存储到strings的下一个元素中
                if(s.charAt(i-1)!=' ')
                    k++;
            }
        }

        for(i=0;i<s.length();i++){ //得到strings中存储了数字（不是null）的元素个数

            if(strings[i]!=null)

                count++;

        }

        int[] a=new int[count];

        for(i=0;i<count;i++){ //将strings中存储了数字的元素赋值给a中的元素
            a[i]=Integer.parseInt(strings[i]);
        }
       return a;
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
    public static int find(int []arr,int left[],int right[]){
        if(arr==null||arr.length<=0)
            return -1;
        left[0]=0;
        int count=0;
        right[0]=arr.length-1;
        while(left[0]<right[0]){
            if(arr[left[0]]+arr[right[0]]==0){
                count++;
                right[0]--;
            }
            else if(arr[left[0]]+arr[right[0]]>0){
                right[0]--;
            }else{
                left[0]++;
            }
        }
        return count;
    }
}
