/**
 * 【課題4】
 * Filterという名前を持つ関数型インタフェースが、Java APIにはいくつありますか。
 * そのうちのどれが、Predicate<T>よりも付加価値がありますか。
 * <p>
 * 【回答】
 * java.io.FileFilter, java.io.FilenameFilter, java.util.logging.Filter, DirectoryStream.Filter の4つがある。
 * 呼び出せる関数メソッドの数だけを見ると、どれもPredicateよりも少ない。
 * ただし、java.io.FilenameFilterはAbstract Window Toolkit (AWT)からも呼び出すことができる点で、Predicate<T>よりも便利である。
 */
