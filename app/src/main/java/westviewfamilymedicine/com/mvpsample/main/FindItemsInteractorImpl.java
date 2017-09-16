/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
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

package westviewfamilymedicine.com.mvpsample.main;

import android.content.Context;

import westviewfamilymedicine.com.mvpsample.Api.APIListener;
import westviewfamilymedicine.com.mvpsample.retrofit.RestHandler;

public class FindItemsInteractorImpl implements FindItemsInteractor{

    RestHandler rest;
    Context con;
    private OnFinishedListener loc_listner;
    private MainView mainView;
    @Override
    public void findItems(final OnFinishedListener listener) {

           loc_listner = listener;
           APIListener apiListner = new APIListener();
           apiListner.getData(loc_listner);
    }


}
