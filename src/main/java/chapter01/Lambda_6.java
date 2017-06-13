package chapter01;/*【課題6】
* Runnable内でチェックされる例外を処理しなければならないことが、面倒だと思いませんか。
* チェックされる全ての例外をキャッチし、それをチェックされない例外へ変えるuncheckメソッドを書きなさい。
* どのような例外でもスローできるrunメソッドを持つRunnableExインタフェースを定義します。
* そしてpublic static Runnable uncheck(RunnableEx runner)を実装します。
* uncheck関数内でラムダ式を使用します。
* */

public class Lambda_6{
    public static void main( String[] args ){
        new Thread( uncheck( () -> { System.out.println("Zzz"); Thread.sleep(1000); } ) ).start();
    }

    public static Runnable uncheck( RunnableEx runner ){
        return (() -> {
            try { runner.run();
            } catch( Exception e ){
                System.out.print("error");
            }
        });
    }
}