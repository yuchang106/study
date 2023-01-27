public class Dao {
    public static void main(String[] args) {
        System.out.println("hello dao");
        String s1 = "hello";
        String s2 = "yzy";
        String[] str = {s1,s2};
        Dao1.main(str);
    }
}
class Dao1 {
    public static void main(String[] args) {
        System.out.println(args[0]+" " +args[1]);
    }
}