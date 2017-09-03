package com.nbu.mobile.mobile.ui.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseFragment;
import com.nbu.mobile.common.interfaces.ChooseConnector;
import com.nbu.mobile.common.ui.fragments.ChooseFragment;
import com.nbu.mobile.common.utils.LOGGER;
import com.nbu.mobile.mobile.adapters.LastPaymentAdapter;
import com.nbu.mobile.mobile.models.UniversalPartners;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Sarvar on 31.08.2017.
 */

public class MainFragment extends BaseFragment {

    public static final String TAG = "MainFragment";

    @BindView(R.id.listLastAdded)
    RecyclerView listLastAdded;

    @BindView(R.id.listTopPayments)
    RecyclerView listTopPayments;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initialize() {

    }



    private static MainFragment mInstance;
    public static MainFragment getInstance(Bundle bundle) {
        if (mInstance == null) mInstance = new MainFragment();

        mInstance.setArguments(bundle);
        return mInstance;
    }
    public static MainFragment getInstance() {
        if (mInstance == null) mInstance = new MainFragment();

        return mInstance;
    }

//    public void setOnChooseConnector(ChooseConnector chooseConnector){
//        this.chooseConnector = chooseConnector;
//    }

    public void setTopPayments(ArrayList<UniversalPartners> payments){
        listTopPayments.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true));
        listTopPayments.setHasFixedSize(true);
        listTopPayments.setAdapter(new LastPaymentAdapter(getActivity(),payments));
    }

    public void setLastAdded(ArrayList<UniversalPartners> payments){
        listLastAdded.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true));
        listLastAdded.setHasFixedSize(true);
        listLastAdded.setAdapter(new LastPaymentAdapter(getActivity(),payments));
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
