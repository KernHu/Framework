package cn.xcion.launcher.app;

import android.app.Application;

import cn.xcion.mvvmhttp.MvvmHttp;

/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/6/26  01:24
 * Intro:
 */
public class LauncherApp extends Application {

    public static LauncherApp launcherApp;

    @Override
    public void onCreate() {
        super.onCreate();

        this.launcherApp = this;

        MvvmHttp.getInstance()
                .setBaseUrl("https://api.github.com/")
                .setConnectTimeout(10)
                .setWriteTimeout(10)
                .setReadTimeout(10)
                .setLogPrintable(true)
                .setRetrofitLockable(true)
                .setRetryOnConnectionFailure(true)
                .bind();
    }
}
