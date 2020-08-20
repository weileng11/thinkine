package wl.ui;

import android.os.Handler;
import android.text.format.Time;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import wl.base.BaseActivity;
import wl.thinkine.R;
import wl.util.DateUtils;

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
//		handler.postDelayed(runnable, 3000);

//		Date date=DateUtils.strToDateLong("1589531940375");
//		Date date=new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(1589537946739L);
//		cal.setTime(date);
//		cal.add(Calendar.DAY_OF_MONTH, -1);
//		date = cal.getTime();

		//当前年
		int year = cal.get(Calendar.YEAR);
		//当前月
		int month = (cal.get(Calendar.MONTH));
		//当前月的第几天：即当前日
		int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
		//当前时：HOUR_OF_DAY-24小时制；HOUR-12小时制
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		//当前分
		int minute = cal.get(Calendar.MINUTE);
		//当前秒
		int second = cal.get(Calendar.SECOND);
//		dd.getHours();
//		dd.getMinutes();
		Log.i("时间开始",year+"-w-"+month+"-x--"+minute+"===ccc="+hour+"====s=="+second); //2020 5 17 23
//		DateUtils.isCurrentInTimeScope(hour,minute)
		cal.add(Calendar.MINUTE, 1);

		//当前分
		int minute2 = cal.get(Calendar.MINUTE);
		//当前秒
		int second2 = cal.get(Calendar.SECOND);
		Log.i("时间增加后",year+"-w-"+month+"-x--"+hour+"====s=="+minute2+"===ccc="+second2); //2020 5 17 23

		 timejs=DateUtils.calendarToString(cal);

		 long currentTimeMillis=System.currentTimeMillis();
		Log.i("时间现在时间","==="+currentTimeMillis); //2020 5 17 23
		 timeks=DateUtils.convertToString(currentTimeMillis);
		Log.i("时间3","===当前时间"+timeks+"==="+"===增加后时间"+timejs); //2020 5 17 23

		timer = new Timer();
		timer.schedule(new MyTimerTask(), 1000,1000);// 1s后启动任务

	}
	String timejs,timeks;
	@Override
	protected void onDestroy(){
		//结束线程
		handler.removeCallbacks(runnable);
		super.onDestroy();
	}

	Timer timer;
	class MyTimerTask extends TimerTask {
		public void run() {
			long currentTimeMillis=System.currentTimeMillis();
			String time3=DateUtils.convertToString(currentTimeMillis);
			int i=DateUtils.timeCompare(time3,timejs);
			Log.i("时间4","值是否相等===="+i); //2020 5 17 23
			if(i==2){
				if(timer!=null){
					timer.cancel();
				}
			}

//			Log.i("时间目前系统时间===",time3); //2020 5 17 23
		}
	}

	public static boolean isCurrentInTimeScope(int deadlineHour, int deadlineMin) {
		boolean result;
		// 1000 * 60 * 60 * 24
		final long aDayInMillis = 86400000;
		final long currentTimeMillis = System.currentTimeMillis();
		//截止时间
		Time deadlineTime = new Time();
		deadlineTime.set(currentTimeMillis);
		deadlineTime.hour = deadlineHour;
		deadlineTime.minute = deadlineMin;
		//当前时间
		Time startTime = new Time();
		startTime.set(currentTimeMillis);
		//当前时间推后20分钟
		Date d = new Date(currentTimeMillis);
		long myTime = (d.getTime() / 1000) + 20 * 60;
		d.setTime(myTime * 1000);
		Time endTime = new Time();
		endTime.set(myTime);
		if (!startTime.before(endTime)) {
			// 跨天的特殊情况（比如22:00-8:00）
			startTime.set(startTime.toMillis(true) - aDayInMillis);
			result = !deadlineTime.before(startTime) && !deadlineTime.after(endTime);
			// startTime <= deadlineTime <=endTime
			Time startTimeInThisDay = new Time();
			startTimeInThisDay.set(startTime.toMillis(true) + aDayInMillis);
			if (!deadlineTime.before(startTimeInThisDay)) {
				result = true;
			}
		} else {
			// 普通情况(比如 8:00 - 14:00)
			result = !deadlineTime.before(startTime) && !deadlineTime.after(endTime);
			// startTime <= deadlineTime <=endTime
		}
		return result;
	}
}
