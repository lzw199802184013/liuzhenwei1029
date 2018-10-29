package soexample.umeng.com.liuzhenwei1029.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import soexample.umeng.com.liuzhenwei1029.R;
import soexample.umeng.com.liuzhenwei1029.mvp.presenter.BaseActivityPresenter;

public class MainActivity extends BaseActivityPresenter<MainActivityPresenter> {

    @Override
    public Class<MainActivityPresenter> getClassDeleGate() {
        return MainActivityPresenter.class;
    }
}
