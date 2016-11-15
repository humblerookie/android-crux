package com.hr.crux.core.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import icepick.Icepick;


public abstract class BaseActivity extends AppCompatActivity {

    public boolean isAlive() {
        return !isFinishing() && !isDestroyed();

    }
    @Override
    protected void onRestart() {
        super.onRestart();
    }
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }
}
