package com.nbu.mobile.common.ui.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseActivity;
import com.nbu.mobile.common.interfaces.ChooseConnector;
import com.nbu.mobile.common.ui.fragments.ChooseFragment;
import com.nbu.mobile.mobile.ui.activities.MainMenuActivity;
import com.nbu.mobile.mobile.ui.fragments.SignMobileFragment;

import javax.inject.Inject;

/**
 * Created by Sarvar on 31.08.2017.
 */

public class ChooseActivity extends BaseActivity implements ChooseConnector{

    public static final int MOBILE = 1;
    public static final int BUSINESS = 2;


    FragmentManager manager;

    FragmentTransaction transaction;



    @Override
    protected int getLayout() {
        return R.layout.activity_choose;
    }

    @Override
    protected void initialize() {


        showFragment(ChooseFragment.TAG);
    }

    @Override
    public void onFragmentClick(String which) {

        showFragment(which);

    }

    private void showFragment(String tag){
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        switch (tag){

            case ChooseFragment.TAG :

                if (manager.findFragmentByTag(ChooseFragment.TAG) == null){
                    ChooseFragment.getInstance().setOnChooseConnector(this);
                    transaction.add(R.id.container,ChooseFragment.getInstance(),ChooseFragment.TAG);
                }else{
                    transaction.show(ChooseFragment.getInstance());
                }

                break;

            case SignMobileFragment.TAG:

                if (manager.findFragmentByTag(ChooseFragment.TAG) != null){
                    transaction.hide(ChooseFragment.getInstance());
                }
                if (manager.findFragmentByTag(SignMobileFragment.TAG) == null){
                    SignMobileFragment.getInstance().setOnChooseConnector(this);

                    transaction.add(R.id.container,SignMobileFragment.getInstance(),SignMobileFragment.TAG);

                }else{
                    transaction.show(SignMobileFragment.getInstance());

                }

                break;
            case MainMenuActivity.TAG :

                startActivity(new Intent(ChooseActivity.this,MainMenuActivity.class));
                this.finish();

                break;

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
