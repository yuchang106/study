package volatiletest;

public class Task1 implements Runnable{
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
        if(MainParameter.flag == 1) {
            System.out.println(Thread.currentThread().getName() + " - " + MainParameter.getMap().get("name"));
            System.out.println(Thread.currentThread().getName() + " - " + MainParameter.getMap().get("age"));
        }
    }
}
