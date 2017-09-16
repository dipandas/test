package westviewfamilymedicine.com.mvpsample.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import westviewfamilymedicine.com.mvpsample.Model.GetAllData;
import westviewfamilymedicine.com.mvpsample.R;
import westviewfamilymedicine.com.mvpsample.Utils.Constants;

/**
 * Created by android on 15/9/17.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder>{

    List<GetAllData> data;
    private Context mContext;
    private OnRowClickListener mListener;

    public ImageAdapter(Context con, List<GetAllData> items) {
        if(con!=null) {
            mContext = con;
            data = items;
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_of_list, parent, false);
        ViewHolder vh = new ViewHolder(v);


        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.itemView.setBackgroundResource(position % 2 == 0 ?
                R.color.transparent : R.color.service_provider_row_bg);
        holder.txt_job_title.setText(data.get(position).getJobTitle());
        holder.txt_appointment_text.setText(data.get(position).getJobDate());
        holder.txt_property_name.setText(data.get(position).getPropertyName());
        holder.txt_job_type.setText(data.get(position).getService());
        holder.txt_property_owner_name.setText(data.get(position).getFirstName() + " " + data.get(position).getLastName());

        Constants.setSquareImageGlide(holder.img,Constants.property_image__image_url,data.get(position).getJobImage().get(0).getPropertyImage(),mContext);


        holder.ll_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.onOwnerClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 0;
        return data.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_job_title,txt_property_name,txt_appointment_text,txt_property_owner_name,
                txt_hire_me,txt_detail,txt_job_type;
        public ImageView img;
        public LinearLayout ll_row, ll_owner;

        public ViewHolder(View view) {
            super(view);

            ll_row = (LinearLayout) view;
            ll_owner = (LinearLayout) view.findViewById(R.id.ll_owner);
            img =(ImageView) view.findViewById(R.id.img);
            txt_job_title = (TextView) view.findViewById(R.id.txt_job_title);
            txt_property_name = (TextView) view.findViewById(R.id.txt_property_name);
            txt_appointment_text = (TextView) view.findViewById(R.id.txt_appointment_text);
            txt_property_owner_name = (TextView) view.findViewById(R.id.txt_property_owner_name);
            txt_job_type = (TextView) view.findViewById(R.id.txt_job_type);
            txt_hire_me = (TextView) view.findViewById(R.id.txt_hire_me);
            txt_detail = (TextView) view.findViewById(R.id.txt_detail);
        }
    }

    public void setOnRowClickListenere(OnRowClickListener mListener){
        this.mListener = mListener;
    }

    public interface OnRowClickListener{

        void onOwnerClick(int position);
    }

    public void notifyDataChange(List<GetAllData> colList){
        this.data = colList;
        notifyDataSetChanged();
    }

}
