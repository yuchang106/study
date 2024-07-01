package com.sqsoft;

import java.util.concurrent.Callable;

/**
 * *************************************************
 * 系统名称：安全子系统
 * 开发人员：yzy
 * 创建日期：2024/6/29  10:43
 * -------------------------------------------------
 * 业务模块：
 * 程序功能：
 * -------------------------------------------------
 */
public class MyCaller<T> implements Callable<T> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public T call() throws Exception {
        System.out.println("test");
        return null;
    }
}
