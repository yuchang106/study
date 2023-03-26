package lesson;

public class StudentChild extends Student {
    @Override
    public void writeBody(String str) {
        System.out.println("this is the article from a StudentChild");
    }
}
