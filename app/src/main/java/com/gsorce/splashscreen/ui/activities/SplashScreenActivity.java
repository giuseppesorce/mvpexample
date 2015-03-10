/*
 *
 *  * Copyright (C) 2015 Giuseppe Sorce
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */
package com.gsorce.splashscreen.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gsorce.splashscreen.R;
import com.gsorce.splashscreen.interfaces.OnPresenter;
import com.gsorce.splashscreen.presenters.SplashPresenter;

/**
 * Created by Giuseppe Sorce  on 09/02/15.
 *
 */
public class SplashScreenActivity extends Activity implements OnPresenter {

    private SplashPresenter initPresenter;
    private ProgressBar progress;
    private TextView tvMesssage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SplashScreen");
        findViews();
        //create the Presenter class
        initPresenter = new SplashPresenter(this);
        startInitConfiguration();
    }

    private void startInitConfiguration() {
        //delegate logic to presenter
        initPresenter.startConfiguation();
    }

    private void findViews() {
        progress = (ProgressBar) findViewById(R.id.progress);
        tvMesssage = (TextView) findViewById(R.id.tvMesssage);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgress() {

        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void completeConfiguration() {

        startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
    }


    @Override
    public void showMessage(String message) {

        tvMesssage.setText(message);
    }
}