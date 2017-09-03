package com.nbu.mobile.mobile.adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nbu.mobile.R;
import com.nbu.mobile.common.base.App;
import com.nbu.mobile.common.utils.LOGGER;
import com.nbu.mobile.mobile.models.UniversalPartners;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by macbookpro on 03.09.17.
 */

public class LastPaymentAdapter extends RecyclerView.Adapter<LastPaymentAdapter.Holder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<UniversalPartners> partners;

    public LastPaymentAdapter(Context context,ArrayList<UniversalPartners> partners) {
        this.partners = partners;

        this.context = context;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.item_payments_circle,parent,false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        UniversalPartners partner = partners.get(position);

        holder.logo.setBackgroundDrawable(context.getResources().getDrawable(partner.getPartnerLogo()));
    }

    @Override
    public int getItemCount() {
        return partners.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.logo)
        AppCompatImageView logo;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
