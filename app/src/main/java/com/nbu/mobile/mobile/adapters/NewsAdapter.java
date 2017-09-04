package com.nbu.mobile.mobile.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nbu.mobile.R;
import com.nbu.mobile.mobile.models.News;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sarvar on 04.09.2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Holder> {

    private Context context;
    private LayoutInflater inflater;

    private ArrayList<News> list;

    public NewsAdapter(Context context, ArrayList<News> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.item_news,parent,false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        News news = list.get(position);
        holder.description.setText(news.getDescription());
        holder.header.setText(news.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.header)
        TextView header;

        @BindView(R.id.description)
        TextView description;


        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
