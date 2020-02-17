package o21_ArrayOrder;
//21.调整数组顺序使奇数位于偶数前面
//初始方法：Recorder() 缺点：无法保持相对位置不变
//定义两个指针，l指向头，只向右走，r指向尾，只向左走
//l<r则未遍历完（while的条件）
//l指向的数若为奇数则+1,直至指向偶数 注：l<数组长度-1
//r指向的数若为偶数则-1，直至指向奇数 注：r>0
//交换l和r所在位置的数
//
//优化后的方法：greatRecorder() 新程序员不需要会写，了解思想
//分成两部分代码
//一个用于判断是否符合要求功能func（）
//另一个就是Recorder()
//只需要将Recorder() 里while的判断条件改为func（）是真还是假
public class RecorderArry {
    public static void main(String[] args) {
         test1();
         test2();
         test3();
         test4();
         test5();
         test6();
    }

    public static void Recorder(int []a){
        if(a==null||a.length==0){
            return ;
        }
        int l=0;
        int r=a.length-1;
        while(l<r){
            while(l<a.length&&((a[l]&1)!=0)){//&1!=0代表是奇数 注；a[l]&1必须括上
                l++;//直至指向一个偶数
            }
            while(r>0&&((a[r]&1)==0)){
                r--;//直至指向一个奇数
            }
            //偶在左奇在右，所以交换位置
            int temp=0;
            if(l<r){
                temp=a[l];
                a[l]=a[r];
                a[r]=temp;
            }
        }
    }
    //测试用例
    public static void test(int []a){
        if(a==null||a.length==0){
            return ;
        }
        System.out.println("调转前：");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();

        System.out.println("调转后：");
        Recorder(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println("----------------");
    }
    public static void test1(){
        int a[]=null;
        test(a);
    }
    public static void test2(){
        int a[]={};
        test(a);
    }
    public static void test3(){
        int a[]={1,2,3,4,5};
        test(a);
    }
    public static void test4(){
        int a[]={5,3,4,1,2};
        test(a);
    }
    public static void test5(){
        int a[]={-1,0,3,4,1,2};
        test(a);
    }
    public static void test6(){
        int a[]={1,3,5,2,4,6};
        test(a);
    }
}
