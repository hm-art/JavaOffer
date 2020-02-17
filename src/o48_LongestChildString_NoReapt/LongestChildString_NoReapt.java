package o48_LongestChildString_NoReapt;
//48.最长不含重复字符的子字符串
//   思想还是递归，利用动态规划改善递归效率低的问题，再用循环改善重复计算多的问题
//   f(i)表示以第i个字符为结尾的，不包含重复字符的字串的长度
//   eg:arabcacfr
//      分两种情况：
//               第i个字符之前未出现过，则f(i)=f(i-1)+1，比如f(0)=1，f(1)=f(0)+1=2
//               第i个字符之前出现过，那么又分成了两种情况
//                  首先，d=第i个字符和它上一次出现的位置的距离
//                  ①d<=f(i-1),则f(i)=d
//                    例如ara，对于后一个a来说，d=2=f(i-1),则f(2)=2
//                             与之对应的不含重复字符的子字符串是ra
//                  ② d>f(i-1),则f(i)=f(i-1)+1
//                    例f(7)=3  (对应acf)  对于最后一个字符r，它的d=7>f(7)
//                      所以f(8)=f(7)+1=4,对应的就是acfr
public class LongestChildString_NoReapt {
    public static void main(String[] args) {
        String s=null;
        System.out.println(noReapet(s));//-1
        String s1="aaaaa";
        System.out.println(noReapet(s1));//1
        String s2="abcde";
        System.out.println(noReapet(s2));//5
        String s3="arabcacfr";
        System.out.println(noReapet(s3));//4
    }
    public static int noReapet(String s){
        if(s==null||s.length()<=0)
            return -1;
        int position[]=new int[26];//记录每个字符上次出现的位置
        for(int i=0;i<26;i++)
            position[i]=-1;//初始化-1，代表未出现过
        //int preIndex=0;//字符上次出现的位置
        int maxLength=0;//重复字符最长的长度
        int curLength=0;//当前的长度
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int preIndex=position[c-'a'];
            int d=i-preIndex;
            if(preIndex==-1||d>curLength)//该字符未出现过或出现过但d>f(i-1)
                curLength++;
            else{//出现过,d<=f(i-1)
                curLength=d;
            }
            position[s.charAt(i)-'a']=i;// 一旦字符出现过以后，position记录当前字符出现的位置
            if(curLength>maxLength)
                maxLength=curLength;
        }

        return maxLength;
    }
}
