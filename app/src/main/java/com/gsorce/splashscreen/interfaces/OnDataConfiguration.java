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

package com.gsorce.splashscreen.interfaces;

import com.gsorce.splashscreen.models.DataConfiguration;

/**
 * Created by Giuseppe Sorce  on 09/02/15.
 */
public interface OnDataConfiguration {

    public void onConfigurationFailed();
    public void onConfigurationComplete(DataConfiguration data);
    public void onConfigurationEnded();

}
