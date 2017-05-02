package chapter01;/*【課題】
* Arrays.sort内で呼び出されるコンパレータのコードは
* sortメソッドを呼び出したスレッドで実行されるでしょうか。
* それとも別のスレッドで実行されるでしょうか。
* */

import java.util.Arrays;
import java.util.Comparator;

public class Lambda_1 {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getId());

        Integer[] x = { 6, 89, 32, 17, 41 };
        Comp c = new Comp();
        Arrays.sort(x, c);
        /*
         * なお、parallelSortを呼んでも、要素数が一定以上でないと並列スレッドを使わず単一スレッドで処理する
         */
        Arrays.parallelSort(x, c);
    }
}

class Comp implements Comparator<Integer> {
    public int compare(Integer n1, Integer n2) {
        System.out.println(Thread.currentThread().getId());
        if (n1 < n2) {
            return -1;
        } else if (n1 > n2) {
            return 1;
        } else {
            return 0;
        }
    }
}