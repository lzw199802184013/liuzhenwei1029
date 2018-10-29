package soexample.umeng.com.liuzhenwei1029.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.liuzhenwei1029.R;
import soexample.umeng.com.liuzhenwei1029.model.JiuBean;

public class JiuAdapter extends BaseAdapter {
    private Context context;
    private List<JiuBean.DataBean> data2 = new ArrayList<>();

    public JiuAdapter(Context context, List<JiuBean.DataBean> data2) {
        this.context = context;
        this.data2 = data2;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data2.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view==null){
            viewHolder = new ViewHolder();
            view = View.inflate(context, R.layout.layout_item,null);
            viewHolder.iv_img=view.findViewById(R.id.iv_img);
            viewHolder.tv_title=view.findViewById(R.id.tv_title);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();

        }
        JiuBean.DataBean dataBean = data2.get(i);
        Glide.with(context).load(dataBean.getIcon()).fitCenter().into(viewHolder.iv_img);
        viewHolder.tv_title.setText(dataBean.getName());

        return view;
    }
    public class  ViewHolder{
            ImageView iv_img;
            TextView tv_title;

    }
}
