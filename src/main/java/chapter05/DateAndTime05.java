/**
 * 【課題05】
 * 今までにあなたが生きてきた日数を表示するプログラムを作りなさい。
 */
package chapter05;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateAndTime05 {
    public static void main(String[] args) {
        System.out.print("生年月日をyyyy MM ddで入力 -> ");
        Scanner scan = new Scanner(System.in);

        try {
            LocalDate birthday = LocalDate.of(Integer.parseInt(scan.next()), Integer.parseInt(scan.next()), Integer.parseInt(scan.next()));

            // 今日の日付との差を計算
            long diff = ChronoUnit.DAYS.between(birthday, LocalDate.now());

            System.out.println("あなたは" + birthday + "から" + diff + "日間生きてきました");
        } catch (Exception e) {
            System.out.println("入力の値がおかしいです。");
        }
    }
}
