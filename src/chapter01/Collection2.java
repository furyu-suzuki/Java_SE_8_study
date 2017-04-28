package chapter01;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<T> extends Collection<T> {
    default void forEachIF(Consumer<T> action, Predicate<T> filter){
        //filterでtrueのものにactionをひとつずつ実行する
        this.forEach( ( some ) -> { if(filter.test( some ) == true){ action.accept( some ); } } );}
}
