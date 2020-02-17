package o66_ChengJiArray;
//66.构建乘积数组
//   这种方法时间复杂度和空间复杂度都是o(n)
public class o66_ChengJiArray {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        //b[]={120,60,40,30,24}
        int b[]=makeArray(a);
        for (int i:b) {
            System.out.println(i);
        }
    }
    public static int[] makeArray(int a[]){
        if(a==null||a.length<2)
            return null;
        int b[]=new int[a.length];
        b[0]=1;
        for(int i=1;i<a.length;i++)//计算c[i]=c[i-1]*a[i-1]
            b[i]=b[i-1]*a[i-1];
        int temp=1;
        for(int i=a.length-2;i>=0;i--){//计算d[i]=d[i+1]*a[i+1]
            temp*=a[i+1];
            b[i]*=temp;
        }
        return b;
    }
}

