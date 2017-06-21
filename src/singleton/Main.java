package singleton;

public class Main {
    public static void main(String[] args) {
        for (int i = 0;i <= 20;i++){
            new myThread().start();
        }
    }
}

class myThread extends Thread{
    public void run() {
        for (int i = 0;i <= 10;i++){
            EagerSingleton.getInstance();
            DCLSingleton.getInstance();
            IoDHSingleton.getInstance();
            LazySingleton1.getInstance();
            LazySingleton2.getInstance();
            EnumSingleton s = EnumSingleton.instance;
       }
    }
}
