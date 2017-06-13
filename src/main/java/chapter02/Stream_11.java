/**
 * 【課題11】
 * 単一のArrayListがストリームの大きさと同じ大きさで生成されている場合、
 * 複数のArrayListをマージすることなく、その単一のArrayListにストリームの結果を並行して収集できるはずです。
 * なぜなら、互いに異なる位置へ並行して行なうset操作であれば、スレッドセーフとなるからです。
 * みなさんはこの収集をどうやって達成することができますか。
 * <p>
 * 【メモ】
 * forEachの中でiをインクリメントすると、並列操作中に同じ要素を参照する事が起きるため、
 * AtomicIntegerを用いてみた。
 */
package chapter02;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Stream_11 {
    public static void main(String[] args) {
        Stream<String> names = Stream.of("suzuki", "yamamoto", "kato", "tanaka", "kenken", "hogehoge", "pogepoge");
        ArrayList<String> copy = new ArrayList<String>() {{
            add("aaa");
            add("bbb");
            add("ccc");
            add("ddd");
            add("eee");
            add("fff");
            add("ggg");
        }};

        AtomicInteger i = new AtomicInteger();
        names.parallel().forEach((name) -> copy.set(i.getAndIncrement(), name));
        System.out.print(copy);
    }
}
