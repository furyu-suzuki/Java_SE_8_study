/**
 * 【課題03】
 * Predicate<LocalDate>を受け取り、TemporalAdjusterを返すnextメソッドを実装しなさい。
 * 返されたTemporalAdjusterはnextメソッドに渡された述語を満足する翌日の日付を生成します。
 * たとえば、次のコードを見てください。
 * today.with(next(w -> getDayOfWeek().getValue() < 6))
 * このコードは、今日よりあとにあって平日となる最初の日付を返します。
 * <p>
 * 【メモ】
 * do-while文で1日ずつ判断するバージョンならばできたのだけれど、
 * よりシンプルというか、かっちょよく実現する方法はないのだろうか。
 */
package chapter05;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class DateAndTime03 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        // date以降の直近の金曜日を探す
        Predicate<LocalDate> pre = x -> x.getDayOfWeek() == DayOfWeek.FRIDAY;

        System.out.println(date.with(next(pre, date)) + "が次の金曜日だ!!!");
    }

    static TemporalAdjuster next(Predicate<LocalDate> pre, LocalDate date) {
        // 日付(date)を渡さないようにするならば、何かしらLocalDateをここで用意する
        do {
            date = date.plusDays(1);
        } while (pre.test(date) != true);  //条件を満たすまで探すよ

        return TemporalAdjusters.nextOrSame(date.getDayOfWeek());
    }
}
