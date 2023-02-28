import java.util.Objects;

public class MainSvc {
    private String name;
    private int age;

    public MainSvc() {
    }

    public MainSvc(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        MainSvc ms = new MainSvc("yzy", 53);
        ms.test(ms);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainSvc mainSvc = (MainSvc) o;
        return age == mainSvc.age && name.equals(mainSvc.name);
    }

    public void test(MainSvc ms) {
        System.out.println(ms.name + ms.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}