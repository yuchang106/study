package collectiondemo;

import java.util.*;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>(10);
        list.add("hello");
        list.add("world");
        list.add("by");
        list.add("yzy");
        System.out.println(list);
        System.out.println(list.size());

        System.out.println("----------------");
        final var objects = list.toArray();
        System.out.println(Arrays.toString(objects));

        System.out.println("----------------");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-------------------");
        List<String> li = new ArrayList<>();
        li.add("yu");
        li.add("chang");
        li.add("一生幸福");
        System.out.println(li);

        System.out.println("-------------------");
        li.forEach(System.out::println);

        System.out.println("-------------------");
        li.forEach(s -> System.out.println(s));

        System.out.println("-------------------");
        li.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("-------------------");
        Consumer<String> cs = System.out::println;
        li.forEach(cs);

        System.out.println("-------------------");
        Consumer<String> csr = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
                System.out.println("nice");
            }
        };
        li.forEach(csr);
    }
}
