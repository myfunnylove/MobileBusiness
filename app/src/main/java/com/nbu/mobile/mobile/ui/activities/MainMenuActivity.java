package com.nbu.mobile.mobile.ui.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseActivity;
import com.nbu.mobile.common.base.BaseFragment;
import com.nbu.mobile.common.interfaces.FragmentConnector;
import com.nbu.mobile.common.utils.Demo;
import com.nbu.mobile.mobile.adapters.MainPagerAdapter;
import com.nbu.mobile.mobile.adapters.MyBalanceAdapter;
import com.nbu.mobile.mobile.adapters.ReportAdapter;
import com.nbu.mobile.mobile.ui.fragments.MainFragment;
import com.nbu.mobile.mobile.ui.fragments.PaymentFragment;
import com.nbu.mobile.mobile.ui.fragments.ReportFragment;
import com.pixelcan.inkpageindicator.InkPageIndicator;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Microlab on 31.08.2017.
 */

public class MainMenuActivity extends BaseActivity implements FragmentConnector {

    public static final String TAG = "MainMenuActivity";


    @BindView(R.id.balancePager)
    ViewPager balancePager;


    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigationView)
    NavigationView navigationView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.indicator)
    InkPageIndicator indicator;


    ActionBarDrawerToggle actionBarDrawerToggle;

    FragmentManager manager;
    FragmentTransaction transaction;

    /*
    *
    * Fragments
    *
    * */
    MainFragment mainFragment;


    @Override
    protected int getLayout() {
        return R.layout.activity_main_menu;
    }

    @Override
    protected void initialize() {
        initActionBar();

        balancePager.setAdapter(new MyBalanceAdapter(this, Demo.balance));
        indicator.setViewPager(balancePager);
        mainFragment = MainFragment.getInstance();
        mainFragment.setOnChooseConnector(this);
//        reportFragment = ReportFragment.getInstance();

        showFragment(MainFragment.TAG);
    }

    private void showFragment(String tag) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        switch (tag) {
            case MainFragment.TAG:
//
//                if (reportFragment.isAdded() && !reportFragment.isHidden())
//                    transaction.hide(reportFragment);

                if (mainFragment.isAdded()) {
                    if (mainFragment.isHidden()) {
                        transaction.show(mainFragment);
                    }
                } else {
                    transaction.add(R.id.fragmentContainer, mainFragment, MainFragment.TAG);
                }
                break;
            case ReportFragment.TAG:


                startActivity(new Intent(this, ReportListActivity.class));
//                if (mainFragment.isAdded() && !mainFragment.isHidden())
//                    transaction.hide(mainFragment);
//
//                if (reportFragment.isAdded()) {
//                    if (reportFragment.isHidden()) {
//                        transaction.show(reportFragment);
//                    }
//                } else {
//                    Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
//
//                    transaction.add(R.id.fragmentContainer, reportFragment, ReportFragment.TAG);
//                }
                break;
            case MainListActivity.TAG:
                startActivity(new Intent(this, MainListActivity.class));

                break;
        }

        transaction.commit();
//        transaction.addToBackStack("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    private void initActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> drawerLayout.openDrawer(Gravity.LEFT));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        navigationView.setNavigationItemSelectedListener((item) -> {
            drawerLayout.closeDrawers();
            return true;
        });
        initDrawerLayoutHeader();
    }

    private void initDrawerLayoutHeader() {

        View headerContainer = navigationView.getHeaderView(0);

        //TODO navigation headerPersonName for person name
        final TextView headerPersonName = (TextView) headerContainer.findViewById(R.id.name);
        headerPersonName.setText("Muhammadjon Xasanov");
//        final TextView headerPersonId = (TextView) headerContainer.findViewById(R.id.drawer_header_person_id);
//        headerPersonId.setTypeface(customFontTypeface);

//            headerPersonName.setText("Demo");
    }


    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            if (manager.getBackStackEntryCount() == 1) {
                this.finish();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void onFragmentClick(String nextFragmentTag) {
//        showFragment(nextFragmentTag);
    }


    @OnClick({R.id.goAnalize, R.id.goPayment, R.id.goReport, R.id.goTransfer})
    public void go(View view) {

        switch (view.getId()) {
            case R.id.goAnalize:
                break;
            case R.id.goPayment:
                showFragment(MainListActivity.TAG);
                break;
            case R.id.goReport:
                showFragment(ReportFragment.TAG);

                break;
            case R.id.goTransfer:

                break;

        }
    }
}
