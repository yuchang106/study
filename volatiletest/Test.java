package volatiletest;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        MainParameter.setName("yzy");
        MainParameter.setAge(55);

        new Thread(()->{
            while(MainParameter.getAge() == 55) ;
        }).start();

        Thread.sleep(1000);
        //MainParameter.setAge(55);
    }
}
