package singleton;
/*
* 懒汉式单例模式2
* 优点：为了提高效率，可以把同步锁放到方法里，先判断instance是否为空。
* 缺点：会存在单例对象不唯一的问题。
*       线程1和线程2如果都在调用getInstance()，instance为null，能通过判断“instance == null”，
*       由于有synchronized加锁机制，线程1进入synchronized锁定的代码，创建实例，
*       线程2此时处于排队，线程1执行完代码后，线程2进入synchronized锁定的代码。
*       但此时线程2不知道实例已经创建，将会继续创建实例。
*
* 实现单例的理由：instance == null的判断和synchronized锁定
*
* */
public class LazySingleton2 {
    private static int count = 0;
    private static LazySingleton2 instance = null;
    private LazySingleton2(){
        count++;
        System.out.println("初始化LazySingleton2，次数是："+count);
    }
    public static LazySingleton2 getInstance() {
       if (instance == null){
           synchronized (LazySingleton2.class){
               instance = new LazySingleton2();
           }
       }
        return instance;
    }
}
