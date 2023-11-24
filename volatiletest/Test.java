package volatiletest;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Task()).start();
        }
//        final var pool = new ThreadPoolExecutor(10, 20, 2,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(10),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());
//
//        for (int i = 0; i < 10; i++) {
//            pool.submit(new Task());
//        }

//        Thread.sleep(1000);
//        for (int i = 0; i < 10; i++) {
//            pool.submit(new Task1());
//        }

        Thread.sleep(1000);
//        pool.shutdown();
    }
}
