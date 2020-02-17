package o1_Singleton;

public class SinglentonImp1 {
    //单子模式
    //懒汉模式：为空才new
    private SinglentonImp1(){}
    private static SinglentonImp1 singlentonImp1;
//    public static SinglentonImp1 getInstance(){
//        if(singlentonImp1==null){//只有第一次使用对象时才会发生这个判断，因为这个变量是静态的，所以存值
//            singlentonImp1=new SinglentonImp1();
//        }
//        return singlentonImp1;
//    }

    //懒汉模式下为了避免多线程下只创建一个对象，所以加一个多线程同步锁
//    public  static SinglentonImp1 getInstance(){
//        synchronized (SinglentonImp1.class){
//            if(singlentonImp1==null){
//                singlentonImp1=new SinglentonImp1();
//            }
//            return singlentonImp1;
//        }
//    }

    //每次加锁耗时，所以改进，只保证对象为null时，new一个实例，在这个时候加锁
    public  static SinglentonImp1 getInstance(){

        if(singlentonImp1==null){
            synchronized (SinglentonImp1.class){
                if(singlentonImp1==null){
                    singlentonImp1=new SinglentonImp1();
                }
            }

        }
        return singlentonImp1;

    }
}
