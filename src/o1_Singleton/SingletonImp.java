package o1_Singleton;

public class SingletonImp {
    //单子模式
    //一共6种：懒汉，饿汉，同步锁，改进同步锁，静态代码块，指定方法执行静态代码块
    //饿汉形式:不管是否为空，先new(创建)一个实例
    //一是单例模式的类只提供私有的构造函数，
    // 二是类定义中含有一个该类的静态私有对象，
    // 三是该类提供了一个静态的公有的函数用于创建或获取它本身的静态私有对象。
    private SingletonImp() {}//让构造器私有
    private static SingletonImp singletonImp=new SingletonImp();
    //创造一个private static实例
    public static SingletonImp getInstance(){
        //声明一个静态公共方法以方便外部使用创建的对象
        return singletonImp;
    }


}

