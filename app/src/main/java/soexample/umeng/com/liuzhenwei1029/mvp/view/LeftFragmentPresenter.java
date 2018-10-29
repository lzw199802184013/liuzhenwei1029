package soexample.umeng.com.liuzhenwei1029.mvp.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import soexample.umeng.com.liuzhenwei1029.R;
import soexample.umeng.com.liuzhenwei1029.adapter.JiuAdapter;
import soexample.umeng.com.liuzhenwei1029.adapter.PuAdapter;
import soexample.umeng.com.liuzhenwei1029.model.ImageBean;
import soexample.umeng.com.liuzhenwei1029.model.JiuBean;
import soexample.umeng.com.liuzhenwei1029.model.PuBean;
import soexample.umeng.com.liuzhenwei1029.mvp.IView.ADeleGate;
import soexample.umeng.com.liuzhenwei1029.net.HttpUtils;

public class LeftFragmentPresenter extends ADeleGate {
    private BGABanner bgabanner;
    private GridView gridview;
    private RecyclerView recyclerview;
    private String imageUrl = "http://www.zhaoapi.cn/ad/getAd";
    private  String jiuUrl="http://www.zhaoapi.cn/product/getCatagory";
    private  String dataUrl="https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1";
    private List<ImageBean.DataBean> data1 = new ArrayList<>();
    private List<String> mTiltle = new ArrayList<>();
    private List<JiuBean.DataBean> data2 = new ArrayList<>();
    private JiuAdapter jiuAdapter;
    private List<PuBean.ResultsBean> results = new ArrayList<>();
    private PuAdapter puAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.layout_left;
    }

    @Override
    public void initData() {
        super.initData();
        bgabanner = (BGABanner) get(R.id.bgabanner);
        doImage();
        gridview = (GridView) get(R.id.gridview);
        doJiu();
        recyclerview = (RecyclerView) get(R.id.recyclerview);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);

        doPu();
    }



    //轮播图
    private void doImage() {
        new HttpUtils().get(imageUrl).result(new HttpUtils.HttpListener() {
            @Override
            public void success(String data) {
                Gson gson = new Gson();
                ImageBean imageBean = gson.fromJson(data, ImageBean.class);
                data1 = imageBean.getData();
                for (int a = 0; a < data1.size(); a++) {
                    String title = data1.get(a).getTitle();
                    mTiltle.add(title);
                }
                bgabanner.setAdapter(new BGABanner.Adapter() {
                    @Override
                    public void fillBannerItem(BGABanner banner, View itemView, @Nullable Object model, int position) {
                        String icon = data1.get(position).getIcon();
                        String replace = icon.replace("https", "http");
                        Glide.with(context).load(replace).fitCenter().into((ImageView) itemView);
                    }
                });
                bgabanner.setData(data1, mTiltle);
            }

            @Override
            public void fail() {

            }
        });


    }
    //九宫格
    private void doJiu() {
        new HttpUtils().get(jiuUrl).result(new HttpUtils.HttpListener() {
            @Override
            public void success(String data) {
                Gson gson = new Gson();
                JiuBean jiuBean = gson.fromJson(data, JiuBean.class);
                 data2 = jiuBean.getData();
                 jiuAdapter = new JiuAdapter(context,data2);
                 gridview.setAdapter(jiuAdapter);
            }

            @Override
            public void fail() {

            }
        });
    }
    //瀑布流
    private void doPu() {
        new HttpUtils().get(dataUrl).result(new HttpUtils.HttpListener() {
            @Override
            public void success(String data) {
                    Gson gson = new Gson();
                PuBean puBean = gson.fromJson(data, PuBean.class);
                results = puBean.getResults();
                puAdapter = new PuAdapter(context);
                puAdapter.setList(results);
                recyclerview.setAdapter(puAdapter);
            }

            @Override
            public void fail() {

            }
        });
    }
    private Context context;

    @Override
    public void getContext(Context context) {
        this.context = context;
    }
}
