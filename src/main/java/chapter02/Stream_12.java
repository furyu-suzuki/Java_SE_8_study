/**
 * 【課題12】
 * 51ページの2.13「並列ストリーム」で説明したように、AtomicIntegerの配列を更新することで、
 * 並列なStream<String>内の短い単語をすべて数えなさい。
 * 個々のカウントを安全に増やすためにアトミックであるgetAndIncrementメソッドを使用しなさい。
 */
package chapter02;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Stream_12 {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("red", "blue", "white", "black", "suzuki", "yamamoto", "kato", "tanaka", "kenken", "hogehoge", "pogepoge", "a");
        // 0 1 0 1 2 2 3 0 3 0 0 0 となるのが正解
        AtomicInteger[] shortWords = new AtomicInteger[12];
        for (int i = 0; i < 12; i++)
            shortWords[i] = new AtomicInteger();

        words.parallel().forEach(
                word -> {
                    if (word.length() < 12) shortWords[word.length()].getAndIncrement();
                }
        );
        Arrays.stream(shortWords).forEach(n -> System.out.print(n + " "));
    }
}
