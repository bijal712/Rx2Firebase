package rx2demo.example.com.myapplication.utils;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;

public class MaybeListener<T> implements MaybeSource<T> {


    public T subscribe(T posts) {
        return posts;
    }

    @Override
    public void subscribe(MaybeObserver<? super T> observer) {

    }
}
