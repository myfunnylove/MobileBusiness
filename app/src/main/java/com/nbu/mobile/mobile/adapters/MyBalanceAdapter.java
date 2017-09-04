package com.nbu.mobile.mobile.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nbu.mobile.R;
import com.nbu.mobile.mobile.models.Balance;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sarvar on 04.09.2017.
 */

public class MyBalanceAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<Balance> list;

    private LayoutInflater inflater;

    public MyBalanceAdapter(Context context, ArrayList<Balance> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.item_my_balance,container,false);

        Balance balance = list.get(position);
        ((TextView)view.findViewById(R.id.balance)).setText(balance.getBalance());
        ((TextView)view.findViewById(R.id.cardData)).setText(balance.getCardNumber() + " "+balance.getCardDate());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
