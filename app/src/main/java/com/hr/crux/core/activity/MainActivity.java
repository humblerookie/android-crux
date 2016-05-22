package com.hr.crux.core.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.hr.crux.R;
import com.hr.crux.adapters.GooglePlacesAdapter;
import com.hr.crux.core.model.GooglePlacesResult;
import com.hr.crux.core.presenter.MainActivityPresenter;
import com.hr.crux.core.view.MainActivityView;
import com.jakewharton.rxbinding.support.v7.widget.RxSearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends BaseActivity<MainActivityView, MainActivityPresenter> implements MainActivityView {


    /**
     * View  Injections
     */
    @BindView(R.id.list)
    RecyclerView list;

    @BindView(R.id.app_bar)
    Toolbar toolbar;

    @BindView(R.id.progress_view)
    View progressView;

    View contentView;

    @BindView(R.id.error_view)
    View errorView;

    private SearchView searchView;

    private GooglePlacesAdapter adapter;

    private MainActivityPresenter mainPresenter;

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViews();

        initMvp();

    }

    private void initViews() {

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        list.setLayoutManager(new LinearLayoutManager(this));

        adapter = new GooglePlacesAdapter(new ArrayList<>());

        list.setAdapter(adapter);

        contentView = list;


    }

    private void initMvp() {

        mainPresenter = (MainActivityPresenter) presenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @NonNull
    @Override
    public MainActivityPresenter createPresenter() {

        return new MainActivityPresenter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        // Retrieve the SearchView and plug it into SearchManager
        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));


        RxSearchView.queryTextChanges(searchView)
                .debounce(3000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe(f -> {
                    mainPresenter.onTextChanged(f.toString());
                });

        return true;
    }


    @Override
    public void showProgress() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showData(List<GooglePlacesResult> data) {
        progressView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        adapter.setData(data);
    }

    @Override
    public void showError() {
        progressView.setVisibility(View.GONE);
        contentView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
    }
}
