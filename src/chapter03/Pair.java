/**
 * 課題23のために、Pair<T>を実現するクラス
 */
package chapter03;

public class Pair<T>{
    T first;
    T second;

    public Pair( T first, T second ){
        this.first = first;
        this.second = second;
    }

    public static <U> Pair<U> of(U first, U second){
        return new Pair<>(first, second);
    }
}