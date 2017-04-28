package chapter01;

class Greeter {
    public void greet(){
        System.out.println( "Hello world." );
    }

    public static void repeatMessage( String text, int count ){
        Runnable r = () -> {
            for( int i = 0; i<count; i++ ){
                System.out.println( text );
                Thread.yield();
            }
        };
        new Thread(r).start();
    }
}
