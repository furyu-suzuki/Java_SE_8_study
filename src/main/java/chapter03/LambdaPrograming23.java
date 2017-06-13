/**
 * 【課題23】
 * T型の対となる2つのオブジェクトを表すPair<T>クラスに対するmap操作を定義しなさい。
 */
package chapter03;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaPrograming23 {
    public static void main(String[] args) {
        Integer first = 123456;
        Integer second = 987654;

        Pair2<Integer> pair = new Pair2<>(first, second);

        // -- 方法1 -- //
        BiFunction<Integer, Integer, String> mapper = (x, y) -> {
            x = x * 2;
            y = y * 2;
            return x.toString() + " " + y.toString();
        };
        String result = pair.map(mapper);
        System.out.println(result);

        // -- 方法2 -- //
        BiFunction<Integer, Integer, Pair<String>> mapper2 = (x, y) -> {
            x = x * 2;
            y = y * 2;
            return Pair.of(x.toString(), y.toString());
        };
        Pair<String> result2 = pair.map2(mapper2);
        System.out.println(pair.first + " -> " + result2.first);
        System.out.println(pair.second + " -> " + result2.second);
    }
}

class Pair2<T> extends Pair<T> {
    public Pair2(T first, T second) {
        super(first, second);
    }

    // -- 方法1 -- //
    public <R> R map(BiFunction<T, T, R> mapper) {
        return mapper.apply(first, second);
    }

    // -- 方法2 -- //
    public <R> Pair<R> map2(BiFunction<T, T, Pair<R>> mapper) {
        return mapper.apply(first, second);
    }
}


