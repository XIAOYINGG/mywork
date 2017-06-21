package singleton;
/*
* 枚举类单例模式1
* 优点：1.代码简洁
*       2.提供了序列化机制，绝对防止多次实例化，
* 缺点：
* */
public enum EnumSingleton {
    instance;
    private EnumSingleton(){
        System.out.println("枚举类的构造函数被调用");
    }
}
