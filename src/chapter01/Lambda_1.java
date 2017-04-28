package chapter01;/*【課題】
* Arrays.sort内で呼び出されるコンパレータのコードは
* sortメソッドを呼び出したスレッドで実行されるでしょうか。
* それとも別のスレッドで実行されるでしょうか。
* */
import java.lang.Thread;
import java.util.Arrays;
import java.util.Comparator;

public class Lambda_1 {
     public static void main( String[] args ){
        System.out.println( Thread.activeCount() );

         Thread t = new Thread();

         Integer[] x = { 6, 89, 32, 17, 41 };
        Comp c = new Comp();
        Arrays.sort( x, c );
        System.out.println( t.activeCount() );

         try {
             t.sleep( 1000 );
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println( t.activeCount() );

         try {
             t.sleep( 10 * 1000 );
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println( t.activeCount() );

         try {
             t.join(200);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println( t.activeCount() );
     }
}

class Comp implements Comparator<Integer> {
    public int compare(Integer n1, Integer n2) {
        if (n1 < n2) {
            return -1;
        } else if (n1 > n2) {
            return 1;
        } else {
            return 0;
        }
    }
}