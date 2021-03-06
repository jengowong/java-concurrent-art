package chapter00;

import java.util.concurrent.TimeUnit;

/**
 * http://wuyuetian.iteye.com/blog/2299131
 *
 * 示例三：描述Object.wait()
 */
public class MainThread3 {

    public static void main(String[] args) {
        final Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        System.out.println(Thread.currentThread());
                        this.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }; //执行该语句后，thread2线程状态为new
        thread2.setName("thread2"); //设置线程名为thread2，方便jstack中查看
        thread2.start(); //thread2状态为runnable

        sleep(1); //保证先执行线程thread2

        synchronized (thread2) {
            System.out.println(Thread.currentThread());
            sleep(10);
            thread2.notify(); //唤醒thread2
        }
    }

    private static void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
