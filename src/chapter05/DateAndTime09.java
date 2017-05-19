/**
 * 【課題09】
 * 再度、ストリーム操作を使用して、オフセットに1時間未満の情報が含まれるすべてのタイムゾーンを見つけなさい。
 */
package chapter05;

import java.time.*;
import java.util.stream.Stream;

public class DateAndTime09 {
    public static void main(String[] args) {
        Instant instant = ZonedDateTime.now().toInstant();

        Stream<ZoneOffset> offsetStream = ZoneId.getAvailableZoneIds().stream()
                .map(zone -> instant.atZone(ZoneId.of(zone)).getOffset());

        // オフセットのminuteのところが00ではないものを見つける
        offsetStream.filter(
                (ofs) -> (ofs.getTotalSeconds() % (60 * 60)) != 0
        ).forEach(System.out::println);

        // -- 悩んだ過程で生まれた別のフィルタ -- //
        // オフセットが1時間未満のものを見つけるバージョン
        //offsetStream.filter( ofs ->
        //        ofs.getTotalSeconds() < ZoneOffset.ofHours(1).getTotalSeconds() )
        //        .forEach(System.out::println);
    }
}
