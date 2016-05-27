package com.qoobico.remindme.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qoobico.remindme.R;
import com.qoobico.remindme.dto.NewsDTO;
import com.qoobico.remindme.dto.RemindDTO;

import java.util.List;

/**
 * Created by neil on 5/14/16.
 */
public class NewListAdapter extends RecyclerView.Adapter<NewListAdapter.NewViewHolder> {


    private List<NewsDTO> data;

    public NewListAdapter(List<NewsDTO> data) {
        this.data = data;
    }

    @Override
    public NewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false );
        return new NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewViewHolder holder, int position) {
        NewsDTO item = data.get(position);
        holder.title.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class NewViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView title;


        public NewViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView1);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }


}
