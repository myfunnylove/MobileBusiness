package com.nbu.mobile.mobile.ui.activities;

import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseActivity;
import com.nbu.mobile.common.utils.Demo;
import com.nbu.mobile.mobile.ui.fragments.MainFragment;

import butterknife.BindView;

/**
 * Created by Microlab on 31.08.2017.
 */

public class MainMenuActivity extends BaseActivity {

    public static final String TAG = "MainMenuActivity";

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;





    @BindView(R.id.tablayout)
    TabLayout tabLayout;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected int getLayout() {
        return R.layout.activity_main_menu;
    }

    @Override
    protected void initialize() {

        showFragment(MainFragment.TAG);
    }

    private void showFragment(String whichFragment){
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        switch (whichFragment){

            case MainFragment.TAG:
                if (manager.findFragmentByTag(MainFragment.TAG) == null){
                    transaction.add(R.id.bottomContainer,MainFragment.getInstance(),MainFragment.TAG);
                    new Handler().postDelayed(() -> {
                            MainFragment.getInstance().setLastAdded(Demo.partners);
                    MainFragment.getInstance().setTopPayments(Demo.partners);
                    },2000);
                }else if (manager.findFragmentByTag(MainFragment.TAG).isHidden()){
                    transaction.show(MainFragment.getInstance());

                }


                break;
        }

        transaction.commit();
        transaction.addToBackStack("");

    }
}
