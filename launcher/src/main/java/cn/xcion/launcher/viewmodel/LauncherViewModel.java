package cn.xcion.launcher.viewmodel;

import android.app.Application;
import android.util.Log;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MediatorLiveData;
import cn.xcion.launcher.api.RetrofitServiceApi;
import cn.xcion.mvvmhttp.base.BaseViewModel;
import cn.xcion.launcher.entry.MchInfo;
import cn.xcion.launcher.repository.LauncherRepository;
import cn.xcion.mvvmhttp.BaseApi;
import cn.xcion.mvvmhttp.RetrofitClient;
import cn.xcion.mvvmhttp.exception.HandlerException;
import cn.xcion.mvvmhttp.listener.HttpLifecycleListener;
import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/6/26  01:45
 * Intro:
 */
public class LauncherViewModel extends BaseViewModel<LauncherRepository> {

    public MediatorLiveData<MchInfo> mChInfoLiveData;//网络状态

    public LauncherViewModel(@NonNull Application application) {
        super(application);

        if (mChInfoLiveData == null) {
            mChInfoLiveData = new MediatorLiveData<>();
        }
    }


    public void getMchInfoFromDB() {

        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public void getMchInfoFromService() {

        RetrofitClient.getInstance().sendHttpRequestIO(new BaseApi(new HttpLifecycleListener<List<MchInfo>>() {
            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(List<MchInfo> o) {

                LauncherRepository.getInstance().insert(o.get(0));
            }

            @Override
            public void onError(HandlerException.ResponseThrowable e) {

            }

            @Override
            public void onComplete() {
            }
        }, getLifecycleProvider()) {
            @Override
            public Observable getObservable(Retrofit retrofit) {
                return retrofit.create(RetrofitServiceApi.class).getMchInfo("hello");
            }
        });

    }


    public void getUserInfo() {

        RetrofitClient.getInstance().sendHttpRequestIO(new BaseApi(new HttpLifecycleListener<Object>() {
            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(Object o) {
                Log.e("sos", "onNext???>>>" + o.toString());
                // LauncherRepository.getInstance().insert(o.get(0));
            }

            @Override
            public void onError(HandlerException.ResponseThrowable e) {
                Log.e("sos", "onError???>>>" + e.toString());
            }

            @Override
            public void onComplete() {
            }
        }, getLifecycleProvider()) {
            @Override
            public Observable getObservable(Retrofit retrofit) {
                return retrofit.create(RetrofitServiceApi.class).getUserInfo("trello");
            }
        });

    }
}
