package oo_niuke;

import java.util.Scanner;

//又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
//        牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
//        在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
//        牛牛觉得这个问题太简单，所以希望你来替他回答。
//
//        输入描述:
//        第一行一个数n(1 <= n <= 105)。
//        第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
//        第三行一个数m(1 <= m <= 105)，表示有m次询问。
//        第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
//
//        输出描述:
//        m行，第i行输出第qi个苹果属于哪一堆。
//
//        输入例子1:
//        5
//        2 7 3 4 9      2 9 12 16 25
//        3
//        1 25 11
//
//        输出例子1:
//        1
//        5
//        3
//public class wangyi3 {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int m=scanner.nextInt();
//        int mm[]=new int[m+1];
//        int temp[]=new int[m+1];
//        for(int i=1;i<=m;i++){
//             mm[i]=scanner.nextInt();
//        }
//        temp[1]=mm[1];
//        temp[2]=mm[1]+mm[2];
//        for(int i=2;i<=m;i++){
//            if(i>2)
//            temp[i]=temp[i-1]+mm[i];
//        }
//        int n=scanner.nextInt();
//        int nn[]=new int[n+1];
//        int result[]=new int[n+1];
//        for(int i=1;i<=n;i++){
//            nn[i]=scanner.nextInt();
//            for(int j=m;j>=1;j--){
//                if(nn[i]<=temp[j]){
//                    result[i]=j;
//                }
//            }
//        }
////        for(int i=1;i<=n;i++){
////            for(int j=m;j>=1;j--){
////                if(nn[i]<=temp[j]){
////                    result[i]=j;
////                }
////            }
////        }
//        for(int i=1;i<=n;i++){
//            System.out.println(result[i]);
//        }
//    }
//}
public class wangyi3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] appleNums = new int[n];
        for (int i = 0; i < n; i++) {
            appleNums[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] query = new int[m];
        for (int i = 0; i < m; i++) {
            query[i] = sc.nextInt();
        }
        int[] leftsum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += appleNums[i];
            leftsum[i] = sum;
        }
        for (int i = 0; i < m; i++) {
            System.out.println(binSearch(leftsum, query[i]) + 1);
        }
    }

    public static int binSearch(int[] arr, int k) {
        int mid = arr.length / 2;
        if (k == arr[mid]) {
            return mid;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (k < arr[mid]) {
                end = mid - 1;
            } else if(k > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}