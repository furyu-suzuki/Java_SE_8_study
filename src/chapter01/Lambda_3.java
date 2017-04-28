package chapter01;/*【課題3】
* java.io.FileクラスのlistFiles(FileFilter)メソッドとisDirectoryメソッドを使用して
* 指定されたディレクトリの下にあって、指定された拡張子を持つ、すべてのファイルを返すメソッドを書きなさい。
* FilenameFilterではなく、ラムダ式を使用しなさい。
* エンクロージングスコープからキャプチャされる変数はどれですか。
* */
import java.io.File;
import java.util.List;
import java.util.Arrays;

public class Lambda_3 {
    public static void main( String[] args ){
        String key = ".iml";

        // -- ラムダ式を使わないバージョン --
//        File f = new File( "./" );
//        File[] list = f.listFiles( );
//        for ( int i=0; i<list.length; i++ ) {
//            if( list[i].toString().endsWith( key ) ){
//                System.out.println( list[i].getName() );
//            }
//        }

        // -- ラムダ式を使うバージョン --
        File f = new File( "./" );
        List<File> files = Arrays.asList( f.listFiles( ) );
        files.forEach( file -> { if( file.toString().endsWith( key ) ){
            System.out.println( file.getName() );
        } } );

    }
}
