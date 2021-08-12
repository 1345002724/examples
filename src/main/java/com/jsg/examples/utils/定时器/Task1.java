package com.jsg.examples.utils.定时器;

public class Task1 {
    public static void main(String[] args) {
        // run in a second
        // 每一秒钟执行一次
        final long timeInterval = 1000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    // ------- code for task to run
                    // ------- 要运行的任务代码
                    System.out.println("Hello, stranger");
                    // ------- ends here
                    try {
                        // sleep()：同步延迟数据，并且会阻塞线程
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //创建定时器
        Thread thread = new Thread(runnable);
        //开始执行
        thread.start();
    }
}