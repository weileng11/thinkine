package com.popular;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.*;
import com.andexert.library.RippleView;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.popular.comm.BaseActivity;
import com.popular.practice.PracticeAct;
import com.popular.practice.ui.DialogTestAct;
import com.popular.practice.ui.view.ObservableScrollView;
import java.lang.ref.WeakReference;
import butterknife.BindView;
import butterknife.OnClick;
import tyrantgit.explosionfield.ExplosionField;

public class MainAct extends BaseActivity
		implements ObservableScrollView.OnObservableScrollViewListener
{
	@BindView(R.id.btn_practice)
	Button mBtnPractice;
	@BindView(R.id.ll_main)
	RelativeLayout mllMain;
	@BindView(R.id.iv1)
	ImageView iv1;
	@BindView(R.id.iv2)
	ImageView iv2;
	@BindView(R.id.more)
	RippleView rippleView;
	@BindView(R.id.sv_main_content)
	ObservableScrollView mSvMainContent;
	@BindView(R.id.iv_header_left)
	ImageView mIvHeaderLeft;
	@BindView(R.id.tv_header_title)
	TextView mTvHeaderTitle;
	@BindView(R.id.iv_header_img)
	ImageView mIvHeaderImg;
	@BindView(R.id.ll_header_content)
	LinearLayout mLlHeaderContent;
	@BindView(R.id.img_banner)
	ImageView img_banner;
	private SkeletonScreen skeletonScreen;
	//https://github.com/tyrantgit/ExplosionField
	private ExplosionField explosionField;
	
	private int mHeight;
	
	@Override
	public int getLayoutRes(){
		return R.layout.act_main;
	}
	
	@Override
	public void initView(){
		explosionField=ExplosionField.attach2Window(this);
	}
	
	@Override
	public void initListener(){
		rippleView.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				Log.e("Sample", "Click Rect !");
			}
		});
		rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener()
		{
			@Override
			public void onComplete(RippleView rippleView){
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
		
		//获取标题栏高度
		ViewTreeObserver viewTreeObserver = img_banner.getViewTreeObserver();
		viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				img_banner.getViewTreeObserver().removeOnGlobalLayoutListener(this);
				mHeight = img_banner.getHeight() - mLlHeaderContent.getHeight();//这里取的高度应该为图片的高度-标题栏
				//注册滑动监听
				mSvMainContent.setOnObservableScrollViewListener(MainAct.this);
			}
		});
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
	
	/**
	 * 获取ObservableScrollView的滑动数据
	 *
	 * @param l
	 * @param t
	 * @param oldl
	 * @param oldt
	 */
	@Override
	public void onObservableScrollViewListener(int l, int t, int oldl, int oldt) {
		if (t <= 0) {
			//顶部图处于最顶部，标题栏透明
			mLlHeaderContent.setBackgroundColor(Color.argb(0, 48, 63, 159));
		} else if (t > 0 && t < mHeight) {
			//滑动过程中，渐变
			float scale = (float) t / mHeight;//算出滑动距离比例
			float alpha = (255 * scale);//得到透明度
			mLlHeaderContent.setBackgroundColor(Color.argb((int) alpha, 48, 63, 159));
		} else {
			//过顶部图区域，标题栏定色
			mLlHeaderContent.setBackgroundColor(Color.argb(255, 48, 63, 159));
		}
	}
	
	@Override
	public void onPointerCaptureChanged(boolean hasCapture){
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
		showActivity(this, PracticeAct.class);
	}
	
	public void dialogfm(View view){
		showActivity(this, DialogTestAct.class);
	}
}
