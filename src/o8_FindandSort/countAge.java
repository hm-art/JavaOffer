package o8_FindandSort;

/**
 * 按员工年龄大小排序
 */
public class countAge {
    public static void main(String[] args) {
        int a[]={23,23,45,23,65,1,2,6,2,7,8,1,3,65};
        countA(a,a.length);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void countA(int []a,int length){
        if(a==null||length<=0)
            return;
        final int oldAges=99;
        int timesAge[]=new int[oldAges+1];
        for(int i=0;i<=oldAges;i++)//0-99岁
            timesAge[i]=0;
        for(int i=0;i<length;i++){
            if(a[i]<0||a[i]>oldAges)
                throw new RuntimeException("out of range");
            ++timesAge[a[i]];
        }
       int index=0;
        for(int i=0;i<=oldAges;i++){
            for(int j=0;j<timesAge[i];j++){
                a[index]=i;
                ++index;
            }
        }
    }
}
