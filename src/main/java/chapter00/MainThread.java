package chapter00;

import java.util.concurrent.TimeUnit;

/**
 * http://wuyuetian.iteye.com/blog/2299131
 *
 * 示例一：描述 Blocked 和 Waiting to lock
 */
public class MainThread {

    public static void main(String[] args) {
        final Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        System.out.println(Thread.currentThread());
                        TimeUnit.SECONDS.sleep(60);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }; //执行该语句后，thread2线程状态为new
        thread2.setName("thread2"); //设置线程名为thread2，方便jstack中查看
        thread2.start(); //thread2状态为runnable

        synchronized (thread2) {
            try {
                System.out.println(Thread.currentThread());
                TimeUnit.SECONDS.sleep(60);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
