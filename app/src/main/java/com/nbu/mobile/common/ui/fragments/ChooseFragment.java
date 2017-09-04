package com.nbu.mobile.common.ui.fragments;

import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.Button;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseFragment;
import com.nbu.mobile.common.interfaces.FragmentConnector;
import com.nbu.mobile.mobile.ui.fragments.SignMobileFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Sarvar on 31.08.2017.
 */

public class ChooseFragment extends BaseFragment {


    public static final String TAG = "ChooseFragment";
    @BindView(R.id.chooseBusiness)
    Button chooseBusiness;

    @BindView(R.id.alwaysCheck)
    AppCompatCheckBox alwaysCheck;

    private FragmentConnector chooseConnector;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_choose;
    }

    @Override
    protected void initialize() {

    }

    @OnClick(R.id.chooseMobile)
    void chooseMobileClick(View view){
        chooseConnector.onFragmentClick(SignMobileFragment.TAG);
    }

    private static ChooseFragment mInstance;
    public static ChooseFragment getInstance(Bundle bundle) {
        if (mInstance == null) mInstance = new ChooseFragment();

        mInstance.setArguments(bundle);
        return mInstance;
    }

    public static ChooseFragment getInstance() {
        if (mInstance == null) mInstance = new ChooseFragment();

        return mInstance;
    }

    public void setOnChooseConnector(FragmentConnector chooseConnector){
        this.chooseConnector = chooseConnector;
    }

    @Override
    public String getTitle() {
        return getActivity().getString(R.string.app_name);
    }

}
