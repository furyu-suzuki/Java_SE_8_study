package chapter01;/*【課題4】
* Fileオブジェクトの配列が与えられたとします。
* その配列をソートして、ファイルの前にディレクトリが来るようにし、
* ファイルとディレクトリのそれぞれのグループではパス名でソートされるようにしなさい。
* Comparatorではなくラムダ式を使用しなさい。
* */
import java.io.File;
import java.util.List;
import java.util.Arrays;
import static java.util.Comparator.comparing;

public class Lambda_4 {
    public static void main( String[] args ) {
        //Fileオブジェクトの配列が与えられる
        File f = new File("./");

        //ディレクトリだけソートするぞ
        List<File> dirs = Arrays.asList(f.listFiles( File::isDirectory ));
        dirs.stream().sorted( comparing(File::getName) );
        //ファイルだけソートするぞ
        List<File> files = Arrays.asList(f.listFiles( File::isFile ));
        files.stream().sorted( comparing(File::getName) );

        String str = String.join( "", dirs.toString(), files.toString() );

        System.out.println( str );
    }
}
