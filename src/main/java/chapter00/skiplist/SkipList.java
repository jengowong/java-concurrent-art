package chapter00.skiplist;

import java.util.Random;

/**
 * https://www.jianshu.com/p/60d2561b821c
 *
 * 不固定层级的跳跃表
 */
public class SkipList<T> {

    /** 链表头 */
    private Node<T> head;
    /** 链表尾 */
    private Node<T> tail;
    /** 节点总数 */
    private int nodes;
    /** 层数 */
    private int listLevel;
    /** 用于投掷硬币 */
    private Random random;
    /** 向上提升一个的概率 */
    private static final double PROBABILITY = 0.5;

    public SkipList() {
        this.clear();
    }

    /** 清空跳跃表 */
    public void clear() {
        this.head = new Node<T>(Node.HEAD_KEY, null);
        this.tail = new Node<T>(Node.TAIL_KEY, null);
        this.horizontalLink(head, tail);
        this.nodes = 0;
        this.listLevel = 0;
        this.random = new Random();
    }

    public boolean isEmpty() {
        return nodes == 0;
    }

    public int size() {
        return nodes;
    }

    /** 在最下面一层，找到要插入的位置前面的那个key */
    private Node<T> findNode(int key) {
        Node<T> p = this.head;
        while (true) {
            while (p.right.key != Node.TAIL_KEY && p.right.key <= key) {
                p = p.right;
            }
            if (p.down != null) {
                p = p.down;
            } else {
                break;
            }
        }
        return p;
    }

    /** 查找是否存储key，存在则返回该节点，否则返回null */
    public Node<T> search(int key) {
        Node<T> p = findNode(key);
        if (key == p.getKey()) {
            return p;
        } else {
            return null;
        }
    }

    /** 向跳跃表中添加key-value */
    public void put(int k, T v) {
        Node<T> p = findNode(k);
        //如果key值相同，替换原来的vaule即可结束
        if (k == p.getKey()) {
            p.value = v;
            return;
        }
        Node<T> q = new Node<T>(k, v);
        this.backLink(p, q);
        int currentLevel = 0;//当前所在的层级是0
        //抛硬币
        while (random.nextDouble() < PROBABILITY) {
            //如果超出了高度，需要重新建一个顶层
            if (currentLevel >= this.listLevel) {
                this.listLevel++;
                Node<T> p1 = new Node<T>(Node.HEAD_KEY, null);
                Node<T> p2 = new Node<T>(Node.TAIL_KEY, null);
                this.horizontalLink(p1, p2);
                this.verticalLink(p1, head);
                this.verticalLink(p2, tail);
                this.head = p1;
                this.tail = p2;
            }
            //将p移动到上一层
            while (p.up == null) {
                p = p.left;
            }
            p = p.up;

            Node<T> e = new Node<T>(k, null);//只保存key就ok
            this.backLink(p, e);//将e插入到p的后面
            this.verticalLink(e, q);//将e和q上下连接
            q = e;
            currentLevel++;
        }
        this.nodes++;//层数递增
    }

    /** node1后面插入node2 */
    private void backLink(Node<T> node1, Node<T> node2) {
        node2.left = node1;
        node2.right = node1.right;
        node1.right.left = node2;
        node1.right = node2;
    }

    /** 水平双向连接 */
    private void horizontalLink(Node<T> node1, Node<T> node2) {
        node1.right = node2;
        node2.left = node1;
    }

    /** 垂直双向连接 */
    private void verticalLink(Node<T> node1, Node<T> node2) {
        node1.down = node2;
        node2.up = node1;
    }

    /** 打印出原始数据 */
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "跳跃表为空！";
        }
        StringBuilder sbd = new StringBuilder();
        Node<T> p = head;
        while (null != p.down) {
            p = p.down;
        }
        while (null != p.left) {
            p = p.left;
        }
        if (null != p.right) {
            p = p.right;
        }
        while (null != p.right) {
            sbd.append(p).append("\n");
            p = p.right;
        }
        return sbd.toString();
    }

}
