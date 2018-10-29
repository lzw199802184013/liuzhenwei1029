package soexample.umeng.com.liuzhenwei1029.mvp.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.liuzhenwei1029.R;
import soexample.umeng.com.liuzhenwei1029.mvp.IView.ADeleGate;

public class MainActivityPresenter extends ADeleGate {
    private ViewPager view_vp;
    private TabLayout tablayout;
    private String[] dataTitle = {"首页", "我的"};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        super.initData();
        view_vp = (ViewPager) get(R.id.view_vp);
        tablayout = (TabLayout) get(R.id.tablayout);
        fragments.add(new LeftFragment());
        fragments.add(new RightFragment());
        view_vp.setAdapter(new FragmentPagerAdapter(((MainActivity) context).getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return dataTitle[position];
            }
        });
        tablayout.setupWithViewPager(view_vp);
    }

    private Context context;

    @Override
    public void getContext(Context context) {
        this.context = context;
    }
}
