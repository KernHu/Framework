package cn.xcion.framework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/test/activity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {

                // 2. 跳转并携带参数
                ARouter.getInstance().build("/launcher/activity")
                        .withLong("key1", 666L)
                        .withString("key3", "888")
                        .navigation();

            }
        }, 3000);
    }
}