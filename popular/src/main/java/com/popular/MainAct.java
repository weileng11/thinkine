package com.popular;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.andexert.library.RippleView;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.popular.comm.BaseActivity;
import java.lang.ref.WeakReference;
import butterknife.BindView;
import butterknife.OnClick;
import tyrantgit.explosionfield.ExplosionField;

public class MainAct extends BaseActivity
{
	@BindView(R.id.btn_practice)
	Button mBtnPractice;
	@BindView(R.id.ll_main)
	LinearLayout mllMain;
	@BindView(R.id.iv1)
	ImageView iv1;
	@BindView(R.id.iv2)
	ImageView iv2;
	@BindView(R.id.more)
	RippleView rippleView;
	private SkeletonScreen skeletonScreen;
	//https://github.com/tyrantgit/ExplosionField
	private ExplosionField explosionField;
	
	
	@Override
	public int getLayoutRes(){
		return R.layout.act_main;
	}
	
	@Override
	public void initView(){
		explosionField = ExplosionField.attach2Window(this);
	}
	
	@Override
	public void initListener(){
		rippleView.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Log.e("Sample", "Click Rect !");
			}
		});
		rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
			@Override
			public void onComplete(RippleView rippleView) {
				Log.d("Sample", "Ripple completed");
			}
		});
	}
	
	@Override
	public void initData(){
		//骨架布局加入
		skeletonScreen=Skeleton.bind(mllMain)
				.load(R.layout.act_main_gj)
				.duration(1000)
				.color(R.color.shimmer_color)
				.angle(0)
				.show();
		MyHandler myHandler=new MyHandler(this);
		myHandler.sendEmptyMessageDelayed(1, 2000);
	}
	
	
	@OnClick({R.id.iv1, R.id.iv2})
	public void onClick(View view){
		switch(view.getId()){
		case R.id.iv1:
			explosionField.explode(iv1);
			iv1.setVisibility(View.INVISIBLE);
			break;
		case R.id.iv2:
			explosionField.explode(iv2);
			iv2.setVisibility(View.INVISIBLE);
			break;
		}
	}
	
	public static class MyHandler extends Handler
	{
		private final WeakReference<MainAct> activityWeakReference;
		
		MyHandler(MainAct activity){
			this.activityWeakReference=new WeakReference<>(activity);
		}
		
		@Override
		public void handleMessage(Message msg){
			super.handleMessage(msg);
			if(activityWeakReference.get()!=null){
				activityWeakReference.get().skeletonScreen.hide();
			}
		}
	}
	
	@OnClick(R.id.btn_practice)
	public void onClick(){
		//showActivity(this, PracticeAct.class);
	}
}
