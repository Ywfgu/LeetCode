package com.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 验证jdk1.6 synchronized 经过优化后性能比cas高
 */
public class CompareAtomicAndSync {

    public static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void testAtomic(){
        atomicInteger.getAndIncrement();
    }

    public static int count =0;
    public synchronized static void testSync(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{testAtomic();},"i").start();
        }
        Thread.sleep(100L);
        System.out.println("atomic:"+atomicInteger.get()+" "+ (System.currentTimeMillis()-start-100));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{testSync();},"i").start();
        }
        Thread.sleep(100L);
        System.out.println("sync:"+count+" "+ (System.currentTimeMillis()-start-100));
    }
}
