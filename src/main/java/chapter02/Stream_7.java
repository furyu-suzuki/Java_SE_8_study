/**
 * 【課題7】
 * 上司がメソッドとしてpublic static<T> boolean isFinite(Stream<T> stream)を作成するように求めています。
 * それは良くない考えでしょうか。作成してから、考えなさい。
 * <p>
 * 【回答】
 * 良くない考えである。
 * 無限ストリームを渡してしまった場合、無限ストリームの処理が止まらないと無限ストリームかどうかを判定できない。
 * そのためいつまでも判定処理ができず、目的を果たすことができなくなる。
 */
package chapter02;

import java.util.stream.Stream;

public class Stream_7 extends Stream_5 {
    public static void main(String[] args) {
        long a = 2521490391L;
        long c = 11;
        long m = 2 ^ 48;
        long seed = 618;
        // 有限のストリームを生成して渡してみる
        Stream<String> hoge = Stream.of("hoge", "keme", "page");
        System.out.println(isFinite(hoge));
        // 課題5で作成した無限ストリームを渡してみる
        Stream<Long> random = LCGs(a, c, m, seed);
        System.out.println(isFinite(random));
    }

    public static <T> boolean isFinite(Stream<T> stream) {
        boolean answer;
        if (stream.toArray().length >= 0) {
            answer = false;
        } else {
            answer = true;
        }
        return answer;
    }
}
