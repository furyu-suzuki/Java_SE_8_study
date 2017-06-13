/**
 * 【課題9】
 * Stream<ArrayList<T>>内のすべての要素をまとめて1つのArrayList<T>にしなさい。
 * 具体的には3つの形式のreduceを用いる方法を示しなさい。
 */
package chapter02;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream_9 {
    public static void main(String[] args) {
        ArrayList<Integer> list_1 = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        ArrayList<Integer> list_2 = new ArrayList<Integer>() {{
            add(222);
            add(333);
            add(444);
            add(555);
        }};
        ArrayList<Integer> list_3 = new ArrayList<Integer>() {{
            add(91);
            add(81);
            add(71);
            add(61);
            add(51);
            add(41);
            add(31);
            add(21);
            add(11);
            add(99);
        }};
        ArrayList<Integer> list_4 = new ArrayList<Integer>() {{
            add(92);
            add(82);
            add(72);
            add(62);
            add(52);
            add(42);
            add(32);
            add(22);
            add(12);
            add(88);
            add(77);
        }};
        ArrayList<Integer> list_5 = new ArrayList<Integer>() {{
            add(93);
            add(83);
            add(73);
            add(63);
            add(53);
            add(43);
            add(33);
            add(23);
            add(13);
        }};

        // reduceその1
        Stream<ArrayList<Integer>> list_streamA = Stream.of(list_1, list_3, list_4);
        Optional<ArrayList<Integer>> reducedA = list_streamA.reduce((x, y) -> {
            x.addAll(y);
            return x;
        });
        System.out.println(reducedA);
        // reduceその2
        Stream<ArrayList<Integer>> list_streamB = Stream.of(list_1, list_3, list_4);
        ArrayList<Integer> reducedB = list_streamB.reduce(list_5, (x, y) -> {
            x.addAll(y);
            return x;
        });
        System.out.println(reducedB);
        // reduceその3
        Stream<ArrayList<Integer>> list_streamC = Stream.of(list_1, list_3, list_4);
        ArrayList<Integer> reducedC = list_streamC.reduce(list_2, (x, y) -> {
            x.addAll(y);
            return x;
        }, (m, n) -> {
            m.addAll(n);
            return m;
        });
        System.out.println(reducedC);
    }
}
