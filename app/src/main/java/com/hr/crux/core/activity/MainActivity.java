package com.hr.crux.core.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hr.crux.R;
import com.hr.crux.adapters.GooglePlacesAdapter;
import com.hr.crux.core.model.GResult;
import com.hr.crux.core.presenter.MainActivityPresenter;
import com.hr.crux.core.view.MainActivityView;
import com.jakewharton.rxbinding.support.v7.widget.RxSearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        list.setLayoutManager(new LinearLayoutManager(this));

        adapter = new GooglePlacesAdapter(new ArrayList<>());

        list.setAdapter(adapter);

        contentView = list;


    }

    @NonNull
    @Override
    public MvpPresenter<MainActivityView> createPresenter() {

        return new MainActivityPresenter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        // Retrieve the SearchView and plug it into SearchManager
        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));

        RxSearchView.queryTextChanges(searchView)
                .debounce(500, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe(f -> {
                    ((MainActivityPresenter) getPresenter()).onTextChanged(f.toString());
                });

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showContent() {
        contentView.setVisibility(View.VISIBLE);
        progressView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        progressView.setVisibility(View.GONE);
        contentView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setData(List<GResult.GooglePlacesResult> data) {
        adapter.setData(data);
    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }
}
