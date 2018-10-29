package soexample.umeng.com.liuzhenwei1029.mvp.view;

import soexample.umeng.com.liuzhenwei1029.mvp.presenter.BaseActivityPresenter;
import soexample.umeng.com.liuzhenwei1029.mvp.presenter.BaseFragmentPresenter;

public class ShowActivity extends BaseActivityPresenter<ShowActivityPresenter> {
    @Override
    public Class<ShowActivityPresenter> getClassDeleGate() {
        return ShowActivityPresenter.class;
    }
}
