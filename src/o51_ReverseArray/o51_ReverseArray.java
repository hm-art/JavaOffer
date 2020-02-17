package o51_ReverseArray;
//51.数组中的逆序对


public class o51_ReverseArray {
    public static int sum=0;
    public static void main(String[] args) {
//        int n[]={7,5,6,4};//1,1,2
//        count(n);
//        int n1[]={1,2};//0
//        count(n1);
//        int n3[]={1};//0
//        count(n3);
//        int n4[]={1,2,3,4};//0
//        count(n4);
        int n5[]={4,3,2,1};//6
        count(n5);

//        for(int i=0;i<n.length;i++)
//            System.out.print(n[i]+" ");
//        System.out.println();
        System.out.println(sum);
    }
      public static void count(int n[]){
          if(n==null||n.length==0)
              return;
          merge(n,0,n.length-1);
      }

    private static void merge(int[] n, int start, int end) {
          if(start>=end)
              return;
          int mid=(start+end)/2;
          merge(n,start,mid);
          merge(n,mid+1,end);
          hebing(n,start,end);//合并
    }

    private static void hebing(int[] n, int start, int end) {
          int count=0;//逆序对的个数
          int lright=(start+end)/2;//左子部分的右边界
          int rright=end;//右子部分得右边界
          int rleft=lright+1;//右子部分得左边界
          int lleft=start;
          int temp[]=new int[n.length];
          for(int i=0;i<n.length;i++){
              temp[i]=n[i];
          }
          for(int k=rright;k>=lleft;k--){
              if(lleft>lright){
                  n[k]=temp[rright];
                  rright--;
              }else if(rleft>rright){
                  n[k]=temp[lright];
                  lright--;
              }else if(temp[lright]>temp[rright]){
                  count+=rright-rleft+1;
                  n[k]=temp[lright];
                  lright--;
              }else{
                  n[k]=temp[rright];
                  rright--;
              }
          }
        sum+=count;
        System.out.println(count);
    }


}
