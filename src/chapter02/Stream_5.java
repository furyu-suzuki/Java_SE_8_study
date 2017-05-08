/**
 * 【課題5】
 * Stream.iterate を使用して乱数の無限ストリームを生成しなさい。
 * このとき、Math.randomを使用するのではなく、線形合成生成機(linear congruential generator)を直接実行すること。
 * そのような生成機ではx[0]=seedで始めて、a,c,mの適切な値に対して、x[n+1]=(ax[n]+c)%mを生成します。
 * パラメータa,c,m,seedを受け取ってStream<Long>を生成するメソッドを実装しなさい。
 * a=25214903917, c=11, m=2^48を試しなさい。
 */
package chapter02;

import java.util.stream.Stream;

public class Stream_5 {

    public static void main(String[] args) {
        long a = 2521490391L;
        long c = 11;
        long m = 2 ^ 48;
        long seed = 618;
        Stream<Long> random = LCGs(a, c, m, seed);
        random.forEach(System.out::println);
    }

    public static Stream<Long> LCGs(long a, long c, long m, long seed) {
        return Stream.iterate(seed, s -> (a * s + c) % m);
    }
}
