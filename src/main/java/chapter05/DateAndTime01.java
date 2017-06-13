/**
 * 【課題01】
 * plusDaysを使用しないで、プログラマーの日（1年の256日目）を計算しなさい。
 */
package chapter05;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateAndTime01 {
    public static void main(String[] args) {
//        Duration diff = Duration.ofDays(255);
        LocalDate programmersDay = LocalDate.of(2017, 1, 1).plus(255, ChronoUnit.DAYS);
        System.out.println("2017年のプログラマの日 = " + programmersDay);

        System.out.println("プログラマの日-2017/1/1 = " + LocalDate.of(2017, 1, 1).until(programmersDay, ChronoUnit.DAYS));
    }
}
