package com.ucai.property_animatorset;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {
    private ImageView mIvAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
       mIvAnim = (ImageView) findViewById(R.id.iv_animation);
    }

    public void onClick(View view){

        ObjectAnimator anim1= ObjectAnimator.ofFloat(mIvAnim,"rotationY",0,720);

        ObjectAnimator anim2= ObjectAnimator.ofFloat(mIvAnim,"translationX",
                0,getResources().getDisplayMetrics().widthPixels-mIvAnim.getWidth());
        ObjectAnimator anim3= ObjectAnimator.ofFloat(mIvAnim,"translationY",
                0,getResources().getDisplayMetrics().widthPixels-mIvAnim.getWidth());
        AnimatorSet animatorSet = new AnimatorSet();
        switch (view.getId()){
            case R.id.btn_sequencePlay:
//               animatorSet.playSequentially(anim1,anim2);
                //表示在before内的动画执行之前播放play内的动画
                animatorSet.play(anim1).after(anim3).before(anim2);

                //表示在after内的动画执行之后播放play内的动画
                //animatorSet.play(anim1).after(anim2);
                //不能重复设置某个动画对象
//                animatorSet.play(anim1).before(anim2).after(anim2);
                break;
            case R.id.btn_togetherPlay:
//                animatorSet.playTogether(anim1,anim2);

                animatorSet.play(anim1).with(anim3).with(anim2);
//                animatorSet.play(anim2).with(anim1);
                break;
        }
        // animatorSet.setDuration(2500);
//        animatorSet.setDuration(5000);
        animatorSet.setDuration(2500);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.start();

        //现在我创建了新的分支
        //我正在分支dev中工作
        //我修改好了代码。
        //要准备在mater主分支中合并代码了
        //fjlksadjf;jsad
        //dsfjasdfj
        //jsodfjsdfdsaofj
    }

}
