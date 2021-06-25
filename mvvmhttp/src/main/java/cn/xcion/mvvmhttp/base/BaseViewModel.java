package cn.xcion.mvvmhttp.base;

import android.app.Application;

import com.trello.rxlifecycle2.LifecycleProvider;

import java.lang.ref.WeakReference;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import cn.xcion.mvvmhttp.AppExecutors;


public class BaseViewModel<M> extends AndroidViewModel implements LifecycleObserver {

    protected M model;
    //弱引用持有
    private WeakReference<LifecycleProvider> lifecycle;
    protected AppExecutors appExecutors;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        appExecutors = AppExecutors.getInstance();
    }

    /**
     * 注入RxLifecycle生命周期
     *
     * @param lifecycle
     */
    public void injectLifecycleProvider(LifecycleProvider lifecycle) {
        this.lifecycle = new WeakReference<>(lifecycle);
    }

    public WeakReference<LifecycleProvider> getLifecycleProvider() {
        return lifecycle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner owner, Lifecycle.Event event) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
    }
}
