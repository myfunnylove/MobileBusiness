package com.nbu.mobile.mobile.ui.fragments;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.BaseFragment;

/**
 * Created by Sarvar on 31.08.2017.
 */

public class PaymentFragment extends BaseFragment {
    public static final String TAG = "PaymentFragment";

    @Override
    protected int getViewLayout() {
        return 0;
    }

    @Override
    protected void initialize() {

    }

    @Override
    public String getTitle() {
        return getActivity().getString(R.string.app_name);
    }
}
