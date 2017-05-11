/**
 * 【課題13】
 * 練習問題12に対して次の点を変更し、その問題を解きなさい。
 * 変更点として、短い文字列はフィルターで取り出し、Collectors.groupingByとCollectors.countingと一緒にcollectメソッドを使用しなさい。
 * <p>
 * 【メモ】
 * できたけれども、Map<Integer, Long> collectの中身からAtomicInteger[] shortWordsに移すのが賢くない感じである。
 */
package chapter02;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_13 {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("red", "blue", "white", "black", "suzuki", "yamamoto", "kato", "tanaka", "kenken", "hogehoge", "pogepoge", "a");
        // 0 1 0 1 2 2 3 0 3 0 0 0 となるのが正解
        AtomicInteger[] shortWords = new AtomicInteger[12];
        for (int i = 0; i < shortWords.length; i++)
            shortWords[i] = new AtomicInteger();

        AtomicInteger[] finalShortWords = shortWords;
        Stream<String> buf = words.parallel().filter(w -> w.length() < finalShortWords.length);
        Map<Integer, Long> collect = buf.collect(Collectors.groupingBy(w -> w.length(), Collectors.counting()));
        System.out.println(collect);

        for (int i = 0; i < shortWords.length; i++) {
            if (collect.get(i) != null) {
                for (int j = 0; j < collect.get(i); j++)
                    shortWords[i].getAndIncrement();
            }
        }

        Arrays.stream(shortWords).forEach(n -> System.out.print(n + " "));
    }
}