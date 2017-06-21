package singleton;
/*
* 带双重检查锁定机制的懒汉式单例
* 优点：1.volatile修饰的成员变量可以确保多个线程正确处理
*       2.当多个进程进入第一个判断锁时，会被锁定机制隔离，只有一个程序进入创建实例，
*         等其他线程进入时，第二个判断instance已经不为null，因此不会新建多个对象。
*         可以保证只产生一个实例，并且只会在初始化的时候加同步锁
* 缺点：java是实行无序写入的机制,由于java内存模型一些原因偶尔失败
*
* */
public class DCLSingleton {

    private static int count = 0;
    private static volatile DCLSingleton instance = null;
    private DCLSingleton(){
        count++;
        System.out.println("初始化DCLSingleton，次数是："+count);
    }

    public static DCLSingleton getInstance(){
       // System.out.println("thread--"+i+"--enter");
        if(instance==null){  //第一次判断是否为null
          //  System.out.println("thread--"+i+"--enter status 1");
            synchronized(DCLSingleton.class){  //在代码块中加同步锁
                if(instance==null){
                    //System.out.println("thread--"+i+"--enter status 2");
                    instance=new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
