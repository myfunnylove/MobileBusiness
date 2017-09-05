package com.nbu.mobile.mobile.adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nbu.mobile.R;
import com.nbu.mobile.mobile.models.UniversalPartners;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sarvar on 05.09.2017.
 */

public class PartnerListAdapter extends RecyclerView.Adapter<PartnerListAdapter.Holder> {
    private Context context;
    private ArrayList<UniversalPartners> list;

    private LayoutInflater inflater;
    private PartnerClickListener listener;

    public PartnerListAdapter(Context context, ArrayList<UniversalPartners> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.item_menu_list, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        UniversalPartners partner = list.get(position);

//        holder.logo.setBackgroundDrawable(context.getResources().getDrawable(partner.getPartnerLogo()));
        holder.partnerName.setText(partner.getPartnerName());
//        holder.secondaryName.setText(mainMenuItem.getSecondaryName());
        holder.container.setOnClickListener(view -> {
            listener.onReportClick(holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.logo)
        AppCompatImageView logo;

        @BindView(R.id.partnerName)
        TextView partnerName;



        @BindView(R.id.container)
        ViewGroup container;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface PartnerClickListener {

        void onReportClick(int position);


    }

    public void setPartnerClickListener(PartnerClickListener listener) {
        this.listener = listener;
    }
}
