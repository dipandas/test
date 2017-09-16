package westviewfamilymedicine.com.mvpsample.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by android on 15/9/17.
 */

public class GetDataResult {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("data")
    @Expose
    private List<GetAllData> data = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<GetAllData> getData() {
        return data;
    }

    public void setData(List<GetAllData> data) {
        this.data = data;
    }


}
