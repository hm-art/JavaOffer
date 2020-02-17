package o50_FirstEixtOneTime;

import java.util.HashMap;
import java.util.Map;

//50.第一个只出现一次的字符
//   传统方式是O(N^2)
//   为了提高时间效率，用时间换空间
//   可以利用HashMap表,Key是字符，Value是每个字符串出现的次数
//   时间复杂度就变为O(N)了
public class o50_FirstEixtOneTime {
    public static void main(String[] args) {
        FirstOnlyExitOneTime(null);
        FirstOnlyExitOneTime("abaccdeff");
        FirstOnlyExitOneTime("aa");
        FirstOnlyExitOneTime("0");
        FirstOnlyExitOneTime("ABCDE");
    }
    public static void FirstOnlyExitOneTime(String str){
        if(str==null||str.length()==0)
            return;
        char c[]=str.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<c.length;i++){
            if(map.containsKey(c[i])){
                map.put(c[i],map.get(c[i])+1);
            }
            else{
                map.put(c[i],1);
            }
        }
        for(int i=0;i<c.length;i++){
            if(map.get(c[i])==1) {
                System.out.println(c[i]);
                return ;
            }
        }
        System.out.println("没有第一个只出现一次的字符");
    }
}
