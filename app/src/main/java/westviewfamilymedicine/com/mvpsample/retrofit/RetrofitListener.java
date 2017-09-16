package westviewfamilymedicine.com.mvpsample.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import westviewfamilymedicine.com.mvpsample.Model.GetAllData;

/**
 * Created by Uzibaba on 1/8/2017.
 */

public interface RetrofitListener {
    void onSuccess(Call call, Response response, String method);
    void onFailure(String errorMessage);
}
