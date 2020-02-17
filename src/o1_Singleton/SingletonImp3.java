package o1_Singleton;

public class SingletonImp3 {
    //静态代码块，只在类加载时调用一次
    private SingletonImp3(){}
    private static SingletonImp3 singletonImp3;
    static {
        //本身就是线程同步，且只执行一次
        singletonImp3=new SingletonImp3();
    }
    public static SingletonImp3 getInstance(){
        return  singletonImp3;
    }
}