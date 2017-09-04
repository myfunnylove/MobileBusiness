package com.nbu.mobile.mobile.ui.activities;

import android.support.v7.widget.Toolbar;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by macbookpro on 04.09.17.
 */

public class ReportDetailActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayout() {
        return R.layout.activity_report_detail;
    }

    @Override
    protected void initialize() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.payment));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.setNavigationOnClickListener(view -> {
            this.finish();
        });
//        getSupportActionBar().setIcon(R.drawable.close);
    }
}
