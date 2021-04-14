package com.example.duoihinhbatchu.view.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.duoihinhbatchu.OnActionCallBack;
import com.example.duoihinhbatchu.R;
import com.example.duoihinhbatchu.viewmodel.HighScoreViewModel;

public class M004HighScoreFragment extends BaseFragment<HighScoreViewModel>{
    public static final String KEY_BACK_MAIN = "KEY_BACK_MAIN";
    private OnActionCallBack mCallBack;
    boolean kqDapAn;
    private TextView tvResult,tvCongratulation;
    LinearLayout lnHighScoreOne,lnHighScoreTwo,lnHighScoreThree;
    int viTri=0;
    String txtHighScore="";

    public String getTxtHighScore() {
        return txtHighScore;
    }

    public void setTxtHighScore(String txtHighScore) {
        this.txtHighScore = txtHighScore;
    }

    String txt="";

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setKqDapAn(boolean kqDapAn) {
        this.kqDapAn = kqDapAn;
    }

    public void setViTri(int viTri) {
        this.viTri = viTri;
    }

    public void setmCallBack(OnActionCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override
    protected void initViews() {
        tvResult=findViewById(R.id.tv_result);
        tvCongratulation=findViewById(R.id.tv_congratulation);
        if(kqDapAn){
            tvResult.setText("Bạn đã tìm ra đáp án");
            int score=Integer.parseInt(txtHighScore)+4;
            txtHighScore=score+"";
        }else{
            tvResult.setText("Bạn đã tìm sai đáp án");
            tvCongratulation.setText("THẤT BẠI!");
            int score=Integer.parseInt(txtHighScore)-4;
            txtHighScore=score+"";
        }
         findViewById(R.id.bt_continue,this);
        lnHighScoreOne = findViewById(R.id.ln_high_score_one);

        lnHighScoreTwo = findViewById(R.id.ln_high_score_two);

        lnHighScoreThree = findViewById(R.id.ln_high_score_three);
       // Toast.makeText(mContext,txt,Toast.LENGTH_SHORT).show();

        for (int i=0;i<txt.length();i++){
            View v = initHighScoreView(txt.charAt(i)+"");
            if(i<7) {
                lnHighScoreOne.addView(v);
            } else if(i>=7 && i<14){
                lnHighScoreTwo.addView(v);
            }else if(i>=14){
                lnHighScoreThree.addView(v);
            }
        }

    }

    private View initHighScoreView(String text) {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.item_high_score, null, false);

        TextView tvGuess = view.findViewById(R.id.tv_high_score);
        tvGuess.setText(text);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_continue){
            viTri++;
            if(viTri>49){
                viTri=0;
            }
            mCallBack.onCallBack(KEY_BACK_MAIN,null,kqDapAn,viTri,txtHighScore);
        }
    }

    @Override
    protected Class<HighScoreViewModel> getClassViewModel() {
        return HighScoreViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m004_highscore;
    }
}
