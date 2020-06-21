package com.leetcode.thread;

import java.util.concurrent.locks.LockSupport;

public class ThreadWait {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("wait");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        LockSupport.park();

    }
}
