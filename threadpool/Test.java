package threadpool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    private static Map<String, String> map;
    static int flag = 10;
    static int count;
    public static void main(String[] args) throws InterruptedException {
        map = new HashMap<>();
        map.put("name", "yzy");
        map.put("age", "55");

        final var pool = new ThreadPoolExecutor(5, 10, 2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            pool.submit(()->{
                map.put("name", "yuchang");
                map.put("age", "25");
            });
        }

        for (int i = 0; i < 10; i++) {
            pool.submit(()->{
                map.put("name", "yzy");
                map.put("age", "25");
            });
        }

        for (int i = 0; i < 10; i++) {
            pool.submit(()->{
                while( "yuchang".equals(map.get("name")));
            });
        }

        //Thread.sleep(1000);
        System.out.println(map.put("kkk", "ooo"));
        System.out.println(map.put("ppp", "qqq"));
        System.out.println(map.put("www", "ttt"));

        map.forEach((k,v)->{
            System.out.println(k + " is a " +v);
        });

        if( pool.getActiveCount() ==  0) {
            pool.shutdown();
        }
    }
}