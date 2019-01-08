package com.popular.comm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.WindowManager;
import butterknife.ButterKnife;

/**
 Activity基类，所有的Activity都需要继承此类。
 封装： 查看子控件，设置监听器，初始化数据，
 toast, showDialog, showProgressDialog等方法
 @author WJQ
 */
public abstract class BaseActivity extends AppCompatActivity implements IUIOperation
{
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		int layoutn=getLayoutRes();
		if(!(layoutn==-1 || layoutn==0)) setContentView(layoutn);
		ButterKnife.bind(this);
		Global.setNoStatusBarFullMode(this);//沉浸式
		//常亮
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		initView();
		initListener();
		initData();
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
	}
}



















