package com.popular;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.popular.comm.Global;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.*;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.squareup.leakcanary.LeakCanary;
import java.util.ArrayList;

public class App extends Application
{
	public static Context context;
	private static App instance;
	
	public static App get(){
		return instance;
	}
	
	// 存储打开的activity，用于重新启动activity时候用
	public static ArrayList<Activity> activityList=new ArrayList<>();
	static{
		//设置全局的Header构建器
		SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator()
		{
			@Override
			public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout){
				//                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
				return new ClassicsHeader(
						context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
			}
		});
		//设置全局的Footer构建器
		SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator()
		{
			@Override
			public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout){
				//指定为经典Footer，默认是 BallPulseFooter
				return new ClassicsFooter(context).setDrawableSize(20);
			}
		});
	}
	@Override
	public void onCreate(){
		super.onCreate();
		//        AgoraManager.getInstance().init(getApplicationContext());
		Logger.addLogAdapter(new AndroidLogAdapter());
		initApplication(this);
		
		if (LeakCanary.isInAnalyzerProcess(this)) {
			// This process is dedicated to LeakCanary for heap analysis.
			// You should not init your app in this process.
			return;
		}
		LeakCanary.install(this);
	}
	
	//@Override
	//protected void attachBaseContext(Context base) {
	//	super.attachBaseContext(base);
	//	//允许文件超过36.....
	//	MultiDex.install(this);
	//}
	
	private void initApplication(App app){
		instance=app;
		context=this;
		if(instance==null){
			//L.E(TAG, "\n\n\n\n\n !!!!!! 调用BaseApplication中的init方法，instance不能为null !!!\n <<<<<< init  instance == null ！！！ >>>>>>>> \n\n\n\n");
		}
		// 项目一启动就初始化Contxt和屏幕尺寸等相参数
		Global.init(instance);
		//初始化OkGo
	}
	
	/*
  * 销毁全部界面
  */
	public static void finishAllActivity(){
		if(activityList!=null){
			for(Activity activity : activityList){
				//&& !(activity instanceof LoginActivity)
				if(!activity.isFinishing()){
					activity.finish();
				}
			}
			activityList.clear();
		}
	}
}
