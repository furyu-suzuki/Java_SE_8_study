/**
 * 【課題07】
 * （指定された日付の午前10時から午前11時といった）カレンダーイベントに適した、
 * 時刻のインターバルを表すTimeIntervalクラスを実装しなさい。
 * 2つのインターバルが重なっているかを検査するメソッドを提供しなさい。
 */
package chapter05;

import java.time.*;
import java.util.Scanner;

import static chapter05.TimeInterval.isDoubleBooking;

public class DateAndTime07 {
    public static void main(String[] args) {
        // 一つ目のイベント（コマンドプロンプトから入力した日時を用いる）
        System.out.print("予定の開始日時と終了日時をそれぞれyyyy MM dd hh mmで入力 -> ");
        Scanner scan = new Scanner(System.in);
        LocalDateTime startA = LocalDateTime.of(
                LocalDate.of(Integer.parseInt(scan.next()), Integer.parseInt(scan.next()), Integer.parseInt(scan.next())),
                LocalTime.of(Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
        LocalDateTime endA = LocalDateTime.of(
                LocalDate.of(Integer.parseInt(scan.next()), Integer.parseInt(scan.next()), Integer.parseInt(scan.next())),
                LocalTime.of(Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
        TimeInterval intervalA = new TimeInterval(startA, endA);

        // 二つ目のイベント
        LocalDateTime startB = LocalDateTime.of(
                LocalDate.of(2017, 05, 18),
                LocalTime.of(11, 30));
        LocalDateTime endB = LocalDateTime.of(
                LocalDate.of(2017, 05, 18),
                LocalTime.of(11, 40));
        TimeInterval intervalB = new TimeInterval(startB, endB);

        boolean result = isDoubleBooking(intervalA, intervalB);
        if (result) {
            System.out.println("予定が重なっています");
        } else {
            System.out.println("問題ありません");
        }
    }
}

class TimeInterval {
    LocalDateTime start;
    LocalDateTime end;

    public TimeInterval(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public static boolean isDoubleBooking(TimeInterval first, TimeInterval second) {
        boolean result = false;

        if ((second.start.isAfter(first.start) && second.start.isBefore(first.end)) ||
                (second.end.isAfter(first.start) && second.end.isBefore(first.end)))
            result = true;

        return result;
    }
}
