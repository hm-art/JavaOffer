package o50_FirstEixtOneTime;

import java.util.HashMap;
import java.util.Map;

//相关题目中的第一个
//删除字符串1中包含的字符串2中的字符
public class String1DeleteString2 {
    public static void main(String[] args) {
        deleteString2InString1("We are Student","aeiou");
        //System.out.println('\0'+"str");
        //get1("We are Student","aeiou");
    }
    public static void deleteString2InString1(String str1,String str2){
        if(str1==null||str1.length()==0){
            System.out.println("输入错误");
            return;
        }
        if(str1!=null&&str1.length()!=0&&(str2==null||str2.length()==0)){
            System.out.println("删除后的str1是 "+str1);
            return;
        }
        char c2[]=str2.toCharArray();
        int hash[]=new int[256];
        for(int i=0;i<c2.length;i++){
            hash[c2[i]]=1;
        }
        char c1[]=str1.toCharArray();
        for(int i=0;i<c1.length;i++){
            if(hash[c1[i]]==1)
                c1[i]='\0';//啥也没有 变成了空字符
        }
        System.out.println(c1);
    }

}

