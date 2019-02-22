package com.popular.comm;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.gyf.barlibrary.ImmersionBar;
import com.popular.R;
import com.popular.practice.annotation.BindEventBus;
import org.greenrobot.eventbus.EventBus;
import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 Activity基类，所有的Activity都需要继承此类。
 封装： 查看子控件，设置监听器，初始化数据，
 toast, showDialog, showProgressDialog等方法
 @author WJQ
 */
public abstract class BaseActivity extends SwipeBackActivity implements IUIOperation
{
	private SwipeBackLayout mSwipeBackLayout;
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		int layoutn=getLayoutRes();
		if(!(layoutn==-1 || layoutn==0)) setContentView(layoutn);
		ButterKnife.bind(this);
		
		// 可以调用该方法，设置是否允许滑动退出
		setSwipeBackEnable(true);
		mSwipeBackLayout = getSwipeBackLayout();
		// 设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL, EDGE_BOTTOM
		mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
		// 滑动退出的效果只能从边界滑动才有效果，如果要扩大touch的范围，可以调用这个方法
		//mSwipeBackLayout.setEdgeSize(200);
		
		
		//Global.setNoStatusBarFullMode(this);//沉浸式
		////常亮
		//getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		//full();
		ImmersionBar.with(this).statusBarColor(R.color.colorPrimary).init();
		
		initView();
		initListener();
		initData();
	}
	
	private void full() {
		//得到当前界面的装饰视图
		if(Build.VERSION.SDK_INT >= 21) {
			View decorView = getWindow().getDecorView();
			//让应用主题内容占用系统状态栏的空间,注意:下面两个参数必须一起使用 stable 牢固的
			int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
			decorView.setSystemUiVisibility(option);
			//设置状态栏颜色为透明
			getWindow().setStatusBarColor(Color.BLUE);
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		initEventBus();
	}
	
	@Override
	protected void onPause() {
		if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
			EventBus.getDefault().unregister(this);
		}
		super.onPause();
	}
	
	private void initEventBus() {
		if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
			EventBus.getDefault().register(this);
		}
	}
	
	/** 查找子控件，可以省略强转 */
	public <T> T findView(int id){
		T view=(T)findViewById(id);
		return view;
	}
	
	public void showToast(String text){
		Global.showToast(text);
	}
	
	
	protected void setPageTitle(String title){
		//		TextView tvTitle = findView(R.id.tv_title);
		//		if (tvTitle != null) {
		//			tvTitle.setText(title);
		//		}
	}
	
	/** 对话框点击回调 */
	public interface OnDialogClickListener
	{
		/** 确定 */
		void onConfirm();
		/** 取消 */
		void onCancel();
	}
	
	/**
	 返回键
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){
			finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	/**
	 跳转后，当前界面自销毁
	 */
	public void skipActivity(Activity aty, Class<?> cls){
		showActivity(aty, cls);
		aty.finish();
	}
	
	/**
	 跳转后，当前界面自销毁
	 */
	public void skipActivity(Activity aty, Intent it){
		showActivity(aty, it);
		aty.finish();
	}
	
	/**
	 跳转后，当前界面自销毁
	 */
	public void skipActivity(Activity aty, Class<?> cls, Bundle extras){
		showActivity(aty, cls, extras);
		aty.finish();
	}
	
	/**
	 Activity跳转
	 */
	public void showActivity(Activity aty, Class<?> cls){
		Intent intent=new Intent();
		intent.setClass(aty, cls);
		aty.startActivity(intent);
	}
	
	/**
	 Activity跳转 开启关闭动画
	 */
	public void showActivityColseTranslate(Activity aty, Class<?> cls){
		Intent intent=new Intent();
		intent.setClass(aty, cls);
		aty.startActivity(intent);
	}
	
	/**
	 new_task来处理页面关闭的问题singtask
	 */
	public void showNewTaskActivity(Activity aty, Class<?> cls){
		Intent intent=new Intent();
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setClass(aty, cls);
		aty.startActivity(intent);
	}
	
	/**
	 Activity跳转
	 */
	public void showActivity(Activity aty, Intent it){
		aty.startActivity(it);
	}
	
	/**
	 Activity跳转
	 */
	public void showActivity(Activity aty, Class<?> cls, Bundle extras){
		Intent intent=new Intent();
		intent.putExtras(extras);
		intent.setClass(aty, cls);
		aty.startActivity(intent);
	}
	
	/**
	 Activity跳转 开启底部动画
	 */
	public void showActivityOpenTranslate(Activity aty, Class<?> cls){
		Intent intent=new Intent();
		intent.setClass(aty, cls);
		aty.startActivity(intent);
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		// 必须调用该方法，防止内存泄漏
		ImmersionBar.with(this).destroy();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// 非必加
		// 如果你的app可以横竖屏切换，适配了4.4或者华为emui3.1系统手机，并且navigationBarWithKitkatEnable为true，
		// 请务必在onConfigurationChanged方法里添加如下代码（同时满足这三个条件才需要加上代码哦：1、横竖屏可以切换；2、android4.4或者华为emui3.1系统手机；3、navigationBarWithKitkatEnable为true）
		// 否则请忽略
		ImmersionBar.with(this).init();
	}
}



















