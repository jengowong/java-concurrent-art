package chapter00;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * http://wuyuetian.iteye.com/blog/2299131
 *
 * 示例二：描述waiting on condition
 */
public class MainThread2 {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

    public static void main(String[] args) {
        queue.add("ABC");

        try {
            queue.put("DEF");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
