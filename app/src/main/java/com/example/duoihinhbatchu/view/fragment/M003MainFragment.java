package com.example.duoihinhbatchu.view.fragment;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.duoihinhbatchu.App;
import com.example.duoihinhbatchu.OnActionCallBack;
import com.example.duoihinhbatchu.R;
import com.example.duoihinhbatchu.viewmodel.MainViewModel;

import java.util.Random;

public class M003MainFragment extends BaseFragment<MainViewModel>{
    public static final String KEY_SHOW_HIGH_SCORE = "KEY_SHOW_HIGH_SCORE";
    int viTri=0;
    private TextView tvScore;
    private LinearLayout lnResultOne,lnResultTwo,lnResultThree,lnResult,lnGuessOne,lnGuessTwo,lnGuessThree;
    int index=-1;
    boolean kqDapAn;
    private String txtHighScore="0";

    public String getTxtHighScore() {
        return txtHighScore;
    }

    public void setTxtHighScore(String txtHighScore) {
        this.txtHighScore = txtHighScore;
    }

    private StringBuilder kQGuess;
    private StringBuilder kQNew;

    public boolean isKqDapAn() {
        return kqDapAn;
    }

    private OnActionCallBack mCallBack;
    private ImageView ivGuess;
    public void setmCallBack(OnActionCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override
    protected void initViews() {
        tvScore=findViewById(R.id.tv_score);
        tvScore.setText(txtHighScore);
        lnResult = findViewById(R.id.ln_result);
        findViewById(R.id.bt_ok,this::onClick);
        ivGuess=findViewById(R.id.iv_guess);
        lnResultOne = findViewById(R.id.ln_result_one);

        lnResultTwo = findViewById(R.id.ln_result_two);

        lnResultThree = findViewById(R.id.ln_result_three);

        lnGuessOne=findViewById(R.id.ln_guess_one);
        lnGuessTwo=findViewById(R.id.ln_guess_two);
        lnGuessThree=findViewById(R.id.ln_guess_three);
         mModel.initData();
        for (int i=0;i<mModel.getListQuestion().get(viTri).getTitle().length();i++){
            View v = initResultView(null);
            if(i<7) {
                lnResultOne.addView(v);

            } else if(i>=7 && i<14){
                lnResultTwo.addView(v);
            }else if(i>=14){
                lnResultThree.addView(v);
            }
        }
        try {
            Glide.with(mContext).load(BitmapFactory.decodeStream(App.getInstance().getAssets().open(mModel.getListQuestion().get(viTri).getIdName()))).into(ivGuess);
        } catch (Exception e) {
            e.printStackTrace();
        }


          kQNew=new StringBuilder(mModel.getListQuestion().get(viTri).getTitle());
         for(int i=0;i<4;i++){
             Random rd=new Random();
             int x=rd.nextInt(4)+1;
             char y=mModel.getListQuestion().get(viTri).getTitle().charAt(x);
             kQNew.insert(x,y);
         }

         kQGuess=new StringBuilder("");
        for (int i=0;i<mModel.getListQuestion().get(viTri).getTitle().length()+4;i++){
            View v = initGuessView(kQNew.charAt(i)+"");
            String z=kQNew.charAt(i)+"";

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kQGuess.append(z);
                   // Toast.makeText(mContext,kQGuess.toString(),Toast.LENGTH_SHORT).show();
                    index++;
                    if(index>=0 && index<7){
                        lnResultOne.removeViewAt(index);
                        View view=initResultView(z);
                        lnResultOne.addView(view,index);
                     //   Toast.makeText(mContext,index+"",Toast.LENGTH_SHORT).show();
                    }if(index>=7 && index<14){
                        lnResultTwo.removeViewAt(index-7);
                        View view=initResultView(z);
                        lnResultTwo.addView(view,index-7);
                    } if(index>=14){
                        lnResultThree.removeViewAt(index-14);
                        View view=initResultView(z);
                        lnResultThree.addView(view,index-14);
                    }
                   // Toast.makeText(mContext,z,Toast.LENGTH_SHORT).show();
                }
            });
            if(i<7) {
                lnGuessOne.addView(v);
            } else if(i>=7 && i<14){
                lnGuessTwo.addView(v);
            }else if(i>=14){
                lnGuessThree.addView(v);
            }
        }

    }

    private View initGuessView(String text) {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.item_predict, null, false);

        TextView tvGuess = view.findViewById(R.id.tv_guess);
        tvGuess.setText(text);
        return view;
    }

    private View initResultView(String txt) {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.item_result, null, false);

        TextView tvResult = view.findViewById(R.id.tv_result);
        if(txt!=null){
            tvResult.setText(txt);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_ok){
            if(kQGuess.toString().equals(mModel.getListQuestion().get(viTri).getTitle())){
                kqDapAn=true;

            }else {
                kqDapAn=false;

            }
            mCallBack.onCallBack(KEY_SHOW_HIGH_SCORE,kQGuess,kqDapAn,viTri,txtHighScore);
        }
    }

    public void setViTri(int viTri) {
        this.viTri = viTri;
    }

    @Override
    protected Class<MainViewModel> getClassViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m003_main_act;
    }


}
