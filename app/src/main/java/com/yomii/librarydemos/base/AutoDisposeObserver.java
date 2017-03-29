package com.yomii.librarydemos.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 观察者基类, 实现自动解除订阅, 并且解除订阅后可以再次订阅事件
 * Created by Yomii on 2017/3/28.
 */

public abstract class AutoDisposeObserver<T> implements Observer<T>, Disposable {

    private Disposable d;

    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (!isDisposed())
            dispose();
    }

    @Override
    public void onComplete() {
        if (!isDisposed())
            dispose();
    }

    @Override
    public void dispose() {
        d.dispose();
    }

    @Override
    public boolean isDisposed() {
        return d.isDisposed();
    }
}
