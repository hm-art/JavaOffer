package o58_ReverseString;
//58.
//题一：反转字符串
//      思路：先反转整个句子中每个字母，再反转每个单词中的字母
//      例如：I am a girl.  -> .lrig a ma I  ->girl. a am I
//      再反转单词中的字母时，可以通过扫描空格来确定每个单词的起始位置和终止位置

public class one {
    public static void main(String[] args) {
       String str="I girl am student.";
       reverseSentence(str);
        String str1="girl";
        reverseSentence(str1);
        String str2="  ";
        reverseSentence(str2);
        String str3=null;
        reverseSentence(str3);
    }
    public static void reverseSentence(String str){
        if(str==null||str.length()<=0){
            //throw new RuntimeException("Input error");
            return;
        }
        char ch[]=str.toCharArray();
        //1.先反转整个句子中的每个字母
        char[] result1=reverseString(ch,0,ch.length-1);
        System.out.println("第一步反转"+String.valueOf(result1));
        //2.反转每个单词中的每个字母
        int start=0;
        int end=0;
        //System.out.println(result1.length);
        while(start<result1.length){
            while(end<result1.length&&result1[end]!=' '){
                end++;
            }
           // System.out.println("e"+end);
            result1=reverseString(result1,start,end-1);
//            end+=1;
//            start=0;
//            start+=end;
            end++;
            start=end;
            //System.out.println("s"+start);
        }
        System.out.println("第二步反转"+String.valueOf(result1));
    }
    //反转的核心方法
    public static char[] reverseString(char ch[],int start,int end){
        //指定索引位置的值交换
        while(start<end){
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            start++;
            end--;
        }
        return ch;
    }
}
