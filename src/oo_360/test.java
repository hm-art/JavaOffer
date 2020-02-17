package oo_360;
import java.util.HashMap;
import java.util.Scanner;
public class test{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str = scanner.next();
        char c[]=str.toCharArray();
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<c.length;i++){
            if(hashMap.containsKey(c[i])){
                hashMap.put(c[i], hashMap.get(c[i])+1);
            }else{
                hashMap.put(c[i],1);
            }
        }
        int max=0;
        for(int k=0;k<c.length;k++){
            if(max<hashMap.get(c[k])){
                max=hashMap.get(c[k]);
            }
        }
        System.out.println(max);
    }
}
