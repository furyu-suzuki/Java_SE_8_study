/**
 * 【課題3】
 * Java1.4は予約語assertでもって、Java言語にアサーションを追加しました。
 * なぜ、アサーションはライブラリの機能として提供されなかったのでしょうか。
 * Java8ではライブラリの機能として実装することができますか。
 *
 * 【回答】
 * アサーションは主にデバッグで用いるので、アサーションで記した処理が不要である際にはメインのプログラムには作用しないようにするため。
 *
 * 【Oracle Java Documentationにあった回答】
 * なぜアサーションの実装に、ライブラリの変更ではなく、言語の変更を採用したのですか。
 * 言語の変更は、多くの工数を必要とし、簡単に行うことはできません。ライブラリを使用した方法も考慮しました。しかし、アサーションを無効にした場合は、そのランタイム・コストはごくわずかでなければならないと考えられています。ライブラリを採用した場合、ランタイム・コストを抑えるには、各アサーションをif文としてハードコードしなければなりません。多くのプログラマは、この方法は選択しないでしょう。if文を記述しないでパフォーマンスを犠牲にするか、アサーションをまったく行わないかでしょう。実は、James Goslinが最初に開発したJavaプログラミング言語の仕様には、アサーションが組み込まれていました。しかし、時間の制約により満足のいく設計と実装を行うことができなかったため、Oak仕様からは削除されました。
 */
package chapter03;

import java.util.stream.Stream;

public class LambdaPrograming03 {
    public static void main( String[] args ){
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 0, 0, 1, 0, -8, 6, 4);

        numbers.forEach( a -> {
                    if (a == 0) {
                        System.out.println("いけたばあい");
                    } else {
                        assert a > 0 : "a=" + a;
                    }
                }
        );

    }
}
