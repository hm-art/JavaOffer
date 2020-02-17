package o59_MaxOfQuene;

import java.util.ArrayDeque;

//题一：滑动窗口的最大值
//      存滑动窗口最大值数组得长度为num.length(初始数组长度)-size(滑动窗口大小)+1
//      双头队列方便前删和后删 ArrayDeque
//      先初始化滑动窗口，也就是看数组中前两个，谁大把谁得索引存进去
//      经过上一步骤索引为0和1的元素已经比较完了，所以下次从i=size-1开始
//      若队列不为空
//      先看当前索引位置的元素是否比队列里已经存在的所有值都大
//      若大于，则删除队列中比当前位置的元素小的元素
//      若队列不为空，再判断一下当前索引位置-队列头部索引位置的和是否>=size
//      若大于则表明一个滑动窗口已经结束了，将里面目前所存的值（也就是上次滑动窗口所获得的最大值）移出去
//      若队列中为空，则把当前索引位置存进去，
//      max数组中存每轮比较后队列中的头
public class one {
    public static void main(String[] args) {
        int num[]={2,3,4,2,6,2,5,1};
        int size=3;
        int reslut[]=getMax(num,size);
        for (int i:reslut
             ) {
            System.out.println(i);
        }
        //System.out.println(reslut);
    }
    public static int[] getMax(int num[],int size){
        if(num==null||num.length<=0||size<=0||size>num.length){
            System.out.println("shurucuowu");
            return null;
        }
        //      存滑动窗口最大值数组
        // 得长度为num.length(初始数组长度)-size(滑动窗口大小)+1
        int max[]=new int[num.length-size+1];
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
        //      先初始化滑动窗口，也就是看数组中前两个，谁大把谁得索引存进去
        for(int i=0;i<size-1;i++){
            while(!arrayDeque.isEmpty()&&num[i]>arrayDeque.getLast()){
                arrayDeque.removeLast();
            }
            arrayDeque.addLast(i);
        }
        //      经过上一步骤索引为0和1的元素已经比较完了，所以下次从i=size-1开始
        //      若队列不为空
        //      先看当前索引位置的元素是否比队列里已经存在的所有值都大
        //      若大于，则删除队列中比当前位置的元素小的元素
        //      若队列不为空，再判断一下当前索引位置-队列头部索引位置的和是否>=size
        //      若大于则表明一个滑动窗口已经结束了，将队列头目前所存的索引（也就是上次滑动窗口所获得的最大值的索引）移出去
        //      若队列中为空，则把当前索引位置存进去，
        //      max数组中存每轮比较后队列中的头
        int j=0;
        //2,3,4,2,6,2,5,1
        for(int i=size-1;i<num.length;i++){
            while(!arrayDeque.isEmpty()&&num[i]>num[arrayDeque.getLast()]){
                arrayDeque.removeLast();
            }
            if(!arrayDeque.isEmpty()&&((i-arrayDeque.getFirst())>=size)){
                arrayDeque.removeFirst();
            }
            arrayDeque.addLast(i);
            max[j++]=num[arrayDeque.getFirst()];//getFirst，队列头，存的是每次滑动所得的最大值
        }
        return max;
    }
}
