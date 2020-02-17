package oo_XieCheng;

public class one {
    public static int[] inverse(int a[],int m){
        int temp[]=new int[a.length];
        int min=0;
        int max=0;
        for(int i=0;i<a.length;i++){
            if(a[i]<=m){
               min++;
            }else{
                max++;
            }
        }
        int maxshuzu[]=new int[max];
        int j=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>m){
                maxshuzu[j]=a[i];
                j++;
            }
        }
        int minshuzu[]=new int[min];
        int k=0;
        for(int i=0;i<a.length;i++){
            if(a[i]<=m){
                minshuzu[k]=a[i];
                k++;
            }
        }
        int biaoji=0;
        for(int i=0;i<a.length;i++){
            if(i<min){
                temp[i]=minshuzu[i];
            }else{
                temp[i]=maxshuzu[biaoji];
                biaoji++;
            }
        }
        return temp;
    }
}
