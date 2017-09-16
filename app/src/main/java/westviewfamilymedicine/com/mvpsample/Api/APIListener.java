package westviewfamilymedicine.com.mvpsample.Api;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import westviewfamilymedicine.com.mvpsample.Model.GetAllData;
import westviewfamilymedicine.com.mvpsample.Model.GetDataRequest;
import westviewfamilymedicine.com.mvpsample.main.FindItemsInteractor;
import westviewfamilymedicine.com.mvpsample.main.MainView;
import westviewfamilymedicine.com.mvpsample.retrofit.RestHandler;
import westviewfamilymedicine.com.mvpsample.retrofit.RetrofitListener;


public class APIListener implements RetrofitListener {


    static RestHandler rest;
    static Context con;
    private static FindItemsInteractor.OnFinishedListener getData_listener;
    private MainView mainView;

    public void getData(FindItemsInteractor.OnFinishedListener loc_listner) {
        rest = new RestHandler(con, this);
        getData_listener = loc_listner;
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
                        getData_listener.onFinished(data);
                    }
                } else {

                    mainView.hideProgress();
                    mainView.showMessage("Data not found");
                }

                }
            }
        }


    @Override
    public void onFailure(String errorMessage) {

        // Dialogs.displayAlert(this,false,"Alert",t.getMessage());
        mainView.hideProgress();
        mainView.showMessage(errorMessage);
    }
}
