/**
 * 【課題8】
 * public static<T> Stream<T> zip(Stream<T> first, Stream<T> second)メソッドを作成しなさい。
 * そのメソッドは、ストリームであるfirstとsecondから要素を交互に取り出し、
 * どちらかのストリームから要素がなくなったら停止します。
 * <p>
 * 【メモ】
 * ひとまずListに変換して処理できるようにしたけれども、ストリームを使って実現する方法が浮かばない。
 * -> じょんさんと相談の結果、諦めて答えを見ましょうとなった。
 */
package chapter02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.*;

public class Stream_8 {
    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(2, 3, 4, 5, 6);
        Stream<Integer> second = Stream.of(9, 9, 9, 9, 8, 8, 8, 8);
        Stream<Tuple2> result = zip_2(first, second);
        result.forEach(r -> System.out.println(r.car.toString() + " " + r.cdr.toString()));
    }

    // --- とりあえずListに変換してできるバージョン --- //
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> ziped = new ArrayList<>();
        List<T> FIRST = first.collect(Collectors.toList());
        List<T> SECOND = second.collect(Collectors.toList());
        int limit;

        if (FIRST.size() > SECOND.size()) {
            limit = SECOND.size();
        } else {
            limit = FIRST.size();
        }

        for (int i = 0; i < limit; i++) {
            ziped.add(FIRST.get(i));
            ziped.add(SECOND.get(i));
        }

        return ziped.stream();
    }

    // -- 答え（https://gist.github.com/kjkrol/51a5a7612f0411849c62,
    // http://qiita.com/KIchiro/items/e63d91d5a61069c0278b より） -- //
    public static <T> Stream<Tuple2> zip_2(Stream<T> first, Stream<T> second) {
//        Tuple2<T, T> tpl4_1 = new Tuple2<>(a, b);
        BiFunction<T, T, Tuple2> zipped = (a, b) -> new Tuple2<T, T>(a, b);
//        BiFunction<T, T, T> zipped = (a, b) -> new SimpleEntry<>(a, b);
        Iterator<T> FIRST = first.iterator();
        Iterator<T> SECOND = second.iterator();
        Iterator<Tuple2> ZIPPED = new Iterator<Tuple2>() {
            @Override
            public boolean hasNext() {
                return FIRST.hasNext() && SECOND.hasNext();
            }

            @Override
            public Tuple2 next() {
                return zipped.apply(FIRST.next(), SECOND.next());
            }
        };
        boolean parallel = first.isParallel() || second.isParallel();
        Iterable<Tuple2> iterable = () -> ZIPPED;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }

    public static class Pair<A, B> {
        public final A car;
        public final B cdr;

        public Pair(A car_, B cdr_) {
            car = car_;
            cdr = cdr_;
        }

        private static boolean eq(Object o1, Object o2) {
            return o1 == null ? o2 == null : o1.equals(o2);
        }

        private static int hc(Object o) {
            return o == null ? 0 : o.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair<?, ?> rhs = (Pair<?, ?>) o;
            return eq(car, rhs.car) && eq(cdr, rhs.cdr);
        }

        @Override
        public int hashCode() {
            return hc(car) ^ hc(cdr);
        }
    }

    public static class Tuple1<A> extends Pair<A, Object> {
        public Tuple1(A a) {
            super(a, null);
        }
    }

    public static class Tuple2<A, B> extends Pair<A, Tuple1<B>> {
        public Tuple2(A a, B b) {
            super(a, new Tuple1<>(b));
        }
    }

}
