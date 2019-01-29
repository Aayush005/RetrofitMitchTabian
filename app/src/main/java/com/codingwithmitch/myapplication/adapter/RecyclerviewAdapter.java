package com.codingwithmitch.myapplication.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import com.codingwithmitch.myapplication.R;
import com.codingwithmitch.myapplication.model.Posts;


import java.util.List;

/**
 * Created by Aayush on 18/01/2019.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.CustomViewHolder> {

    private List<Posts> dataList;
    private Context context;

    public RecyclerviewAdapter(Context context, List<Posts> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtTitle,txtBody;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            txtTitle = mView.findViewById(R.id.title);
            txtBody = mView.findViewById(R.id.description);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());
        holder.txtBody.setText(dataList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}