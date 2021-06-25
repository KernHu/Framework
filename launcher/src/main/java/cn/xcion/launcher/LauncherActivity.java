package cn.xcion.launcher;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import cn.xcion.mvvmhttp.base.BaseViewModelActivity;
import cn.xcion.launcher.databinding.ActivityLauncherBinding;
import cn.xcion.launcher.entry.MchInfo;
import cn.xcion.launcher.viewmodel.LauncherViewModel;


/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/6/26  00:22
 * Intro:
 */
@Route(path = "/launcher/activity")
public class LauncherActivity extends BaseViewModelActivity<ActivityLauncherBinding, LauncherViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_launcher;
    }

    @Override
    public LauncherViewModel getViewModel() {
        return new ViewModelProvider(this).get(LauncherViewModel.class);
    }

    @Override
    public void initView() {
        //切记不能忽略
        binding.setViewModel(viewModel);
    }

    @Override
    public void initData() {

        viewModel.getMchInfoFromDB();
        viewModel.getUserInfo();
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();

        viewModel.mChInfoLiveData.observe(this, new Observer<MchInfo>() {
            @Override
            public void onChanged(MchInfo mchInfo) {

            }
        });

    }
}
