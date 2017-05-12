/**
 * 【課題1】
 * 条件的なロギングを強化することで、遅延ロギング技法を強化しなさい。
 * 典型的な呼び出しは、logIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10])となります。
 * ロガーがメッセージをロギングしないのであれば、その条件を評価しないようにしなさい。
 *
 * 【メモ】
 * 思っていたことはできたが、ロガーのレベルをINFO未満のものにすると、
 * logger.setLevel(ALL)としてもログが出力されない。
 *  -> StreamHandlerにもsetLevelすることが必要。
 */
package chapter03;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class LambdaPrograming01 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("example");
        int i = 10;
        String[] a = new String[13];
        a[10] = " message ";

        // ログを標準出力に出力するようにする
        logger.addHandler(new StreamHandler() {
            {
                setOutputStream(System.out);
                setLevel(Level.ALL);
            }
        });
        logger.setUseParentHandlers(false);

        logger.setLevel(Level.ALL);
        logIf(logger, Level.FINER, () -> i == 10, () -> "a[10] = " + a[10]);
    }

    // -- 本にもともとあったロギングの例 -- //
    // logger.info( () -> "x: " + x + ", y: " + y ); で呼び出し
    // public static void info(Logger logger, Supplier<String> message){
    //      if (logger.isLoggable(Level.INFO))
    //          logger.info(message.get());
    //  }

    public static void logIf(Logger logger, Level level, Supplier<Boolean> condition, Supplier<String> message) {
        if (logger.isLoggable(level)) {
            if (message.get() != null) {
                logger.log(level, message.get());
                condition.get();
            }
        }
    }
}
