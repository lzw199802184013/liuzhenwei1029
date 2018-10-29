package soexample.umeng.com.liuzhenwei1029.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.liuzhenwei1029.R;
import soexample.umeng.com.liuzhenwei1029.model.PuBean;

public class PuAdapter extends RecyclerView.Adapter<PuAdapter.MyViewHolder> {
    private Context context;
    private List<PuBean.ResultsBean> results= new ArrayList<>();
    public PuAdapter(Context context) {
            this.context= context;
    }

    @NonNull
    @Override
    public PuAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context,R.layout.layout_item2,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PuAdapter.MyViewHolder myViewHolder, int i) {
        Glide.with(context).load(results.get(i).getUrl()).fitCenter().into(myViewHolder.iv_img2);
        myViewHolder.tv_title2.setText(results.get(i).getType());
        myViewHolder.tv_price.setText(results.get(i).getDesc());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setList(List<PuBean.ResultsBean> list) {
        this.results = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        ImageView iv_img2;
        TextView tv_title2,tv_price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_img2 = (ImageView) itemView.findViewById(R.id.iv_img2);
            tv_title2=(TextView)itemView.findViewById(R.id.tv_title2);
            tv_price=(TextView)itemView.findViewById(R.id.tv_price);
        }
    }
}
