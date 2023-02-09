package test.java;

public class PkgTest {
    public static void main(String[] args) {
        System.out.println("hello PkgTest");
        PkgHello pkgHello = new PkgHello();
        System.out.println(pkgHello.pkgName());
    }
}

class PkgHello {
    public String pkgName() {
        return "this is a PkgHello";
    }
}
