package com.example.duoihinhbatchu.view.fragment;

import android.view.View;
import android.widget.Button;

import com.example.duoihinhbatchu.OnActionCallBack;
import com.example.duoihinhbatchu.R;
import com.example.duoihinhbatchu.viewmodel.MenuViewModel;

public class M002MenuFragment extends BaseFragment<MenuViewModel>{

    public static final String KEY_SHOW_MAIN = "KEY_SHOW_MAIN";
    private OnActionCallBack mCallBack;

    public void setmCallBack(OnActionCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override
    protected void initViews() {
        findViewById(R.id.bt_play,this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_play){
            mCallBack.onCallBack(KEY_SHOW_MAIN,null,false,0,null);
        }
    }

    @Override
    protected Class<MenuViewModel> getClassViewModel() {
        return MenuViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m002_menu_act;
    }
}
