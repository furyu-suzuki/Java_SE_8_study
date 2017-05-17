/**
 * 【課題24】
 * Pair<T>に対するflatMapメソッドを定義することができますか。
 * できるとしたら、それは何ですか。
 * できないとしたら、その理由は何ですか。
 *
 * 【回答】
 * できない。
 * Pairは必ず2つの要素だけを持つため。
 * 無理に実現するのであれば、PairにArrayListを入れ、それをstreamに変換し、Stream.flatMapを用いれば可能である。
 * しかしflatMap自体を実装することが課題であるため、flatMapを使ってしまっては本末転倒である。
 */
package chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaPrograming24 {
    public static void main(String[] args) {

        // -- 案1 -- //
        // ArrayListを渡して、それをflatMapする
//        ArrayList first = new ArrayList(){{add(1); add(2); add(3);}};
//        ArrayList second = new ArrayList(){{add(9); add(8); add(7);}};
//
//        Pair3<ArrayList> pair = new Pair3<>(first, second);
//
//        BiFunction<ArrayList, ArrayList, Stream<String>> mapper = (x, y) -> {
//            Object[] obj1 = x.stream().peek(a -> a.toString()).toArray();
//            Object[] obj2 = y.stream().peek(a -> a.toString()).toArray();
//            List<Object[]> objs = Arrays.asList( obj1, obj2 );
//            Stream<String> result = objs.stream().flatMap( a -> Arrays.stream(a)).collect(Collectors.toList()); // flatMapを使ってならとりあえずできそうである。でも本末転倒。
//            return result;
//        };
//        Stream<String> result = pair.flatMap(mapper);
//        result.forEach(System.out::println);

        // -- 案2 -- //
        // ArrayList じゃないものを渡してflatMapする
        Pair3<Integer> pair = new Pair3<>(123, 654);

        BiFunction<Integer, Integer, Stream<String>> mapper = (x, y) -> {
            Stream<String> result = Stream.of( pair.first.toString(), pair.second.toString() );
            return result;
        };
        Stream<String> result = pair.flatMap(mapper);
        result.forEach(System.out::println);

    }
}


class Pair3<T> extends Pair<T> {
    public Pair3(T first, T second) {
        super(first, second);
    }

    public <R> Stream<R> flatMap(BiFunction<T, T, Stream<R>> mapper){
        return mapper.apply(first, second);
    }

    public <R> Pair<R> map2(Function<Pair<T>, Pair<R>> mapper) {
        return mapper.apply( Pair.of(first, second) );
    }
}