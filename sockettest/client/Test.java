package sockettest.client;

public class Test {

    private static final int port = 8080;
    private static final String host = "localhost";
    private volatile static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            int i = 0;
            while (flag) i++;
        }).start();

        Thread.sleep(1000);
        flag = false;
//        System.out.println(true);

        /*
        new Thread(new ThreadRun()).start();
        new Thread(new ThreadRun()).start();
        new Thread(new ThreadRun()).start();
        new Thread(new ThreadRun()).start();
        Thread.sleep(1000);
        System.out.println(SocketConnPool.getChannelPoolSize());
        new Thread(new ThreadRun()).start();
        System.out.println(SocketConnPool.getChannelPoolSize());
        new Thread(new ThreadRun()).start();
        Thread.sleep(60000);
        new Thread(new ThreadRun()).start();
        System.out.println(SocketConnPool.getChannelPoolSize());
        */
    }
}
