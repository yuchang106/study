package com.sqsoft;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * *************************************************
 * 系统名称：安全子系统
 * 开发人员：yzy
 * 创建日期：2024/6/30  15:30
 * -------------------------------------------------
 * 业务模块：
 * 程序功能：
 * -------------------------------------------------
 */
public class MyThreadPool {
    // 任务队列，考虑线程安全
    private final List<Runnable> tasks = Collections.synchronizedList(new LinkedList<>());
    // 当前线程数
    private int num;
    // 核心线程数
    private final int corePoolSize;
    // 最大线程数
    private final int maxPoolSize;

    public MyThreadPool(int corePoolSize, int maxPoolSize) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
    }

    // 提交任务
    public void submit(Runnable r) {
        if (num >= maxPoolSize) {
            System.out.println("任务"+num+"已经被丢弃");
        }
        else if (num >= corePoolSize) {
            System.out.println("任务"+num+"已被缓存");
            tasks.add(r);
            num++;
        }
        else {
            tasks.add(r);
            execTask(r);
            num++;
        }
    }
    private void execTask(Runnable r) {
        new MyWorker("线程"+num, tasks).start();
    }
}
