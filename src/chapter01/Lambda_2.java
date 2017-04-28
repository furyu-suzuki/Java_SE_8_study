package chapter01;/*【課題2】
* java.io.FilesのlistFile(FileFilter)メソッドとisDirectoryメソッドを用いて
* 指定されたディレクトリの下のすべてのサブディレクトリを返すメソッドを書きなさい。
* FileFilterオブジェクトではなく、ラムダ式を用いなさい。
* 同じことをメソッド参照を用いて行いなさい。
* */
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Lambda_2 {
    public static void main( String[] args ){

        //  -- ラムダ式使わないバージョン --
//        File f = new File( "./" );
//        File[] list = f.listFiles( );
//        for ( int i=0; i<list.length; i++ ) {
//            if( list[i].isDirectory() ){
//                System.out.println( list[i].getName() );
//            }
//        }

        // -- ラムダ式を使うバージョン --
//        File f = new File( "./" );
//        List<File> list = Arrays.asList(f.listFiles());  //forEachは配列には使えないネ
//        list.forEach( ( name ) -> {
//            if ( name.isDirectory() )
//                System.out.println( name.getName() );
//        } );

        //  -- メソッド参照を使うバージョン --
        File f = new File( "./" );
        List<File> list = Arrays.asList(f.listFiles( File::isDirectory ));
        list.forEach( System.out::println );  //メソッド参照では1処理しかできないので、他の処理はそれまでに済ませる
        //list.stream().filter( File::isDirectory ).forEach( System.out::println );  //次章でやるstreamを使ってもできる

    }
}