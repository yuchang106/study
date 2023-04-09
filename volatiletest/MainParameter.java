package volatiletest;

public class MainParameter {
    private volatile static int status;
    private static String name;
    private static int age;

    public static int getStatus() {
        return status;
    }

    public static void setStatus(int status) {
        MainParameter.status = status;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        MainParameter.name = name;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        MainParameter.age = age;
    }
}
