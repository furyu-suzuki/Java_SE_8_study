/**
 * 【課題4】
 * 配列 int[] values = {1, 4, 9, 16}があるとします。
 * Stream.of(values) は、何になるでしょうか。
 * 代わりに、intのストリームをどうやって取得できるでしょうか。
 * <p>
 * 【回答】
 * Stream.of(values) は、型の指定がないストリームになる。
 * intのストリームを取得するには (Stream<Integer>) IntStream.of( values ) とする。
 */
package chapter02;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_4 {
    public static void main(String[] args) {
        int[] values = {1, 4, 9, 16};
        Stream.of(values);
        //Stream<Integer> hoge = (Stream<Integer>) IntStream.of(values);
    }
}
