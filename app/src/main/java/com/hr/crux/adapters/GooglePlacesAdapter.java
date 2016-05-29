package com.hr.crux.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hr.crux.R;
import com.hr.crux.core.model.GResult;

import java.util.List;

public class GooglePlacesAdapter extends RecyclerView.Adapter<GooglePlacesAdapter.ViewHolder> {

    List<GResult.GooglePlacesResult> data;

    public GooglePlacesAdapter(List<GResult.GooglePlacesResult> applicationInfos) {
        data = applicationInfos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(data.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.app_name);

        }
    }


    public void setData(List<GResult.GooglePlacesResult> results) {
        data = results;
        notifyDataSetChanged();
    }

}
