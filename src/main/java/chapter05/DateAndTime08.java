/**
 * 【課題08】
 * 現在の時刻インスタントに対してサポートされる全てのタイムゾーンにおいて、
 * 今日の日付のオフセット（UTCとの差）を取得しなさい。
 * その際、ZoneId.getAvailableIdsをストリームに変換してから、ストリーム操作を使用することによって取得しなさい。
 * <p>
 * 【メモ】
 * ひとまず出力させるぞっていうのはできたが、他の方法もあるのではないか、そもそも違うんじゃないか、と思い見直し中。
 * -> ジョンさんに相談して解決した!
 */
package main.java.chapter05;

import java.time.*;
import java.util.stream.Stream;

public class DateAndTime08 {
    public static void main(String[] args) {
        Instant instant = ZonedDateTime.now().toInstant();

        Stream offsetStream = ZoneId.getAvailableZoneIds().stream().map(zone ->
                instant.atZone(ZoneId.of(zone)).getOffset()
        );

        offsetStream.forEach(x -> System.out.println(x));
    }
}
