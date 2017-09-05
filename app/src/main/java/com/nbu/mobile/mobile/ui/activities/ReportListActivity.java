package com.nbu.mobile.mobile.ui.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseActivity;
import com.nbu.mobile.common.utils.Demo;
import com.nbu.mobile.mobile.adapters.MyBalanceAdapter;
import com.nbu.mobile.mobile.ui.fragments.ReportFragment;
import com.pixelcan.inkpageindicator.InkPageIndicator;

import butterknife.BindView;

/**
 * Created by Sarvar on 05.09.2017.
 */

public class ReportListActivity extends BaseActivity {

    @BindView(R.id.balancePager)
    ViewPager balancePager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.indicator)
    InkPageIndicator indicator;

    FragmentManager manager;
    FragmentTransaction transaction;
    ReportFragment reportFragment;

    @Override
    protected int getLayout() {
        return R.layout.activity_report_list;
    }

    @Override
    protected void initialize() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationOnClickListener(view -> {
            this.onBackPressed();
        });
        toolbar.setNavigationIcon(R.drawable.icon_arrow_left);
        balancePager.setAdapter(new MyBalanceAdapter(this, Demo.balance));
        indicator.setViewPager(balancePager);
        reportFragment = ReportFragment.getInstance();
        showFragment(ReportFragment.TAG);
    }

    private void showFragment(String tag) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

                if (reportFragment.isAdded()) {
                    if (reportFragment.isHidden()) {
                        transaction.show(reportFragment);
                    }
                } else {

                    transaction.add(R.id.fragmentContainer, reportFragment, ReportFragment.TAG);
                }

        transaction.commit();
        transaction.addToBackStack("");
    }

    @Override
    public void onBackPressed() {
        if (manager.getBackStackEntryCount() == 1){
            this.finish();
        }else{
            super.onBackPressed();
        }
    }
}
