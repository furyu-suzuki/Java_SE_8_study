/**
 * 【課題10】
 * Stream<Double>の平均を計算するために利用できるreduceの呼び出しを書きなさい。
 * 単純に合計を計算してcount()で割ることができないのはなぜですか。
 * <p>
 * 【回答】
 * reduceは終端操作であり、reduceを呼び出した後から同じストリームを扱うことができないため。
 * またreduceは要素を一つずつ取り出して指定した処理を行なうものなので、reduce内で平均を算出したり、要素数を数えることはできない。
 */
package chapter02;

import java.util.stream.Stream;

public class Stream_10 {
    public static void main(String[] args) {
        Stream<Double> dstream = Stream.of(12345.67, 56789.89, 65656.36, 98798.12);
        final int[] count = {0};
        double sum = dstream.peek(e -> count[0]++).reduce((x, y) -> x + y).get();
        System.out.println(sum / (double) count[0]);
    }
}
