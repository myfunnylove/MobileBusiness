package com.nbu.mobile.mobile.adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nbu.mobile.R;
import com.nbu.mobile.mobile.models.Balance;
import com.nbu.mobile.mobile.models.MainMenuItem;
import com.nbu.mobile.mobile.models.UniversalPartners;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sarvar on 05.09.2017.
 */

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.Holder> {
    private Context context;
    private ArrayList<MainMenuItem> list;

    private LayoutInflater inflater;
    private MainListClickListener listener;
    private ArrayList<UniversalPartners> partners;

    public MainMenuAdapter(Context context, ArrayList<MainMenuItem> list) {
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

        MainMenuItem mainMenuItem = list.get(position);

        holder.categoryName.setText(mainMenuItem.getCategoryName());
        partners = mainMenuItem.getPartners();
        holder.list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.list.setHasFixedSize(true);

        PartnerAdapter partnerAdapter = new PartnerAdapter();
        partnerAdapter.setPartnerClickListener(partnerPosition -> {
            int id = mainMenuItem.getPartners().indexOf(mainMenuItem.getPartners().get(partnerPosition));

            if (id >= 0) listener.onMainListClick(id);

        });
        holder.list.setAdapter(partnerAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {


        @BindView(R.id.categoryName)
        TextView categoryName;

        @BindView(R.id.list)
        RecyclerView list;

        @BindView(R.id.seeAll)
        Button seeAll;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface MainListClickListener {

        void onMainListClick(int position);


    }

    public interface PartnerClickListener {

        void onPartnerClick(int position);


    }

    public void setMainListClickListener(MainListClickListener listener) {
        this.listener = listener;
    }


    public class PartnerAdapter extends RecyclerView.Adapter<PartnerAdapter.Holder> {


        PartnerClickListener listener;

        @Override
        public PartnerAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(inflater.inflate(R.layout.item_partners, parent, false));
        }

        @Override
        public void onBindViewHolder(PartnerAdapter.Holder holder, int position) {
            UniversalPartners partner = partners.get(position);

            holder.name.setText(partner.getPartnerName());
            holder.logo.setImageDrawable(context.getResources().getDrawable(partner.getPartnerLogo()));
            holder.container.setOnClickListener(view -> {
                listener.onPartnerClick(holder.getAdapterPosition());
            });
        }

        @Override
        public int getItemCount() {
            return partners.size();
        }

        public class Holder extends RecyclerView.ViewHolder {
            @BindView(R.id.name)
            TextView name;

            @BindView(R.id.logo)
            AppCompatImageView logo;

            @BindView(R.id.container)
            ViewGroup container;

            public Holder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);

            }
        }

        public void setPartnerClickListener(PartnerClickListener listener) {
            this.listener = listener;
        }
    }
}
