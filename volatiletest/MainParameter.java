package volatiletest;

public class MainParameter {
    private static String name;
    private static int age;

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
