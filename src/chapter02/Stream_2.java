/**
 * 【課題2】
 * ある文字数以上の長い単語のうち最初の5個だけを求める処理において、
 * 5番目の長い単語が一旦見つかったら、filterメソッドが呼び出されないことを検討しなさい。
 * 単純に、各メソッドの呼び出しでログを出せば良いです。
 */
package chapter02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Stream_2 {
    public static void main(String[] args) throws IOException {
        String contents = new String(
                Files.readAllBytes(Paths.get("C:/Users/0FR117008/IdeaProjects/SE8study/src/chapter02/alice.txt")),
                StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split("[\\P{L}]+"));
        System.out.println(
                words.filter(
                    w -> { if(w.length() > 12){System.out.println("word : " + w);}
                    return (w.length() > 12);}
                ).limit(5).count()
        );
        // .parallelにすると、5個以上でてくる。しないと5個だけでてくる。
        /*
        System.out.println(
                words.parallel().filter(
                        w -> { if(w.length() > 12){System.out.println("word : " + w);}
                            return (w.length() > 12);}
                ).limit(5).count()
        );
        */
    }
}
