package oo_SouGou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class two {
    public static class Obj{
        int size;
        Obj(int n){
            size=n;
        }
        List<String> keySet=new ArrayList<>(size);
        List<Integer> valueSet=new ArrayList<>(size);
        List<Integer> timeSet=new ArrayList<>(size);
        public void add(String key,int value,int time){
            if(keySet.contains(key)){
                if(valueSet.get(keySet.indexOf(key))<value){
                    valueSet.set(keySet.indexOf(key),value);
                    timeSet.set(keySet.indexOf(key),value);
                }
            }else{
                if(keySet.size()<size){
                    keySet.add(key);
                    valueSet.add(value);
                    timeSet.add(time);
                }else{
                    int minTime=time+1;
                    for(int x:timeSet){
                        if(minTime>x){
                            minTime=x;
                        }
                    }
                    System.out.print(keySet.get(timeSet.indexOf(minTime))+" ");
                    System.out.println(valueSet.get(timeSet.indexOf(minTime))+" ");
                    keySet.remove(timeSet.indexOf(minTime));
                    valueSet.remove(timeSet.indexOf(minTime));
                    timeSet.remove(timeSet.indexOf(minTime));
                    keySet.add(key);
                    valueSet.add(value);
                    timeSet.add(time);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int time=0;
        Obj h=new Obj(n);
        while(scanner.hasNext()){
            String s=scanner.next();
            int v=scanner.nextInt();
            time++;
            h.add(s,v,time);
        }
    }
}
