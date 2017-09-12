package com.nbu.mobile.mobile.ui.activities;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseActivity;
import com.nbu.mobile.common.utils.Demo;
import com.nbu.mobile.mobile.adapters.MainMenuAdapter;

import butterknife.BindView;

/**
 * Created by Sarvar on 05.09.2017.
 */

public class MainListActivity extends BaseActivity implements MainMenuAdapter.MainListClickListener {


    public static final String TAG = "MainListActivity";
    @BindView(R.id.list)
    RecyclerView list;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    MainMenuAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_menu_list;
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


            list.setLayoutManager(new LinearLayoutManager(this));
            list.setHasFixedSize(true);

            adapter = new MainMenuAdapter(this, Demo.mainMenuItems);
            adapter.setMainListClickListener(this);
            list.setAdapter(adapter);
    }



    @Override
    public void onMainListClick(int position) {
        startActivity(new Intent(this,ActivityPay.class));
    }
}
