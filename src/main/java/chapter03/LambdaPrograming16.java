/**
 * 【課題16】
 * 71ページの3.8節「例外の取扱」のdoInOrderAsyncを実装し、2つ目のパラメータはBiConsumer<T, Throwable>としなさい。
 * うまいユースケースを示しなさい。3つ目のパラメータは必要ですか。
 * <p>
 * 【回答】
 * 1目のSupplierが挙げる例外は2つ目のSupplierが受け取って処理するため、3つ目のパラメータは必要ではない。
 * 指定した処理中に例外が発生した場合に、別の処理を実行する必要がある場合に有効である。
 */
package chapter03;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class LambdaPrograming16 {
    public static void main(String[] args) {
        Supplier<String> first = () -> "hoge";
        BiConsumer<String, Throwable> second = (x, y) -> System.out.println(x);
        doInOrderAsync(first, second);
    }

    public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
        Thread t = new Thread(() -> {
            T result = null;
            try {
                result = first.get();
            } catch (Throwable e) {
                second.accept(result, e);
            }
        });
        t.start();
    }
}
