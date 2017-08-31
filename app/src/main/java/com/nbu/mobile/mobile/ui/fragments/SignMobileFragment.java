package com.nbu.mobile.mobile.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseFragment;
import com.nbu.mobile.common.interfaces.ChooseConnector;
import com.nbu.mobile.common.ui.fragments.ChooseFragment;

import butterknife.OnClick;

/**
 * Created by Sarvar on 31.08.2017.
 */

public class SignMobileFragment extends BaseFragment {

    public static final String TAG = "SignMobileFragment";
    private ChooseConnector chooseConnector;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_sign_mobile;
    }

    @Override
    protected void initialize() {

    }

    @OnClick(R.id.signIn)
    void signIn(View view){
//        chooseConnector.onFragmentClick(SignMobileFragment);
    }

    private static SignMobileFragment mInstance;
    public static SignMobileFragment getInstance(Bundle bundle) {
        if (mInstance == null) mInstance = new SignMobileFragment();

        mInstance.setArguments(bundle);
        return mInstance;
    }

    public static SignMobileFragment getInstance() {
        if (mInstance == null) mInstance = new SignMobileFragment();

        return mInstance;
    }

    public void setOnChooseConnector(ChooseConnector chooseConnector){
        this.chooseConnector = chooseConnector;
    }
}
