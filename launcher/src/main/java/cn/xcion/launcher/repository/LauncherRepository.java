package cn.xcion.launcher.repository;

import cn.xcion.launcher.app.LauncherApp;
import cn.xcion.launcher.db.AppDatabase;
import cn.xcion.launcher.entry.MchInfo;

/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/6/26  01:46
 * Intro:
 */
public class LauncherRepository {

    private static volatile LauncherRepository INSTANCE = null;//禁止重排序

    private AppDatabase mDatabase;

    private LauncherRepository() {
        mDatabase = AppDatabase.getInstance(LauncherApp.launcherApp);
    }

    public static LauncherRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (LauncherRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LauncherRepository();
                }
            }
        }
        return INSTANCE;
    }

    public void insert(MchInfo mchInfo){

    }
}
