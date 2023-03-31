package sockettest.client;

import sockettest.tools.SocketConnPool;
import sockettest.tools.ThreadRun;

public class Test {

    private static final int port = 8080;
    private static final String host = "localhost";

    public static void main(String[] args) throws InterruptedException {
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
    }
}
