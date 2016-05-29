package com.hr.crux.adapters;

import android.content.pm.ApplicationInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hr.crux.R;

import java.util.ArrayList;
import java.util.List;

public class AppsListAdapter extends RecyclerView.Adapter<AppsListAdapter.ViewHolder> {

    List<ApplicationInfo> data = new ArrayList<>();

    public AppsListAdapter(List<ApplicationInfo> applicationInfos) {
        data = applicationInfos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


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


}
