package oo_niuke.WangYiBiShi;
import java.math.BigDecimal;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        double score[]=new double[n+1];
        score[0]=0;
        if(n<1){
            return;
        }
        double sum=0.0;
        double baifen[]=new double[n+1];
        baifen[0]=0.0;
        for(int i=1;i<=n;i++){
            score[i]=scanner.nextDouble();
            if(score[i]<0||score[i]>150)
                return;
        }
        //System.out.println(sum);
        int chaoguo[]=outR(score,n);

//
        int m=scanner.nextInt();
        if(m>10000){
            return;
        }
        if(m>n)
            return;
        int num[]=new int[m+1];
        num[0]=0;
        for(int i=1;i<=m;i++){
            num[i]=scanner.nextInt();
            if(num[i]>m)
                return;
            if(num[i]<=0)
                return;
            if(chaoguo[num[i]]==1){
                BigDecimal bd=new BigDecimal((1.0/n)*100);
                System.out.println(bd.setScale(6,4).toString());
            }else if(chaoguo[num[i]]-1==1)
            {
                BigDecimal bd=new BigDecimal((2.0/n)*100);
                System.out.println(bd.setScale(6,4).toString());
            }
            else if(chaoguo[num[i]]-1==0){
                BigDecimal bd=new BigDecimal(0.0/1.0);
                System.out.println(bd.setScale(6,4).toString());
            }
            else{
               // System.out.println((double)chaoguo[num[i]]);
                //double x=((double)chaoguo[num[i]]/(double)n);
                //System.out.println(x);
                BigDecimal bd=new BigDecimal((double)chaoguo[num[i]]/(double)n*100);
                System.out.println(bd.setScale(6,6).toString());
            }
        }
    }
    public static int[] outR(double score[],int n){
        if(score==null||score.length==0||n<=0)
            return null;
        int chaoguo[]=new int[n+1];
        chaoguo[0]=0;
        for(int i=1;i<=n;i++){
            chaoguo[i]=-1;
        }
        //ArrayList<Double> arrayList=new ArrayList<Double>();
        for(int i=1;i<=n;i++){
            double index=score[i];
            for(int j=1;j<=n;j++){
                if(score[j]<=index)
                    chaoguo[i]++;
            }
        }
        //Collections.sort(arrayList);
        return chaoguo;
    }
}
