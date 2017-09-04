package com.nbu.mobile.mobile.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseFragment;
import com.nbu.mobile.common.utils.Demo;
import com.nbu.mobile.mobile.adapters.ReportAdapter;
import com.nbu.mobile.mobile.ui.activities.ReportDetailActivity;

import butterknife.BindView;

/**
 * Created by Sarvar on 31.08.2017.
 */

public class ReportFragment extends BaseFragment {
    public static final String TAG = "ReportFragment";


    @BindView(R.id.list)
    RecyclerView list;

    private ReportAdapter adapter;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_report;
    }

    @Override
    protected void initialize() {

        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setHasFixedSize(true);
        adapter = new ReportAdapter(getActivity(), Demo.report);
        adapter.setReportClickListener(position -> {
            startActivity(new Intent(getActivity(), ReportDetailActivity.class));
        });

        list.setAdapter(adapter);
    }

    @Override
    public String getTitle() {
        return getActivity().getString(R.string.app_name);
    }

    private static ReportFragment mInstance;
    public static ReportFragment getInstance(Bundle bundle) {
        if (mInstance == null) mInstance = new ReportFragment();

        mInstance.setArguments(bundle);
        return mInstance;
    }
    public static ReportFragment getInstance() {
        if (mInstance == null) mInstance = new ReportFragment();

        return mInstance;
    }

}
