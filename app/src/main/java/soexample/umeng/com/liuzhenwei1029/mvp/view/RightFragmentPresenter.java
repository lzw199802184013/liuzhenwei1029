package soexample.umeng.com.liuzhenwei1029.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import soexample.umeng.com.liuzhenwei1029.R;
import soexample.umeng.com.liuzhenwei1029.mvp.IView.ADeleGate;

public class RightFragmentPresenter extends ADeleGate implements View.OnClickListener {
    @Override
    public int getLayoutId() {
        return R.layout.layout_right;
    }

    @Override
    public void initData() {
        super.initData();
        setClick(this,R.id.liulan);
    }
    private  Context context;
    @Override
    public void getContext(Context context) {
        this.context= context;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.liulan:
                    context.startActivity(new Intent(context,ShowActivity.class));
                break;
        }
    }
}
