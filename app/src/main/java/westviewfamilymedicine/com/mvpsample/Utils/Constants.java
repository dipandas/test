package westviewfamilymedicine.com.mvpsample.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import westviewfamilymedicine.com.mvpsample.R;

/**
 * Created by android on 15/9/17.
 */

public class Constants {

    public static String property_image__image_url = "http://bnb.dedicatedresource.net/uploads/property_image/thumb/";

    public static void setSquareImageGlide(ImageView image, String image_url, String image_name, Context c)
    {
        if(image_name!=null && image_name.length()>0) {

            String url= image_url+image_name;

            Glide.with(c)
                    .load(url)
                    .error(R.drawable.no_image)
                    .placeholder(R.drawable.no_image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(image);
        }
        else{
            Glide.with(c)
                    .load(R.drawable.no_image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(image);
        }
    }
}
