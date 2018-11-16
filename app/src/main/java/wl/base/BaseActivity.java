package wl.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import wl.api.RxActivity;
import wl.app.App;

/**
 Created by wuzhengu on 2018/10/29 0029 */
public abstract class BaseActivity extends RxActivity
{
	ActivityProxy mProxy;
	Unbinder mUnbinder;
	
	public ActivityProxy getProxy(){
		if(mProxy==null) mProxy=new ActivityProxy().set(this, null);
		return mProxy;
	}
	
	public BaseActivity getActivity(){ return this; }
	
	public Context getContext(){ return this; }
	
	@Override
	protected void onDestroy(){
		if(mProxy!=null) mProxy.dismissLoading();
		super.onDestroy();
		App.set(this, false);
	}
	
	@Override
	protected void onCreate(@Nullable Bundle bundle){
		App.set(this, true);
		super.onCreate(bundle);
		int layout=getLayout();
		if(!(layout==-1 || layout==0)) setContentView(getLayout());
			//setContentView(layout);
		initData();
	}
	
	public abstract int getLayout();
	//public abstract int initView();
	public abstract void initData();
	
	protected int getLayoutId(){
		return 0;
	}
	
	public View getView(){
		return findViewById(Window.ID_ANDROID_CONTENT);
	}
	
	@Override
	public void onActivityResult(int req, int res, Intent data){
		if(mProxy!=null && mProxy.onActivityResult(req, res, data)) return;
		super.onActivityResult(req, res, data);
	}
	
	@Override
	public void onRequestPermissionsResult(int req, @NonNull String[] ps, @NonNull int[] res){
		super.onRequestPermissionsResult(req, ps, res);
	}
	
	@Override
	public void setContentView(@LayoutRes int layout){
		setContentView(getLayoutInflater().inflate(layout, null));
	}
	
	@Override
	public void setContentView(View view){
		super.setContentView(view);
		bindView(view);
	}
	
	@Override
	public void setContentView(View view, ViewGroup.LayoutParams params){
		super.setContentView(view, params);
		bindView(view);
	}
	
	public void bindView(View view){
		if(mUnbinder!=null) mUnbinder.unbind();
		mUnbinder=ButterKnife.bind(this, view);
	}
	
	public void toast(CharSequence text){
		toast(getActivity(), text);
	}
	
	public static void toast(Context ctxt, CharSequence text){
		Toast.makeText(ctxt, text, Toast.LENGTH_SHORT).show();
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
	//	/**
	//	 * Activity跳转 开启底部动画
	//	 */
	//	public void showActivityOpenTranslate(Activity aty, Class<?> cls) {
	//		Intent intent = new Intent();
	//		intent.setClass(aty, cls);
	//		aty.startActivity(intent);
	//		aty.overridePendingTransition(R.anim.activity_open, R.anim.activity_stay);
	//	}
	
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
}
