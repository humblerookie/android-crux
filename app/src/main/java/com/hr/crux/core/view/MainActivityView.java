package com.hr.crux.core.view;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.hr.crux.core.model.GResult;

import java.util.List;

public interface MainActivityView extends MvpLceView<List<GResult.GooglePlacesResult>> {

    /**
     * Everything needed is provided by LceView
     * This interface is just for consistent name.
     * */
}
