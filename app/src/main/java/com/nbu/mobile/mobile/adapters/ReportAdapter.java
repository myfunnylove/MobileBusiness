package com.nbu.mobile.mobile.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nbu.mobile.R;
import com.nbu.mobile.mobile.models.Report;
import com.nbu.mobile.mobile.models.UniversalPartners;

import java.util.ArrayList;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by macbookpro on 04.09.17.
 */

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.Holder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Report> reports;
    private ReportClickListener listener;
    public ReportAdapter(Context context,ArrayList<Report> reports) {
        this.reports = reports;

        this.context = context;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.item_report_list,parent,false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Report report = reports.get(position);

        holder.logo.setImageDrawable(context.getResources().getDrawable(report.getPartnerLogo()));
        holder.dateTime.setText(report.getDataTime());
        holder.partnerName.setText(report.getPartnerName());
        holder.summa.setText(report.getSumma());
        switch (report.getStatus()){
            case Report.SUCCESS:
                holder.summa.setTextColor(context.getResources().getColor(R.color.successC));
                break;
            case Report.ERROR:
                holder.summa.setTextColor(context.getResources().getColor(R.color.errorC));

                break;
            case Report.WAITING:
                holder.summa.setTextColor(context.getResources().getColor(R.color.waitingC));

                break;


        }

        holder.container.setOnClickListener((view) -> {
           listener.onReportClick(holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.container)
        ViewGroup container;

        @BindView(R.id.logo)
        ImageView logo;

        @BindView(R.id.partnerName)
        TextView partnerName;

        @BindView(R.id.dateTime)
        TextView dateTime;

        @BindView(R.id.summa)
        TextView summa;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface ReportClickListener{

        void onReportClick(int position);


    }

    public void setReportClickListener(ReportClickListener listener){
        this.listener = listener;
    }
}
