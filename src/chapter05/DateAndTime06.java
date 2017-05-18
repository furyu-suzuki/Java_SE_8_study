/**
 * 【課題06】
 * 20世紀の全ての13日の金曜日を列挙しなさい。
 *
 * 【メモ】
 * ループを2重でまわす方法で実現したけれども、あんまりかっこよくない。
 * 調べた限り、java.timeに特定の日～特定の日の期間を保持するものとか
 * 条件でその期間から検索をかけるメソッドとか、都合のいいものが無さそうなので、
 * これ以上はシンプルにできないのかもしれない。
 */
package chapter05;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DateAndTime06 {
    public static void main(String[] args) {
        friday13(20).stream().forEach(System.out::println);
        System.out.println(" ---");
        friday13_2(20).stream().forEach(System.out::println);
    }

    //指定の世紀における13日の金曜日を取得してくれるメソッド
    static List<LocalDate> friday13(int century) {
        List<LocalDate> list = new ArrayList<>();

        //地道にループを回す案
        for (int year = century * 100; year < (century + 1) * 100; year++) {
            for (int month = 1; month <= 12; month++) {
                LocalDate date = LocalDate.of(year, month, 13);
                if (date.getDayOfWeek() == DayOfWeek.FRIDAY) list.add(date);
            }
        }
        return list;
    }

    //指定の世紀における13日の金曜日を取得してくれるメソッド ver.2
    static List<LocalDate> friday13_2(int century) {
        List<LocalDate> list = new ArrayList<>();
        LocalDate lastDay = LocalDate.ofYearDay((century + 1) * 100, 365);

        LocalDate date = LocalDate.ofYearDay(century * 100, 1);
        int year = century * 100;
        do {
            for (int month = 1; month <= 12; month++) {
                date = LocalDate.of(year, month, 13);
                if (date.getDayOfWeek() == DayOfWeek.FRIDAY) list.add(date);
            }
            year++;
        } while (ChronoUnit.DAYS.between(date, lastDay) > 0);
        return list;
    }
}
