package wl.ui;

import android.os.Handler;
import wl.base.BaseActivity;
import wl.thinkine.R;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: wl.ui
 * @description:
 * @date: 2018/11/12 0012  
 * @time: 下午 5:35
 */
public class ActLaunch extends BaseActivity
{
	Handler handler = new Handler();
	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			skipActivity(ActLaunch.this,ActLogin.class);
		}
	};
	@Override
	public int getLayout(){
		return R.layout.act_guide;
	}
	
	@Override
	public void initData(){
		handler.postDelayed(runnable, 3000);
	}
	
	@Override
	protected void onDestroy(){
		//结束线程
		handler.removeCallbacks(runnable);
		super.onDestroy();
	}
}
