/**
 * 【課題08】
 * 現在の時刻インスタントに対してサポートされる全てのタイムゾーンにおいて、
 * 今日の日付のオフセット（UTCとの差）を取得しなさい。
 * その際、ZoneId.getAvailableIdsをストリームに変換してから、ストリーム操作を使用することによって取得しなさい。
 *
 * 【メモ】
 * ひとまず出力させるぞっていうのはできたが、他の方法もあるのではないか、そもそも違うんじゃないか、と思い見直し中。
 */
package chapter05;

import com.sun.scenario.effect.Offset;

import java.time.*;
import java.util.Set;
import java.util.stream.Stream;

public class DateAndTime08 {
    public static void main(String[] args){
        ZonedDateTime datetime = ZonedDateTime.now();
        Instant instant = datetime.toInstant();

        Set zoneIdStream = ZoneId.getAvailableZoneIds();

        Stream offsetStream = zoneIdStream.stream().peek(zone ->
                System.out.print(
                    instant.atZone( ZoneId.of(zone.toString()) ).getOffset()
                )
        );

        offsetStream.forEach( x -> System.out.println( " " + x.toString()));
    }
}
