package lesson;

public abstract class Student {
    public final void write() {
        System.out.println("this is the title of the article");
        writeBody("hello, this is the body");
        System.out.println("this is the bottom");
    }

    public abstract void writeBody(String str);
}
