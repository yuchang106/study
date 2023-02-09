package test.java;

public class PkgTest {
    public static void main(String[] args) {
        System.out.println("hello PkgTest");
        System.out.println(PkgHello.pkgName());
    }
}

class PkgHello {
    public static String pkgName() {
        return "this is a PkgHello";
    }
}
