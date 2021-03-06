package com.jiahuaandroid.rxandmvp.core.mvp;

import android.os.Bundle;

import com.jiahuaandroid.rxandmvp.core.mvp.interfaces.ActivityView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Created by jhhuang on 2016/8/26.
 * QQ:781913268
 * Description：MvpActivity
 */
public abstract class MvpActivity<T extends ActivityPresenter> extends RxAppCompatActivity implements ActivityView
{
    private static final String TAG = "MvpActivity";
    protected T mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView(this);
    }

    /**
     * @return create presenter
     */
    protected abstract T createPresenter();

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mPresenter.detachView();
    }
}
