package o33_HouXuBianLiBinaryTree;
//33.二叉搜索树的后序遍历
//   二叉搜索树的特点：右孩子>根>左孩子
//   输入一个序列，判断这个序列是不是某一个二叉搜索树的后序遍历
//   序列中每个值都不一样
//   5      7    6    9     11      10      8
//  start       mid-1 mid   mid+1          end
//   最后一个数8一定是根节点
//   6<8 9>8 所以5 7 6是左子树 6是根
//               9 11 10是右子树 10是根

public class HouXuBianLiBinaryTree {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }
    public static boolean judge(int n[]){//判断数组的合法性，存在则继续判断是不是二叉搜索树的后序遍历
        if(n==null||n.length==0)
            return false;
        return verifyCore(n,0,n.length-1);
    }
    private static boolean verifyCore(int[] n, int start, int end) {
        //必须是>= 否则test6的情况，无法判断
        if(start>=end)//1.只有一个根节点 2.有多个节点但判断完毕了
            return true;
        int mid=start;
//        if(n[mid]>n[end])
//            return false;
        while(n[mid]<n[end])
            mid++;
        for(int i=mid;i<end;i++){//判断右子树是不是二叉搜索树
            if(n[i]<n[end])
                return false;
        }
        return verifyCore(n,start,mid-1)&&verifyCore(n,mid,end-1);
    }
    public static void test1(){//false
        int n[]=null;
        System.out.println(judge(n));
    }
    public static void test2(){//true
        int n[]={1};
        System.out.println(judge(n));
    }
    public static void test3(){//true
        int n[]={1,3,2};
        System.out.println(judge(n));
    }
    public static void test4(){//true
        int n[]={5,7,6,9,11,10,8};
        System.out.println(judge(n));
    }
    public static void test5(){//false
        int n[]={7,4,6,5};
        System.out.println(judge(n));
    }
    public static void test6(){//true
        //       1
        //null       2
        //n n      n    3
        int n[]={3,2,1};
        System.out.println(judge(n));
    }
    public static void test7(){//false
        //  1
        // 2  3
        int n[]={2,3,1};
        System.out.println(judge(n));
    }
    public static void test8(){//true
        //    3
        //  2
        //1
        int n[]={1,2,3};
        System.out.println(judge(n));
    }
}
