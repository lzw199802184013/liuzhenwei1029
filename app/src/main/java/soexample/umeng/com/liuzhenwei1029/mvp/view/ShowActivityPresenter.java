package soexample.umeng.com.liuzhenwei1029.mvp.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.liuzhenwei1029.R;
import soexample.umeng.com.liuzhenwei1029.ShowView;
import soexample.umeng.com.liuzhenwei1029.mvp.IView.ADeleGate;

public class ShowActivityPresenter  extends ADeleGate implements View.OnClickListener {
    private ShowView showview;
    private EditText et_text;
    private List<String> stringList = new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_show;
    }

    @Override
    public void initData() {
        super.initData();
        showview=(ShowView)get(R.id.showview);
        et_text=(EditText)get(R.id.et_text);
        setClick(this,R.id.sousuo);
    }

    private  Context context;
    @Override
    public void getContext(Context context) {
            this.context = context;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sousuo:
                String desc = et_text.getText().toString().trim();
                if (TextUtils.isEmpty(desc)){
                    toast(context,"输入内容不能为空");
                    return;
                }
                stringList.add(desc);
                showview.setListData(stringList);
                break;
        }
    }
}
