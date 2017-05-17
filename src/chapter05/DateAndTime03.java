/**
 * 【課題03】
 * Predicate<LocalDate>を受け取り、TemporalAdjusterを返すnextメソッドを実装しなさい。
 * 返されたTemporalAdjusterはnextメソッドに渡された述語を満足する翌日の日付を生成します。
 * たとえば、次のコードを見てください。
 * today.with(next(w -> getDayOfWeek().getValue() < 6))
 * このコードは、今日よりあとにあって平日となる最初の日付を返します。
 *
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
        LocalDate date = LocalDate.of(2017, 05, 17);

        Predicate<LocalDate> pre = x -> x.getDayOfWeek() != DayOfWeek.FRIDAY; //ここ

        LocalDate result = date.with(next(pre));
        System.out.println(result);
    }

    public static TemporalAdjuster next(Predicate<LocalDate> pre) {
        LocalDate x = LocalDate.of(2017, 3, 3);

        do {
            x = x.plusDays(1);
        } while (pre.test(x));

        return TemporalAdjusters.nextOrSame(x.getDayOfWeek());
    }
}
