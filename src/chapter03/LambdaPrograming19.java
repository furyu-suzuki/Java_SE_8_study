/**
 * 【課題19】
 * Stream<T>のメソッドである
 * <U> U reduce (U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
 * を見てみなさい。
 * BiFunctionへの最初の引数でUを ? super U と宣言すべきですか。
 * その理由は、何ですか。
 *
 * 【回答】
 * ワイルドカードで宣言する必要はない。
 * 1度の呼び出しの中でUが変化することはないため。
 * このreduceメソッドは
    U result = identity;
    for (T element : this stream)
        result = accumulator.apply(result, element)
    return result;
 * と同様の働きをし、1つ前のループで得られたresultを用いてaccumulatorを実行するので
 * 1度呼び出したreduceの中でBiFunction<U, ? super T, U>の1つ目のUが変化することはない。
 * むしろ、途中で型が変化するとループ処理が行えなくなるため、ワイルドカードを用いないほうがよい。
 */