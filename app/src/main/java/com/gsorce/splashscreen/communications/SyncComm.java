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

package com.gsorce.splashscreen.communications;

import android.os.Handler;

import com.gsorce.splashscreen.interfaces.OnDataConfiguration;
import com.gsorce.splashscreen.models.DataConfiguration;

import java.util.Date;

/**
 * Created by Giuseppe Sorce on 09/02/15.
 */
public class SyncComm {


    private final OnDataConfiguration listener;

    public SyncComm(OnDataConfiguration listener) {
        this.listener= listener;

    }

    public void doGetConfiguration() {

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {

                // you can customize this method to get data from a Web Services.
                // code simulates a failed connection
                listener.onConfigurationFailed();
            }
        }, 2000);
    }

    public void doGetLocalConfiguration( ) {

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {

                // customize this method to parse, save data.
                // in this example i create a fake data
                DataConfiguration data = new DataConfiguration(new Date().getTime());
                listener.onConfigurationComplete(data);
            }
        }, 2000);
    }

    public void saveData( ) {

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {


                listener.onConfigurationEnded();
            }
        }, 4000);
    }

}
