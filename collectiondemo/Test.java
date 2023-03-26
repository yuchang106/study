package collectiondemo;

import java.util.ArrayList;
import java.util.Collection;

public class Test {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>(10);
        list.add("hello");
        list.add("world");
        list.add("by");
        list.add("yzy");
        System.out.println(list);
        System.out.println(list.size());

    }
}
