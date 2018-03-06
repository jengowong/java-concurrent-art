package chapter00.skiplist;

/**
 * https://www.jianshu.com/p/60d2561b821c
 *
 * 跳跃表的节点,包括key-value和上下左右4个指针
 */
public class SkipListNode<T> {

    /** 键 */
    public Integer key;
    /** 值 */
    public T value;
    /** 向上层节点的指针 */
    public SkipListNode<T> up;
    /** 向下层节点的指针 */
    public SkipListNode<T> down;
    /** 向左侧节点的指针 */
    public SkipListNode<T> left;
    /** 向右侧节点的指针 */
    public SkipListNode<T> right;

    /** 负无穷 */
    public static final int HEAD_KEY = Integer.MIN_VALUE;
    /** 正无穷 */
    public static final int TAIL_KEY = Integer.MAX_VALUE;

    public SkipListNode(int key, T value) {
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
        if (!(o instanceof SkipListNode<?>)) {
            return false;
        }
        SkipListNode<T> ent;
        try {
            ent = (SkipListNode<T>) o;
        } catch (ClassCastException e) {
            return false;
        }
        return this.key.equals(ent.getKey())
                && this.value.equals(ent.getValue());
    }

    @Override
    public String toString() {
        return "key-value:" + key + "-" + value;
    }

}
