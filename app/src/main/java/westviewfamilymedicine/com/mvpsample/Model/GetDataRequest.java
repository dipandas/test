package westviewfamilymedicine.com.mvpsample.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by android on 15/9/17.
 */

public class GetDataRequest {

    @SerializedName("result")
    @Expose
    private GetDataResult result;

    public GetDataResult getResult() {
        return result;
    }

    public void setResult(GetDataResult result) {
        this.result = result;
    }


}
