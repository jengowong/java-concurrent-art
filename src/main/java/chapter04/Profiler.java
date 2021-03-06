package chapter04;

import java.util.concurrent.TimeUnit;

/**
 * 6-15
 */
public class Profiler {
    // ��һ��get()��������ʱ����г�ʼ�������set����û�е��ã���ÿ���̻߳����һ��
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }

}
