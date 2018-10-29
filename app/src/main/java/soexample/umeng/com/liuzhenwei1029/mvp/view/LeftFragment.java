package soexample.umeng.com.liuzhenwei1029.mvp.view;

import soexample.umeng.com.liuzhenwei1029.mvp.presenter.BaseFragmentPresenter;

public class LeftFragment extends BaseFragmentPresenter<LeftFragmentPresenter> {
    @Override
    public Class<LeftFragmentPresenter> getClassDeleGate() {
        return LeftFragmentPresenter.class;
    }
}
