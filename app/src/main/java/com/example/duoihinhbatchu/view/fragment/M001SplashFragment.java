package com.example.duoihinhbatchu.view.fragment;

import android.os.Handler;

import com.example.duoihinhbatchu.OnActionCallBack;
import com.example.duoihinhbatchu.R;
import com.example.duoihinhbatchu.viewmodel.SplashViewModel;

public class M001SplashFragment extends BaseFragment<SplashViewModel>{
    public static final String KEY_SHOW_MENU_FRAGMENT = "KEY_SHOW_MENU_FRAGMENT";
    private OnActionCallBack mCallBack;

    public void setmCallBack(OnActionCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override
    protected void initViews() {
        new Handler().postDelayed(this::gotoMainFragment, 2000);
    }

    @Override
    protected Class<SplashViewModel> getClassViewModel() {
        return SplashViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m001_splash_act;
    }

    private void gotoMainFragment() {
        mCallBack.onCallBack(KEY_SHOW_MENU_FRAGMENT, null,false,0,null);
    }
}
