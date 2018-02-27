package chapter11;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * ����Ϣ���й���
 */
public class MsgQueueManager implements IMsgQueue {

    /**
     * ��Ϣ�ܶ���
     */
    public final BlockingQueue<Message> messageQueue;

    private MsgQueueManager() {
        messageQueue = new LinkedTransferQueue<Message>();
    }

    public void put(Message msg) {
        try {
            messageQueue.put(msg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Message take() {
        try {
            return messageQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }

}
