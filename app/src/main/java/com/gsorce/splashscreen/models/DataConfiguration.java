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
package com.gsorce.splashscreen.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Giuseppe Sorce  on 09/02/15.
 */
public class DataConfiguration {


    private long lastUpdate;


    public DataConfiguration(long time) {
        lastUpdate= time;
    }


    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getStringLastUpdate(){
        SimpleDateFormat postFormater = new SimpleDateFormat("dd/MM/yyyy");
       return  postFormater.format(new Date(lastUpdate));
    }
}
