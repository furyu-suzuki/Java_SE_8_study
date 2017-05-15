/**
 * 【課題17】
 * firstとsecondを並列に実行し、どちらかのメソッドが例外をスローしたらhandlerを呼び出す
 * doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) を実装しなさい。
 */
package chapter03;

import java.util.function.Consumer;

public class LambdaPrograming17 {
    public static void main(String[] args) {
        Runnable first = () -> System.out.println("hoge");
        Runnable second = () -> System.out.println("keme");
        Consumer<Throwable> handler = aps -> {
            try {
                throw new Exception("---");
            } catch (final Exception ex) {
                System.out.println("handling an exception...");
            }
        };
        doInParallelAsync(first, second, handler);
    }

    static void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
        try {
            new Thread(first::run).start();
            new Thread(second::run).start();
        } catch (Throwable t) {
            handler.accept(t);
        }
    }
}
