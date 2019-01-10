package com.popular;

import android.os.Message;
import android.widget.Button;
import android.widget.LinearLayout;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.popular.comm.BaseActivity;
import com.popular.practice.PracticeAct;
import java.lang.ref.WeakReference;
import butterknife.BindView;
import butterknife.OnClick;

public class MainAct extends BaseActivity
{
	@BindView(R.id.btn_practice)
	Button mBtnPractice;
	@BindView(R.id.ll_main)
	LinearLayout mllMain;
	
	private SkeletonScreen skeletonScreen;
	
	@Override
	public int getLayoutRes(){
		return R.layout.act_main;
	}
	
	@Override
	public void initView(){
	}
	
	@Override
	public void initListener(){
	}
	
	@Override
	public void initData(){
		//骨架布局加入
		skeletonScreen = Skeleton.bind(mllMain)
				.load(R.layout.act_main_gj)
				.duration(1000)
				.color(R.color.shimmer_color)
				.angle(0)
				.show();
		MyHandler myHandler = new MyHandler(this);
		myHandler.sendEmptyMessageDelayed(1, 2000);
	}
	
	public static class MyHandler extends android.os.Handler {
		private final WeakReference<MainAct> activityWeakReference;
		
		MyHandler(MainAct activity) {
			this.activityWeakReference = new WeakReference<>(activity);
		}
		
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (activityWeakReference.get() != null) {
				activityWeakReference.get().skeletonScreen.hide();
			}
		}
	}
	
	@OnClick(R.id.btn_practice)
	public void onClick(){
		showActivity(this, PracticeAct.class);
	}
}
