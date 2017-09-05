package com.nbu.mobile.mobile.ui.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseActivity;
import com.nbu.mobile.common.utils.Demo;
import com.nbu.mobile.mobile.adapters.MyBalanceAdapter;
import com.pixelcan.inkpageindicator.InkPageIndicator;

import butterknife.BindView;

/**
 * Created by Sarvar on 05.09.2017.
 */

public class ActivityPay extends BaseActivity {

    @BindView(R.id.balancePager)
    ViewPager balancePager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @BindView(R.id.indicator)
    InkPageIndicator indicator;

    @Override
    protected int getLayout() {
        return R.layout.activity_pay;
    }

    @Override
    protected void initialize() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.icon_arrow_left);
        toolbar.setNavigationOnClickListener(view -> this.finish());
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        balancePager.setAdapter(new MyBalanceAdapter(this, Demo.balance));
        indicator.setViewPager(balancePager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.pay_menu,menu);
        return true;
    }
}
