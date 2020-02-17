package o1_Singleton;

public class SingletonImp4 {
    //限制只有调用getInstance（指定方法）时，才会创建实例
    //其他任何静态方法和
    private SingletonImp4(){
    }
    private static class Nes{
        private static SingletonImp4 singletonImp4;
        static {
            singletonImp4=new SingletonImp4();
        }
    }
    public static SingletonImp4 getInstance(){
        return Nes.singletonImp4;
    }
    static {

    }
    public static void fun(){

    }
}
