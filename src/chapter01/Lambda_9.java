package chapter01;/*【課題9】
* CollectionのサブインタフェースであるCollection2を作成して
* デフォルトメソッドとしてvoid forEachIF(Consumer<T> action, Predicate<T> filter)を作成しなさい。
* そのメソッドはfilterがtrueを返す個々の要素に対してactionを実行する。
* どのような場面でこのメソッドが役に立つでしょうか。
* 【メモ】
* 他の課題に比べてかなり時間がかかった問題。
* ジョンさんにかなり助けてもらって解決した。
* イテレータを使うなど、プラスアルファで学ぶこともたくさんあった。
* */
import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lambda_9 {
    public static void main( String[] args ){
        //forEachIFを呼び出す action, filter を指定する
        Consumer<File> action = x -> System.out.println( x );
        Predicate<File> filter = x -> x.isDirectory();
        Coll coll = new Coll();
        coll.forEachIF( action, filter );

        File f = new File("C:/java");
        List2<File> list2 = new List2<>();
        list2.addAll(Arrays.asList(f.listFiles()));
        list2.forEachIF(action, filter);
    }
}

class List2<E> extends ArrayList<E> implements Collection2<E> {
}

class Coll implements Collection2<File>{
    List<File> list;
    public Coll() {
        File f = new File("C:/java");
        list = Arrays.asList( f.listFiles() );
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(File file) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}