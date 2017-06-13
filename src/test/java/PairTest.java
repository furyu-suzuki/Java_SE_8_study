/**
 * JUnitとMavenの勉強で作成。
 * main.chapter03.Pairクラスのテストをするもの。
 *
 * -> 返り値も副作用もないmainはテストにかなり難があるので諦める
 */

import chapter03.Pair;
import org.junit.Test;

public class PairTest {
    @Test
    public void 同じ型のものを渡すとPairを生成できる() throws Exception {
        // 準備
        String first = "first";
        String second = "second";
        // メソッド実行
        Pair actual = Pair.of(first, second);
    }

    @Test
    public void Pair生成時の宣言と同じ型のものを渡すとPairを生成できる() throws Exception {
        // 準備
        String first = "first";
        String second = "second";
        // メソッド実行
        Pair<String> actual = Pair.of(first, second);
    }

    @Test(expected = Exception.class)
    //@Test(expected = InputMismatchException.class)
    //@Test
    public void 異なる型を引数に渡すとErrorを出す() throws Exception {
        // 準備
        Integer first = 123;
        Boolean second = false;
        // メソッド実行
        Pair actual = Pair.of(first, second);
        // -> Pairの宣言で型を指定しない場合は異なる型を引数として渡してもPairを生成できる
        // そのため、このテスト内容ではエラーを起こさず、テスト失敗となる
    }
}
