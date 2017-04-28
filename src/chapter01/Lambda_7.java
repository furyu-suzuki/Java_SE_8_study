package chapter01;

/*【課題7】
* static メソッドandThenを書きなさい。
* andThenメソッドは2つのRunnableインスタンスをパラメータとして受け取るようにし、
* 最初のRunnableを実行した後に2つ目のRunnableを実行するRunnableを返すようにします。
* mainメソッドでは、andThenへの呼び出しに2つのラムダ式を渡して、返されたインスタンスを実行するようにしなさい。
*/
public class Lambda_7 {
    public static void main( String[] args ){
        //andThenを呼び出し
//        Runnable inst = andThen( ( () -> System.out.println("hoge") ),
//                ( () -> System.out.println("keme") ) );
        //帰ってきたインスタンスを実行
//        inst.run();
        andThen( ( () -> System.out.println("hoge") ),
                ( () -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.print("---");
                    }
                    System.out.println("keme");
                } )
        ).run();
    }

    static Runnable andThen( Runnable r1, Runnable r2 ){
        return ()->{ r1.run(); r2.run(); };
    }
}
