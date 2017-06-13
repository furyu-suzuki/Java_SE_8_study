/**
 * 【課題02】
 * LocalDate.of(2000, 2, 29)に1年を加算するとどうなりますか。
 * 4年を加算するとどうなりますか。
 * さらに、1年を4回加算するとどうなりますか。
 * <p>
 * 【回答】
 * 1年を加算すると、2001/02/28
 * 一度に4年を加算すると、2004/02/29
 * 1年を4回加算すると、2004/02/28
 * となる。
 */
package chapter05;

import java.time.*;

public class DateAndTime02 {
    public static void main(String[] args) {
        LocalDate day = LocalDate.of(2000, 2, 29);
        System.out.println(day + "に");

        //1年を加算
        System.out.println("1年を加算 -> " + day.plusYears(1));

        //4年を加算
        System.out.println("4年を加算 -> " + day.plusYears(4));

        //1年を4回加算
        System.out.println("1年を4回加算 -> " + day.plusYears(1).plusYears(1).plusYears(1).plusYears(1));

        //forループで1年を4回加算
        for (int i = 0; i < 4; i++) {
            day = day.plusYears(1);
        }
        System.out.println("forループで1年を4回加算 -> " + day);

    }
}
