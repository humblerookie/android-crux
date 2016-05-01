package com.hr.crux.adapters;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hr.crux.Application;
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

        try {
            holder.imageView.setImageDrawable(Application.getInstance().getPackageManager().getApplicationIcon(data.get(position).packageName));
            holder.textView.setText(Application.getInstance().getPackageManager().getApplicationLabel(data.get(position)));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.app_name);
            imageView = (ImageView) itemView.findViewById(R.id.app_icon);
        }
    }


}
