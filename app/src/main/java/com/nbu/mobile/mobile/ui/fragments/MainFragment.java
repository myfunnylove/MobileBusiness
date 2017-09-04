package com.nbu.mobile.mobile.ui.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseFragment;
import com.nbu.mobile.common.interfaces.FragmentConnector;
import com.nbu.mobile.common.utils.Demo;
import com.nbu.mobile.mobile.adapters.LastPaymentAdapter;
import com.nbu.mobile.mobile.adapters.NewsAdapter;
import com.nbu.mobile.mobile.models.UniversalPartners;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Sarvar on 31.08.2017.
 */

public class MainFragment extends BaseFragment {

    public static final String TAG = "MainFragment";

    @BindView(R.id.topPaymentView)
    RecyclerView topPaymentView;

    @BindView(R.id.lastAddedView)
    RecyclerView lastAddedView;

    @BindView(R.id.newsView)
    RecyclerView newsView;

    private FragmentConnector chooseConnector;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initialize() {
        topPaymentView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        topPaymentView.setHasFixedSize(true);
        topPaymentView.setAdapter(new LastPaymentAdapter(getActivity(), Demo.partners));

        lastAddedView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        lastAddedView.setHasFixedSize(true);
        lastAddedView.setAdapter(new LastPaymentAdapter(getActivity(), Demo.partners));

        newsView.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsView.setHasFixedSize(true);
        newsView.setAdapter(new NewsAdapter(getActivity(), Demo.news));
    }

    @Override
    public String getTitle() {
        return "MainFragment";
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


    public void setTopPayments(ArrayList<UniversalPartners> payments){
//        listTopPayments.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true));
//        listTopPayments.setHasFixedSize(true);
//        listTopPayments.setAdapter(new LastPaymentAdapter(getActivity(),payments));
    }

    public void setLastAdded(ArrayList<UniversalPartners> payments){
//        listLastAdded.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true));
//        listLastAdded.setHasFixedSize(true);
//        listLastAdded.setAdapter(new LastPaymentAdapter(getActivity(),payments));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void setOnChooseConnector(FragmentConnector chooseConnector){
        this.chooseConnector = chooseConnector;
    }



}
