package cn.xcion.mvvmhttp;

import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import cn.xcion.mvvmhttp.cookie.NewCookieJar;
import cn.xcion.mvvmhttp.interceptor.LoggerInterceptor;
import cn.xcion.mvvmhttp.interceptor.NetWorkInterceptor;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/6/26  00:34
 * Intro:
 */
public class RetrofitClient {

    //超时时间
    private static final int DEFAULT_TIMEOUT = 10;

    private volatile static RetrofitClient INSTANCE;
    private final Retrofit retrofit;

    //获取单例
    public static RetrofitClient getInstance() {
        if (INSTANCE == null) {
            synchronized (RetrofitClient.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RetrofitClient();
                }
            }
        }
        return INSTANCE;
    }


    private RetrofitClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(!TextUtils.isEmpty(MvvmHttp.getInstance().baseUrl) ? MvvmHttp.getInstance().baseUrl : "https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient.Builder()
                        .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .addInterceptor(new LoggerInterceptor().setLogTag(MvvmHttp.getInstance().logTag)
                                .setLevel(HttpLoggingInterceptor.Level.BODY)
                                .setPrintable(MvvmHttp.getInstance().logPrintable)
                                .build()
                        ).addNetworkInterceptor(new NetWorkInterceptor())
                        .retryOnConnectionFailure(MvvmHttp.getInstance().retryOnConnectionFailure)
                        .cookieJar(new NewCookieJar())
                        .build())
                .build();

    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    /**
     * 在主线程观察
     */
    public void sendHttpRequestMain(BaseApi basePar) {
        /*rx处理*/
        basePar.getObservable(retrofit)
                /*生命周期管理*/
                .compose(basePar.getLifecycleProvider().bindToLifecycle())
                /*http请求线程*/
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                /*回调线程*/
                .observeOn(AndroidSchedulers.mainThread())
                /*结果判断*/
                .map(basePar)
                .subscribe(basePar);
    }

    /**
     * 在IO线程观察
     */
    public void sendHttpRequestIO(BaseApi basePar) {
        /*rx处理*/
        basePar.getObservable(retrofit)
                /*生命周期管理*/
                .compose(basePar.getLifecycleProvider().bindToLifecycle())
                /*http请求线程*/
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                /*回调线程*/
                .observeOn(Schedulers.io())
                /*结果判断*/
                .map(basePar)
                .subscribe(basePar);
    }


}
