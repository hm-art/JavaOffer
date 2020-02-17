package oo_TuJia;

import java.util.Scanner;

public class One {
    //public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int M=scanner.nextInt();
//        int S=scanner.nextInt();
//        int P=scanner.nextInt();
//        yesOrNo(M,S,P);
//        //System.out.println("Yes 10");
//    }
//    public static void yesOrNo(int M,int S,int P){
//        if(M<0||S<0||P<0)
//            return;
//        int biaoji=S;
//        for(int i=0;i<P;i++){
//            if(S<=0){
//                P=i;
//                break;
//            }
//            if(M>=10){
//                M-=10;
//                S-=50;
//            }else{
//                if(cShine(P,i,M)){
//                    M+=4;
//                }else{
//                    S-=13;
//                }
//            }
//        }
//        if(S<=0){
//            System.out.println("Yes");
//            System.out.println(P);
//        }else{
//            System.out.println("No");
//            System.out.println(biaoji-S);
//        }
//    }
//    public static boolean cShine(int S,int i,int M){
//        boolean flag=false;
//        if((S-i-1)*4+M>=10){
//            flag=true;
//        }
//        return flag;
//    }



            public static void main(String[] args)
            {
                Scanner scanner = new Scanner(System.in);
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                int t = scanner.nextInt();
                int dis = 0;
                for (int i = 1; i <= t; i++)
                {
                    if (m >= 10)
                    {
                        dis += 50;
                        m -= 10;
                    }
                    else if (t - i > 4)
                        m += 4;
                    else
                        dis += 13;
                    if (dis >= s)
                    {
                        System.out.println("Yes");
                        System.out.println(i);
                        break;
                    }
                }

                if (dis < s)
                {
                    System.out.println("No");
                    System.out.println(dis);
                }
            }
        }
//}
