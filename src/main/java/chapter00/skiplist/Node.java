package chapter00.skiplist;

/**
 * https://www.jianshu.com/p/60d2561b821c
 *
 * 跳跃表的节点,包括key-value和上下左右4个指针
 */
public class Node<T> {

    /** 键 */
    public Integer key;
    /** 值 */
    public T value;
    /** 向上层节点的指针 */
    public Node<T> up;
    /** 向下层节点的指针 */
    public Node<T> down;
    /** 向左侧节点的指针 */
    public Node<T> left;
    /** 向右侧节点的指针 */
    public Node<T> right;

    /** 负无穷 */
    public static final int HEAD_KEY = Integer.MIN_VALUE;
    /** 正无穷 */
    public static final int TAIL_KEY = Integer.MAX_VALUE;

    public Node(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (null == o) {
            return false;
        }
        if (!(o instanceof Node<?>)) {
            return false;
        }
        try {
            Node<T> ent = (Node<T>) o;
            return this.key.equals(ent.getKey()) && this.value.equals(ent.getValue());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "k-v:" + key + "-" + value;
    }

}
