package soexample.umeng.com.liuzhenwei1029.mvp.view;

import soexample.umeng.com.liuzhenwei1029.mvp.presenter.BaseFragmentPresenter;

public class RightFragment extends BaseFragmentPresenter<RightFragmentPresenter> {
    @Override
    public Class<RightFragmentPresenter> getClassDeleGate() {
        return RightFragmentPresenter.class;
    }
}
