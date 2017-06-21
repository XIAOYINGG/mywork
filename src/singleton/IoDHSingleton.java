package singleton;
//在单例类中添加一个静态内部类，在该内部类中创建单例对象，再将该单例对象通过getInstance()方法返回给外部使用。
/*
* IoDH单例模式1
* 优点：1.线程安全
*       2.该模式引进了一个静态内部类（占位类），
*       在内部类中提前初始化实例，既保证了Singleton实例的延迟初始化，又保证了同步
* 缺点：与编程语言本身的特性相关，很多面向对象语言不支持IoDH
*
* 实现单例的理由：由Java虚拟机来保证其线程安全性
*
* */
public class IoDHSingleton {

    private static int count = 0;
    private IoDHSingleton(){
        count++;
        System.out.println("初始化IoDHSingleton，次数是："+count);
    }
    public static class HolderClass{
        private final static IoDHSingleton instance = new IoDHSingleton();
    }
    public static IoDHSingleton getInstance(){
      //  System.out.println("thread--"+i+"--enter");
        return HolderClass.instance;
    }
}
