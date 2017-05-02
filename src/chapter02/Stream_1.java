/**
 * 【課題1】
 * 28ページの2.1節「イテレーションからストリーム操作へ」のforループの並列バージョンを書きなさい。
 * リストのセグメントごとに処理を行う別々のスレッドを多数生成し、処理が終わるごとに結果を合計するようにしなさい（みなさんは、単一カウンターを更新するためにスレッドを使用したくないでしょう。なぜですか。）。
 *
 * 【回答】
 * 一つの変数を並列で更新するため、処理が実行される順序によって最終結果が異なる。
 * よって実行するたびに答えが変わり、どれも誤りである可能性が高い。
 * そのため単一カウンターの更新にスレッドを使用するのは望ましくない。
 */
package chapter02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream_1 {
    static long count=0;
    public static void main( String[] args ) throws IOException {
        /* // --- 28ページ2.1節のコード --- //
        String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));  // [\P{L}]+ = 文字じゃないもの
        int count = 0;
        for ( String w : words ){
            if ( w.length() > 12 ) count++;
        }*/

        // --- 回答 --- //
        String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);

        /*  // --- 2.1節のコードをそのままstreamに変換したバージョン --- //
        Stream<String> words = Stream.of( contents.split("[\\P{L}]+") );
        long count = words.parallel().filter( w -> w.length() > 12 ).count();
        */

        //改行が2つ続くところで分ける
        List<String> segments = Arrays.asList( contents.split("\r\n\r\n") );
        // 段落ごとに12文字を超える単語数を数えてcountに加算
        segments.parallelStream().forEach( s -> count += Stream.of( s.split("[\\P{L}]+") ).parallel().filter( w -> w.length() > 12 ).count() );

        System.out.print( count );
    }
}
