package o19_Regex;

import java.util.Scanner;

public class DoRegex {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
          test4();
//        test5();
    }

    public static boolean JudegeStrong(char[] str, char[] mode) {
        if(str.length==0||mode.length==0)//鲁棒性
            return false;//其中有一个是空的，啥也没有，就直接返回false，为匹配
        return doRegex(str,0,mode,0);
    }

    public static boolean doRegex( char[] str,int indexofstr, char[] mode,int indexofmode) {
        int slength=str.length;
        int mlength=mode.length;
        if(slength==indexofstr&&mlength==indexofmode){//递归结束的条件1
            //字符串索引等于祖父穿长度且模式字符串索引也等于该自负床长度
            //str和mode都走到了头，遍历完了，匹配成功了
            return true;
        }
        if(slength>indexofstr&&mlength==indexofmode){//递归结束的条件2
            //str还没遍历完，但mode已经到头了
            return false;
        }
        if(indexofmode+1<mlength&&mode[indexofmode+1]=='*'){
            //mode没遍历完且 第二个字符为*
            if((indexofstr<slength&&str[indexofstr]==mode[indexofmode])||
                    (indexofstr<slength&&mode[indexofmode]=='.')){
                //str和mode的第一个字符匹配或者是mode的第一个字符是.
                //以下递归调用匹配0次，1次，多次
                // 0次时，str索引不变，mode索引+2
                // 1次时，str索引+1，mode索引+2
                // 多次时，str索引+1，mode索引不变
                return doRegex(str,indexofstr+0,mode,indexofmode+2)||
                        doRegex(str, indexofstr+1, mode, indexofmode+2)||
                        doRegex(str,indexofstr+1,mode,indexofmode);
            }else{//str和mode的第一个字符不匹配，并且mode的第一个字符也不是.
                return doRegex(str,indexofstr,mode,indexofmode+2);
                //第一个字符不匹配（.与任意字符视作匹配），则str索引不变，mode索引+2；
            }
        }
        //mode的第二个字符不为*时，如果str和mode当前字符相同或mode当前为. ，就是当前字符
        //匹配成功了，则str的索引和mode的索引都+1
        if(indexofstr<slength&&(str[indexofstr]==mode[indexofmode]||mode[indexofmode]=='.')){
            return doRegex(str,indexofstr+1,mode,indexofmode+1);
        }
        return false;//除以上外，其他情况都是没匹配成功，返回false
        }
    public static void test(String testname,char str[],char mode[],boolean expectresult){
        System.out.println("testname :"+testname);
        if(JudegeStrong(str,mode)==expectresult)
            System.out.println("测试通过");
        else
            System.out.println("测试不通过");
    }
    public static void test1(){
        char str[]={};
        char mode[]={'.'};
        test("test1",str,mode,false);
    }
    public static void test2(){
        char str[]={};
        char mode[]={'.','*'};
        test("test2",str,mode,true);
    }
    public static void test3(){
        char str[]={'a'};
        char mode[]={'a','b','*'};
        test("test3",str,mode,true);
    }
    public static void test4(){
        char str[]={'a','b'};
        char mode[]={'a','*','b'};
        test("test4",str,mode,true);
    }
    public static void test5(){
        char str[]={};
        char mode[]={};
        test("test5",str,mode,false);
    }
    }

