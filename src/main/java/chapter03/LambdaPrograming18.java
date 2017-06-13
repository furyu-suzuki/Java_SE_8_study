/**
 * 【課題18】
 * 71ページの3.8節「例外の取扱い」のuncheckedメソッドを次の内容に従って実装しなさい。
 * 具体的にはチェックされる例外をスローするラムダ式から、Function<T, U>を生成するようにしなさい。
 * 任意の例外をスローする抽象メソッドを持つ関数型インタフェースを見つけるか、作成する必要があることに注意しなさい。
 */
package chapter03;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaPrograming18 {
    public static void main(String[] args) {
        System.out.print(
                unchecked(() -> new String(
                        Files.readAllBytes(Paths.get("../chapter02/alice.txt")), StandardCharsets.UTF_8
                )).apply(null)
                // このまま実行すると、NullPointerExceptionが起きる
                // .apply("hoge")とすると、hogeが出力される
        );
    }


    //    public static <T, U> Function<T, U> unchecked(Callable<T> f){
    public static <T> Function<T, String> unchecked(Callable<T> f) {
        return (x) -> {
            try {
                f.call();
                return x.toString();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } catch (Throwable t) {
                throw t;
            }
        };
    }

    // -- 3.8節にあったそのままのuncheckedメソッド -- //
//    public static <T> Supplier<T> unchecked(Callable<T> f){
//        return () -> {
//          try{
//              return f.call();
//          }catch ( Exception e ){
//              throw new RuntimeException(e);
//          } catch (Throwable t){
//              throw t;
//          }
//        };
//    }
}
