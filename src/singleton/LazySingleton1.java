package singleton;
/*
* 懒汉式单例模式1
* 优点：1.实现了延迟加载
*       2.使用synchronized进行线程加锁，解决了线程安全问题。
* 缺点：每次调用getInstance（），都要进行线程锁定判断，效率低，系统性能降低。
*
* 实现单例的理由：synchronized锁定和instance == null的判断
*
* */
public class LazySingleton1 {
    private static int count = 0;
    private static LazySingleton1 instance = null;
    private LazySingleton1(){
        count++;
        System.out.println("初始化LazySingleton1，次数是："+count);
    }
    synchronized public static LazySingleton1 getInstance() {
        if (instance == null){
                instance = new LazySingleton1();
        }
        return instance;
    }
}
