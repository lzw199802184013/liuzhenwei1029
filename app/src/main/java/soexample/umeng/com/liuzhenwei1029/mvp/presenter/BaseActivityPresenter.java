package soexample.umeng.com.liuzhenwei1029.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import soexample.umeng.com.liuzhenwei1029.mvp.IView.ADeleGate;

public abstract class BaseActivityPresenter<T extends ADeleGate> extends AppCompatActivity {

    private T deleGate;

    //一个activity对于一个presenter
    public abstract Class<T> getClassDeleGate();

    public BaseActivityPresenter() {
        try {
            deleGate = getClassDeleGate().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deleGate.create(getLayoutInflater(), null, savedInstanceState);
        setContentView(deleGate.rootView());
        deleGate.getContext(this);
        deleGate.initData();
    }
}
