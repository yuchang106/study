package volatiletest;

import org.slf4j.LoggerFactory;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        final var logger = LoggerFactory.getLogger(Test.class);
        MainParameter.setName("yzy");
        MainParameter.setAge(55);

        new Thread(() -> {
            while(MainParameter.getAge() == 55) {
                final var name = MainParameter.getName();
                for (int i = 0; i < 100; i++) {
                    String hname = name;
                }
                MainParameter.getStatus();
            }
        }).start();

        Thread.sleep(1000);
        MainParameter.setAge(56);
    }
}
