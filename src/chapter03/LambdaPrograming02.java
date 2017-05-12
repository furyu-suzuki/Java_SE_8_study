/**
 * 【課題2】
 * ReentrantLockを使用する場合には、次のイデオムでロックとアンロックをする必要があります。
 * myLock.lock();
 * try{
 * 処理
 * }finally{
 * myLock.unlock();
 * }
 * 次のように呼び出すことができるwithLockメソッドを提供しなさい。
 * withLock(myLock, () -> {処理})
 */
package chapter03;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LambdaPrograming02 {
    private static ReentrantLock myLock = new ReentrantLock();

    public static void main(String[] args) {
        withLock(myLock, () -> "withLockを動かしたよ");

        // なにかStreamをparallelで動かす処理をやらせてみる
        Stream<String> names = Stream.of("suzuki", "saitou", "katou", "matsumura", "sasaki", "keme", "poge");
        names.parallel().forEach(name -> withLock(myLock, () -> name + " Lock!"));
    }

    public static void withLock(ReentrantLock myLock, Supplier<String> action) {
        myLock.lock();
        try {
            System.out.println(action.get());
        } finally {
            myLock.unlock();
        }
    }
}
