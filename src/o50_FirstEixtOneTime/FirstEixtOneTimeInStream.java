package o50_FirstEixtOneTime;

import oo_toByte.C;

import java.util.HashMap;
import java.util.Map;

//字符流中第一个只出现一次的字符
public class FirstEixtOneTimeInStream {
    public static int n[]=new int[256];
    public static Map<Character,Integer> map=new HashMap<>();
    public static void insert(char c){
        map.put(c,-1);
    }
}
