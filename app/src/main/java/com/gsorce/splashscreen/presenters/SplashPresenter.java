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

package com.gsorce.splashscreen.presenters;

import com.gsorce.splashscreen.communications.SyncComm;
import com.gsorce.splashscreen.interfaces.OnDataConfiguration;
import com.gsorce.splashscreen.interfaces.OnPresenter;
import com.gsorce.splashscreen.models.DataConfiguration;

/**
 * Created by Giuseppe Sorce on 09/02/15.
 */
public class SplashPresenter implements OnDataConfiguration{
    private final OnPresenter view;
    private final SyncComm sync;

    public SplashPresenter(OnPresenter view) {
        this.view = view;
        sync= new SyncComm(this);
    }

    public void startConfiguation() {

        view.showProgress();
        view.showMessage("load configuration");
        sync.doGetConfiguration();
    }

    @Override
    public void onConfigurationFailed() {
       view.showMessage("load configuration failed");
       sync.doGetLocalConfiguration();
    }

    @Override
    public void onConfigurationComplete(DataConfiguration data) {
        view.hideProgress();
        view.showMessage("Last update: "+data.getStringLastUpdate());
        sync.saveData();

    }

    @Override
    public void onConfigurationEnded() {

        view.completeConfiguration();
    }
}