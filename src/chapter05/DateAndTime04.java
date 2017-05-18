/**
 * 【課題04】
 * ある月のカレンダーを表示するUnixのcalプログラムと同じプログラムを書きなさい。
 * たとえば、java Cal 3 2013を実行すると、次のように表示します。
 *                  1   2   3
 *  4   5   6   7   8   9  10
 * 11  12  13  14  15  16  17
 * 18  19  20  21  22  23  24
 * 25  26  27  28  29  30  31
 * 3月1日が金指であることを示しています。（土日が右端に表示されるようにしなさい。）
 */
package chapter05;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;
import java.time.*;

public class DateAndTime04 {
    public static void main(String[] args) {
        System.out.print("取得する月と年を入力 -> ");
        Scanner scan = new Scanner(System.in);
        int month = Integer.parseInt(scan.next());
        int year = Integer.parseInt(scan.next());

        if (month <= 12 && month > 0) {
            System.out.println(year + "年" + month + "月のカレンダーを表示します");
            LocalDate date = LocalDate.of(year, month, 1);

            // 1日の曜日までインデントする
            for (int i = 0; i < (date.getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue()); i++) {
                System.out.print("\t");
            }
            // 順番にカレンダーを出力する
            do {
                String str = "";

                if (date.getDayOfMonth() < 10) {
                    str = " ";
                }
                str = str + date.getDayOfMonth() + "\t";
                if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    str = str + "\n";
                }

                System.out.print(str);
                date = date.plus(1, ChronoUnit.DAYS);
            } while (date != date.with(TemporalAdjusters.firstDayOfMonth()));
        } else {
            System.out.println("月は1～12で入力してください");
        }
    }
}
