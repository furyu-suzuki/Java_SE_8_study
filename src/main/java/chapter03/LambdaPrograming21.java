/**
 * 【課題21】
 * staticメソッドである<T, U> Future<U> map(Future<T>, Function<T, U>)を提供しなさい。
 * Futureインタフェースの全てのメソッドを実装した無名クラスのオブジェクトを返しなさい。
 * getメソッドで、関数を呼び出しなさい。
 */
package chapter03;

import java.util.concurrent.*;
import java.util.function.Function;

public class LambdaPrograming21 {
    public static void main(String[] args) {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);
        Function<Integer, String> function = (x) -> x.toString();

        Future<String> result = map(future, function);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }

    static <T, U> Future<U> map(Future<T> future, Function<T, U> function) {
        U str = null;
        try {
            str = function.apply(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        U finalStr = str;
        return
                new Future<U>() {
                    @Override
                    public boolean cancel(boolean mayInterruptIfRunning) {
                        return false;
                    }

                    @Override
                    public boolean isCancelled() {
                        return false;
                    }

                    @Override
                    public boolean isDone() {
                        return false;
                    }

                    @Override
                    public U get() throws InterruptedException, ExecutionException {
                        return finalStr;
                    }

                    @Override
                    public U get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                        return null;
                    }
                };
    }
}
