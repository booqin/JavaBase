import java.lang.reflect.Proxy;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args){

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 3, 3L, TimeUnit.SECONDS, new SynchronousQueue<>());

        for (int i = 0; i < 4; i++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + " 执行 - " + i);
                    }
                    System.out.println("run");
                }
            });
        }
        poolExecutor.shutdown();

    }
}
