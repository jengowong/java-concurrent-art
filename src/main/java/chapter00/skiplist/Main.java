package chapter00.skiplist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jengowang
 * @since 2018-03-02
 */
public class Main {

    public static void main(String[] args) {
        SkipList<String> list = new SkipList<String>();
        //System.out.println(list);
        list.put(2, "yan");
        list.put(1, "co");
        list.put(3, "feng");
        list.put(1, "cao");//测试同一个key值
        list.put(4, "曹");
        list.put(6, "丰");
        list.put(5, "艳");
        System.out.println(list);
        System.out.println(list.size());


        String test = new String("test1");
        alter(test);
        System.out.println(test);

        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        System.out.println(intList);
        alter(intList);
        System.out.println(intList);
    }


    public static void alter(String test) {
        test = new String("test2");
    }

    public static void alter(List<Integer> list) {
        list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
    }
}
