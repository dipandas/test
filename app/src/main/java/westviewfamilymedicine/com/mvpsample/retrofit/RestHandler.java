package westviewfamilymedicine.com.mvpsample.retrofit;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import westviewfamilymedicine.com.mvpsample.Model.GetDataRequest;
import westviewfamilymedicine.com.mvpsample.R;

/**
 * Created by Android on 15/9/2017.
 */

public class RestHandler {

   public Retrofit retrofit;
    RetrofitListener retroListener;
    String method_name;
    Context mContext;

    public RestHandler(Context con, RetrofitListener retroListener ){

        this.retroListener=retroListener;
        mContext=con;

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.bnb.dedicatedresource.net/api/v2/provider/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public interface RestInterface {


        @FormUrlEncoded
        @POST("job/look_job")
        Call<GetDataRequest> getData(@Field("user_id") String user_id);

    }

    public void makeHttpRequest(Call call,String method)
    {
        this.method_name =method;
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                if(response!=null && response.code()==200)
                retroListener.onSuccess(call,response, method_name);
                else if(response!=null)
                    retroListener.onFailure(response.code()+" "+response.message());
                else
                    retroListener.onFailure(mContext.getString(R.string.err_msg));
            }

            @Override
            public void onFailure(Call call, Throwable t) {

                    if (t instanceof NoRouteToHostException) {
                        retroListener.onFailure(mContext.getString(R.string.server_unreachable));
                    } else if (t instanceof SocketTimeoutException) {
                        retroListener.onFailure(mContext.getString(R.string.timed_out));
                    } else if (t instanceof IOException) {
                        retroListener.onFailure(mContext.getString(R.string.no_internet));
                    }
                    else if(t instanceof Exception)
                        retroListener.onFailure("Invalid response from server.");
                    else
                    retroListener.onFailure(t.getMessage());

                }
        });
    }
}
