/**
 * 【課題6】
 * 31ページの2.3節「filter, map, flatMapメソッド」のcharacterStreamメソッドは、
 * 最初にArrayListを埋めてそのリストをストリームに変換するという具合に、少しぎこちないです。
 * 代わりに、ストリームを使用して1行で書きなさい。
 * 適切な方法は、0からs.length()-1までの整数のストリームを生成して、
 * それをs::charAtメソッド参照でマップすることです。
 * <p>
 * 【メモ】
 * 実現できたけれど、指示通りに整数のストリームを0からs.length()-1までとすると、
 * 処理する文字列から1文字ずつかけてしまい、例のソースコードと実行結果が異なる。
 */
package chapter02;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_6 {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("hoge", "keme", "page");
        Stream<Character> letters = words.flatMap(s -> IntStream.range(0, s.length()).boxed().map(s::charAt));
        letters.forEach(System.out::print);
    }

    /* // 31ページ2.3節のコード
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<String>(Arrays.asList("hoge", "keme", "page") );
        Stream<String> words = wordList.stream();
        Stream<Character> letters = words.flatMap( w -> characterStream(w) );
        letters.forEach(System.out::print);
    }

    public static Stream<Character> characterStream( String s ){
        List<Character> result = new ArrayList<>();
        for( char c : s.toCharArray() )
            result.add(c);
        return result.stream();
    }*/
}
