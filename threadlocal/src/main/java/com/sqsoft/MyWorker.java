package com.sqsoft;

import java.util.List;

/**
 * *************************************************
 * 系统名称：安全子系统
 * 开发人员：yzy
 * 创建日期：2024/6/30  11:21
 * -------------------------------------------------
 * 业务模块：
 * 程序功能：
 * -------------------------------------------------
 */
public class MyWorker extends Thread {
    private final List<Runnable> tasks;
    public MyWorker(String name, List<Runnable> tasks) {
        super(name);
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (!tasks.isEmpty()) {
            tasks.remove(0).run();
        }
    }
}
