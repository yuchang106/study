package com.sqsoft;

/**
 * *************************************************
 * 系统名称：安全子系统
 * 开发人员：yzy
 * 创建日期：2024/6/30  11:01
 * -------------------------------------------------
 * 业务模块：
 * 程序功能：
 * -------------------------------------------------
 */
public class MyTask implements Runnable{
    private final int id;

    public MyTask(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("任务:" + id + " 即将执行任务：");
        // 执行任务
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("任务:" + id + " 完成了任务");
    }
}
