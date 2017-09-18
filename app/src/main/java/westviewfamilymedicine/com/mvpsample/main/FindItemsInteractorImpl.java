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



    /*@Override
    public void onSuccess(Call call, Response response, String method) {
        List<GetAllData> data = null;
        if (response != null && response.code() == 200) {
            data = new ArrayList<>();
            if (method.equalsIgnoreCase("get_job")) {
                GetDataRequest getdate_obj = (GetDataRequest) response.body();
                if (!getdate_obj.getResult().getError()) {
                    if (!getdate_obj.getResult().getError()) {


                        data = getdate_obj.getResult().getData();
                        loc_listner.onFinished(data);
                    }
                } else {

                    Toast.makeText(con, "Data Not Found", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }

    @Override
    public void onFailure(String errorMessage) {

       // Dialogs.displayAlert(this,false,"Alert",t.getMessage());
        mainView.hideProgress();
        Toast.makeText(con,"Failure",Toast.LENGTH_SHORT).show();
    }*/
}
