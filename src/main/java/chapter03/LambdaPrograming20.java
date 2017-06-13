/**
 * 【課題20】
 * staticメソッドである <T, U> List<U> map(List<T>, Function<T, U>)を提供しなさい。
 */
package chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LambdaPrograming20 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Function<Integer, String> func = (x) -> x.toString();
        map(list, func).forEach(System.out::println);
    }

    static <T, U> List<U> map(List<T> list, Function<T, U> func) {
        List<U> newList = new ArrayList<U>();
        list.stream().parallel().forEach(t -> newList.add(func.apply(t)));
        return newList;
    }
}
