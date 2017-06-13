package chapter01;/*【課題4】
* Fileオブジェクトの配列が与えられたとします。
* その配列をソートして、ファイルの前にディレクトリが来るようにし、
* ファイルとディレクトリのそれぞれのグループではパス名でソートされるようにしなさい。
* Comparatorではなくラムダ式を使用しなさい。
* */

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Lambda_4 {
    public static void main( String[] args ) {
        //Fileオブジェクトの配列が与えられる
        File f = new File("./");

        List<File> sortedFiles = new ArrayList<>();

        //ディレクトリだけソートするぞ
        List<File> dirs = Arrays.asList(f.listFiles( File::isDirectory ));
        sortedFiles.addAll(dirs.stream().sorted( comparing(File::getName) ).collect(Collectors.toList()));

        //ファイルだけソートするぞ
        List<File> files = Arrays.asList(f.listFiles( File::isFile ));
        sortedFiles.addAll(files.stream().sorted( comparing(File::getName) ).collect(Collectors.toList()));

        System.out.println(sortedFiles);
    }
}
