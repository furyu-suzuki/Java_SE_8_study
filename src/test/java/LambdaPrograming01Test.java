/**
 * 2017/06/13.
 * JUnitとMavenの勉強で作成。
 * main.chapter03.Pairクラスのテストをするもの。
 */
import chapter03.LambdaPrograming01;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LambdaPrograming01Test {
    @Test
    public void mainをそのまま実行する(){
        //準備
        LambdaPrograming01 lambdaProg01 = new LambdaPrograming01();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //メソッド実行
        lambdaProg01.main(null);
        //評価
        assertThat(out.toString(), is(""));
    }
}
