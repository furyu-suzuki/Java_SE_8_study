/**
 * 【課題12】
 * 127ページの5.5節「ゾーン付き時刻」の初めで説明した問題を解くプログラムを書きなさい。
 * そのプログラムでは、異なるタイムゾーンにある約束の集まりを読み込んで、
 * ローカル時刻で1時間前に約束があることをユーザーに通知するようにしなさい。
 * <p>
 * 【127ページ5.5節で説明した問題】
 * カレンダーアプリを作成する場合には、1つの国から別の国へ行き来する人を考慮しなくてはなりません。
 */
package chapter05;

import java.time.*;
import java.util.stream.Stream;

public class DateAndTime12 {
    public static void main(String[] args) {
        // 現在時刻を取得する
        ZonedDateTime nowTime = ZonedDateTime.of(
                LocalDate.now(),
                LocalTime.of(9, 00),
                ZoneId.of("Europe/Paris")
        );

        // 予定を生成する
        Stream<ZonedDateTime> list = getScheduleList();
        // どれかの予定が1時間後であれば知らせる
        if (list.anyMatch(s ->
                Duration.between(s, nowTime).equals(Duration.ofHours(-1))))
            System.out.println("1時間後に予定があります。");
        else
            System.out.println("1時間後は特に何もありません。");
    }

    //予定一覧をstreamで返すメソッド
    static Stream<ZonedDateTime> getScheduleList() {
        Stream<ZonedDateTime> list = Stream.of(
                ZonedDateTime.of(
                        LocalDate.now(),
                        LocalTime.of(14, 00),
                        ZoneId.of("Europe/Paris")
                ),
                ZonedDateTime.of(
                        LocalDate.now(),
                        LocalTime.of(15, 00),
                        //ロスの15時はパリの24時
                        ZoneId.of("America/Los_Angeles")
                ),
                ZonedDateTime.of(
                        LocalDate.now(),
                        LocalTime.of(8, 00),
                        //ロスの8時はパリの17時
                        ZoneId.of("America/Los_Angeles")
                ),
                ZonedDateTime.of(
                        LocalDate.now(),
                        LocalTime.of(17, 00),
                        ZoneId.of("Europe/Paris")
                ),
                ZonedDateTime.of(
                        LocalDate.now(),
                        LocalTime.of(10, 00),
                        ZoneId.of("Europe/Paris")
                ),
                ZonedDateTime.of(
                        LocalDate.now(),
                        LocalTime.of(11, 00),
                        ZoneId.of("UTC")
                )
        );
        return list;
    }
}
