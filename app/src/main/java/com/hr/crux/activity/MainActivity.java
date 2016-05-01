package com.hr.crux.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hr.crux.Application;
import com.hr.crux.R;
import com.hr.crux.adapters.AppsListAdapter;
import com.hr.crux.loaders.AppUtils;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    RecyclerView list;

    @Inject
    AppUtils appUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViews();

        Application.getInstance().getComponent().inject(this);

        list.setLayoutManager(new LinearLayoutManager(this));

        list.setAdapter(new AppsListAdapter(appUtils.getApps()));
    }

    private void initViews() {
        list = (RecyclerView) findViewById(R.id.list);
    }
}
