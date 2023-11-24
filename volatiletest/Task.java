package volatiletest;

import java.util.HashMap;
import java.util.Map;

public class Task implements Runnable{
    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        if( MainParameter.flag == 1 ) {
            System.out.println(Thread.currentThread().getName() + " : " + MainParameter.getMap().get("name"));
            System.out.println(Thread.currentThread().getName() + " : " +MainParameter.getMap().get("age"));
        }
        synchronized (Task.class) {
            if( MainParameter.flag == 1 ) {
                System.out.println(Thread.currentThread().getName() + " ? " + MainParameter.getMap().get("name"));
                System.out.println(Thread.currentThread().getName() + " ? " +MainParameter.getMap().get("age"));
            }
            if ( MainParameter.flag == 0 ) {
                Map<String, String> map = new HashMap<>();
                map.put("name", "yzy");
                map.put("age", "55");
                MainParameter.setMap(map);
                MainParameter.flag = 1;
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
