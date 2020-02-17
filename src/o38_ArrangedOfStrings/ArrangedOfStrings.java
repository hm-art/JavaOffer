package o38_ArrangedOfStrings;

import java.util.ArrayList;
import java.util.Collections;

//38.字符串的排列  (理解不了，背下来)
//   也是个递归问题
//   把一个字符串分为两部分，第一个字符作为投，后面的字符作为其他字符
//   头和后面的每一个字符进行交换，包括了他自己
//   每次交换之后首字符就会变了，所以再变回来
//   例：abcd
//       第一轮之后，得到了 abcd,bacd,cbad,dbca，得到了每个字母开头的一个
//       第二轮，第一个字母不动，后面字母中的第一个分别和该字母之后的字母交换
//              例如abcd，a不动，交换后得到a|cbd,a|dcb,其他三组同理
//       在往后，依次往下这样操作，        ac|bd->acbd,acdb
//                                       ad|cb->adcb,adbc
public class ArrangedOfStrings {
    public static void main(String[] args) {
        test1();
    }
    public static ArrayList<String> permutation(String str){
        if(str==null||str.length()==0)
            return null;
        ArrayList<String> arrayList=new ArrayList<>();
        permutationCore(str.toCharArray(),0,arrayList);
        //Collections.sort(arrayList);
        int l=arrayList.size();
        for(int i=1;i<l;i++){
            if(arrayList.get(i).equals(arrayList.get(i-1))){
                arrayList.remove(arrayList.get(i-1));
                l=l-1;
                i=i-1;
            }
        }
        return arrayList;
    }

    private static void permutationCore(char[] strArray, int index, ArrayList<String> arrayList) {
        if(index==strArray.length-1)//代表所有的排列都结束了，index已经到char数组的最后一位了
            arrayList.add(String.valueOf(strArray));//把之前计算的结果都放到arrayList里
        else{//
            for(int i=index;i<strArray.length;i++){
                char temp=strArray[index];
                strArray[index]=strArray[i];
                strArray[i]=temp;
                permutationCore(strArray, index+1, arrayList);
                temp=strArray[index];
                strArray[index]=strArray[i];
                strArray[i]=temp;
            }
        }
    }
    public static void test1(){
        String str="abcd";
        System.out.println(permutation(str));
    }
}
