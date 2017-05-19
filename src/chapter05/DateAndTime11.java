/**
 * 【課題11】
 * 帰りの便は、フランクフルトを14時5分に出発し、ロサンジェルスに16時40分に到着します。
 * 飛行時間は、何時何分ですか。
 * このような計算を処理できるプログラムを書きなさい。
 */
package chapter05;

import java.time.*;

public class DateAndTime11 {
    public static void main(String[] args) {
        //発地点、着地点、発時刻、着時刻を渡す
        Duration result = getFlightTime(
                ZoneId.of("Europe/Paris"),
                ZoneId.of("America/Los_Angeles"),
                LocalTime.of(14, 5),
                LocalTime.of(16, 40));
        //結果を出す
        System.out.println("飛行時間: " + result);
    }

    public static Duration getFlightTime(ZoneId departurePoint, ZoneId arrivalPoint, LocalTime departureTime, LocalTime arrivalTime) {

        ZonedDateTime dpt = ZonedDateTime.of(
                LocalDate.now(),
                departureTime,
                departurePoint
        );
        ZonedDateTime arv = ZonedDateTime.of(
                LocalDate.now(),
                arrivalTime,
                arrivalPoint
        );

        Duration flightTime = Duration.between(
                arv, ZonedDateTime.ofInstant(dpt.toInstant(), arrivalPoint));

        return flightTime;
    }
}