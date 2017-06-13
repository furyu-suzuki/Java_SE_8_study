package chapter01;/*【課題8】
* ラムダ式が次のような拡張forループ内の値をキャプチャした場合、どうなりますか。
* これは、正当なコードなのでしょうか。
* 各ラムダ式は異なる値をキャプチャするのでしょうか。
* それとも、全てのラムダ式が最後の値をキャプチャするのでしょうか。
* 従来のfor(int i=0; i<names.length; i++)を用いたらどうなるのでしょうか。
*/
import java.util.ArrayList;
import java.util.List;

public class Lambda_8 {
    public static void main( String[] args ){
        String[] names = { "Peter", "Paul", "Mary" };
        List<Runnable> runners = new ArrayList<>();
        for( String name : names )
            runners.add( () -> System.out.println( name ) );
        for( Runnable r : runners )
            r.run();

        System.out.println("---");

        runners = new ArrayList<>();
        for(int i=0; i<names.length; i++) {
            int finalI = i;
            runners.add( () -> System.out.println( names[finalI] ) );
        }
        for( Runnable r : runners )
            r.run();
    }
}
