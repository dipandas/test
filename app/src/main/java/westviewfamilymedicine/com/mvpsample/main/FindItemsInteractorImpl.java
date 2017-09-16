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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import westviewfamilymedicine.com.mvpsample.Model.GetAllData;
import westviewfamilymedicine.com.mvpsample.Model.GetDataRequest;
import westviewfamilymedicine.com.mvpsample.retrofit.RestHandler;
import westviewfamilymedicine.com.mvpsample.retrofit.RetrofitListener;

public class FindItemsInteractorImpl implements FindItemsInteractor,RetrofitListener {

    RestHandler rest;
    Context con;
    private OnFinishedListener loc_listner;
    private MainView mainView;
    @Override
    public void findItems(final OnFinishedListener listener) {

           loc_listner = listener;
           getData();
    }

    private void getData() {
        rest = new RestHandler(con, this);
        rest.makeHttpRequest(rest.retrofit.create(RestHandler.RestInterface.class).
                getData("7"),"get_job");

    }

    @Override
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
    }
}
