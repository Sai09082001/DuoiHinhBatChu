package com.example.duoihinhbatchu.view.act;

import com.example.duoihinhbatchu.OnActionCallBack;
import com.example.duoihinhbatchu.R;
import com.example.duoihinhbatchu.view.fragment.M001SplashFragment;
import com.example.duoihinhbatchu.view.fragment.M002MenuFragment;
import com.example.duoihinhbatchu.view.fragment.M003MainFragment;
import com.example.duoihinhbatchu.view.fragment.M004HighScoreFragment;
import com.example.duoihinhbatchu.viewmodel.MainActivityViewModel;


public class MainActivity  extends BaseAct<MainActivityViewModel> implements OnActionCallBack {

        @Override
        protected Class<MainActivityViewModel> getClassViewModel() {
            return MainActivityViewModel.class;
        }

        @Override
        protected int getLayoutID() {
            return R.layout.act_main;
        }

        @Override
        protected void initViews() {
            M001SplashFragment splashFragment = new M001SplashFragment();
            splashFragment.setmCallBack(this);
            // chi co activity ms co the show fragment
            showFragment(R.id.container_view, splashFragment, false);
            // bay gio Fragment ms đc gọi khoi tao view
        }


    @Override
    public void onCallBack(String key, Object Object,boolean bool,int viTri,String txt) {
        switch (key) {
            case M001SplashFragment.KEY_SHOW_MENU_FRAGMENT:
                M002MenuFragment menuFragment = new M002MenuFragment();
                menuFragment.setmCallBack(this);
                showFragment(R.id.container_view, menuFragment, false);
                break;
            case M002MenuFragment.KEY_SHOW_MAIN:
                M003MainFragment mainFragment = new M003MainFragment();
//                Story story = (Story) obj[0];
//                List<Story> listStory = (List<Story>) obj[1];
//                detailStoryFragment.setListStory(listStory);
//                detailStoryFragment.setStory(story);
                mainFragment.setmCallBack(this);
                showFragment(R.id.container_view, mainFragment, true);
                break;
            case M003MainFragment.KEY_SHOW_HIGH_SCORE:
                M004HighScoreFragment highScoreFragment = new M004HighScoreFragment();
                highScoreFragment.setmCallBack(this);
                highScoreFragment.setKqDapAn(bool);
                highScoreFragment.setViTri(viTri);
                highScoreFragment.setTxtHighScore(txt);
                highScoreFragment.setTxt(Object.toString());
                showFragment(R.id.container_view, highScoreFragment, false);
                break;
            case M004HighScoreFragment.KEY_BACK_MAIN:
                M003MainFragment backMainFragment = new M003MainFragment();
                backMainFragment.setmCallBack(this);
                backMainFragment.setViTri(viTri);
                backMainFragment.setTxtHighScore(txt);
                showFragment(R.id.container_view, backMainFragment, false);
                break;
        }
    }
}

