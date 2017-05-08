/**
 * 【課題3】
 * streamではなく、parallelStreamで長い単語を数えた場合の速度の違いを計りなさい。
 * 呼び出しの前後でSystem.nanoTimeを呼び出して、差を表示しなさい。
 * 高速なコンピュータを持っているのであれば、（「戦争と平和」(War and Peace)などの）もっと大きなドキュメントで試しなさい。
 *
 * 【回答】
 * streamの場合 : 43744289, 39649562, 41575238, 47223065, 45742677 (平均 43586966)
 * parallelの場合 : 49996950, 88168529, 52300008, 51623063, 46043142 (平均 57626338)
 * parallelのほうが長い時間がかかる。
 * また処理がうまくいかなかった場合に、streamに比べて非常に長い時間がかかることがある。
 */
package chapter02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Stream_3 {
    public static void main(String[] args) throws IOException {
        String contents = new String(
                Files.readAllBytes(Paths.get("C:/Users/0FR117008/IdeaProjects/SE8study/src/chapter02/alice.txt")),
                StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split("[\\P{L}]+"));
        long startTime = System.nanoTime();
        System.out.println(
                words.parallel().filter(
                        w -> {
                            if (w.length() > 12) {
                                System.out.println("word : " + w);
                            }
                            return (w.length() > 12);
                        }
                ).limit(5).count()
        );
        System.out.println("かかった時間 : " + (System.nanoTime() - startTime));
    }
}
