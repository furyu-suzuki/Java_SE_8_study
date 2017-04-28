package chapter01;

class ConcurrentGreeter extends Greeter {
    public void greet(){
        Thread t = new Thread( super::greet );
        t.start();

        repeatMessage( "Hello", 10 );
    }
}
