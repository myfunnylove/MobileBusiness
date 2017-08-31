package com.nbu.mobile.common.ui.activities;

import android.content.Intent;
import android.os.Handler;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseActivity;
import com.nbu.mobile.common.ui.activities.ChooseActivity;

/**
 * Created by Sarvar on 31.08.2017.
 */

public class SplashActivity extends BaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initialize() {
        new Handler()
                .postDelayed(()->{
                    startActivity(new Intent(this,ChooseActivity.class));
                    this.finish();
                },3000);

    }
}
