package com.sqsoft;

/**
 * *************************************************
 * 系统名称：安全子系统
 * 开发人员：yzy
 * 创建日期：2024/6/29  09:34
 * -------------------------------------------------
 * 业务模块：
 * 程序功能：
 * -------------------------------------------------
 */
public class App {
    private static final ThreadLocal<Student> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        final MyThreadPool myThreadPool = new MyThreadPool(3, 8);
        for (int i = 0; i < 10; i++) {
            myThreadPool.submit(new MyTask(i));
        }

//        for (int i = 0; i < 5; i++) {
//            int finalI = i;
//            new Thread(() -> {
//                final Student stu = new Student();
//                stu.setId(finalI +1);
//                stu.setName("yzy");
//                threadLocal.set(stu);
//                System.out.println(threadLocal.get().getId());
//                System.out.println(threadLocal.get().getName());
//            }).start();
//        }
//        System.out.println(System.getenv("HOME"));
//
//        final HashMap<String, String> map = new HashMap<>();
//        map.put("yzy", "yuzhangyan");
//        map.put("yx", "yangxi");
//        map.put("yc", "yuchang");
//        map.forEach((s, s2) -> System.out.println(s + ":" + s2));
//
//        //  计算对象所占用的内存大小
//        int size = 0;
//        System.out.println(ObjectSizeCalculator.getObjectSize(map));
//        System.out.println(ObjectSizeCalculator.getObjectSize(size));
    }
}
