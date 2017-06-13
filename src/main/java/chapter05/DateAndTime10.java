/**
 * 【課題10】
 * ロサンジェルスからフランクフルト行きの便は、ローカル時刻の3時5分に出発し、10時間50分の飛行です。
 * 何時に到着しますか。
 * このような計算を処理できるプログラムを書きなさい。
 */
package main.java.chapter05;

import java.time.*;

public class DateAndTime10 {
    public static void main(String[] args) {
        //発地点、着地点、発時刻、飛行時間を渡す
        ZonedDateTime result = getArrivalTime(
                ZoneId.of("America/Los_Angeles"),
                ZoneId.of("Europe/Paris"),
                LocalTime.of(3, 5),
                10, 50);
        //結果を出す
        System.out.println("目的地での到着時刻: " + result);
    }

    public static ZonedDateTime getArrivalTime(ZoneId departurePoint, ZoneId arrivalPoint, LocalTime departureTime, int flightHour, int flightMinutes) {
        ZonedDateTime arrivalTime = ZonedDateTime.ofInstant(ZonedDateTime.of(
                LocalDate.now(),
                departureTime.plusHours(flightHour).plusMinutes(flightMinutes),
                departurePoint
        ).toInstant(), arrivalPoint);

        System.out.println(
                "ローカル時刻での到着時刻: " +
                departureTime.plusHours(flightHour).plusMinutes(flightMinutes) +
                "\n出発地点での到着時刻: " +
                ZonedDateTime.of(LocalDate.now(), departureTime.plusHours(flightHour).plusMinutes(flightMinutes), departurePoint)
        );

        return arrivalTime;
    }
}
