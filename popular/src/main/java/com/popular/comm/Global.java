package com.popular.comm;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 全局公共类, 封装：屏幕宽高获取，单位转换，主线程运行等
 * 
 * @author WJQ
 */
public class Global {

	public static Context mContext;
	/**
	 * 屏幕密度
	 */
	public static float mDensity;
	/**
	 * 屏幕宽度
	 */
	public static float mScreenWidth;
	/**
	 * 屏幕高度
	 */
	public static float mScreenHeight;

	public static void init(Context context) {
		mContext = context;
		initScreenSize();
	}

	private static void initScreenSize() {
		DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
		mDensity = dm.density;
		mScreenHeight = dm.heightPixels;
		mScreenWidth = dm.widthPixels;
	}

	/**
	 * 单位转换
	 */
	public static int dp2px(int dp) {
		return (int) (dp * mDensity + 0.5f);
	}

	/**
	 * 填充布局
	 */
	public static View inflate(int layoutResID, ViewGroup parent) {
		return LayoutInflater.from(mContext).inflate(layoutResID, parent, false);
	}

	/**
	 * 填充布局
	 */
	public static View inflate(int layoutResID) {
		return inflate(layoutResID, null);
	}

	private static Handler mHandler = new Handler(Looper.getMainLooper());

	public static Handler getMainHandler() {
		return mHandler;
	}

	/**
	 * 判断当前线程是否是主线程
	 *
	 * @return true表示当前是在主线程中运行
	 */
	public static boolean isMainThread() {
		return Looper.getMainLooper() == Looper.myLooper();
	}

	/**
	 * 在主线程运行
	 */
	public static void runOnMainThread(Runnable run) {
		if (isMainThread()) {
			run.run();
		} else {
			mHandler.post(run);
		}
	}

	private static Toast mToast;

	/**
	 * showToast，可以在子线程中调用
	 *
	 * @param msg toast内容
	 */
	public static void showToast(final String msg) {
		runOnMainThread(new Runnable() {
			@Override
			public void run() {
				if (mToast == null) {
					mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
				}
				mToast.setText(msg);
				mToast.show();
			}
		});
	}

	//=============沉侵式==(begin)=================

	private static View mStatusBarView;

	/**
	 * 设置全屏沉侵式效果
	 * 调用此方法后，界面内容可以延伸显示到状态栏上，状态栏会变成透明色
	 */
	public static void setNoStatusBarFullMode(Activity activity) {
		// sdk 4.4
		if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
			Window window = activity.getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

			if (mStatusBarView != null) {
				ViewGroup root = (ViewGroup) activity.findViewById(android.R.id.content);
				root.removeView(mStatusBarView);
			}
			return;
		}

		// sdk 5.x
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = activity.getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			window.setStatusBarColor(Color.TRANSPARENT);
			// TRANSLUCENT： 半透明
			// TRANSPARENT： 透明
			return;
		}
	}

	/**
	 * 设置控件的paddingTop, 使它不被StatusBar覆盖
	 */
	public static void setStatusBarPadding(View view) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			int marginTop = getStatusBarHeight(view.getContext());
			view.setPadding(view.getPaddingLeft(), marginTop,
					view.getPaddingRight(), view.getPaddingBottom());
			return;
		}
	}

	/**
	 * 获取状态栏高度，一般为24dp，有些可能较特殊，需要反射动态获取
	 */
	public static int getStatusBarHeight(Context context) {
		try {
			Class<?> clazz = Class.forName("com.android.internal.R$dimen");
			Object obj = clazz.newInstance();
			Field field = clazz.getField("status_bar_height");
			int id = Integer.parseInt(field.get(obj).toString());
			return context.getResources().getDimensionPixelSize(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-------无法获取到状态栏高度");
		}
		return dp2px(24);
	}

	public static void setStatusBarColor(Activity activity, int statusColor) {
		// sdk 4.4
		if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
			ViewGroup root = (ViewGroup) activity.findViewById(android.R.id.content);
			if (mStatusBarView == null) {
				mStatusBarView = new View(activity);
				mStatusBarView.setBackgroundColor(statusColor);
			} else {
				// 先解除父子控件关系，否则重复把一个控件多次
				// 添加到其它父控件中会出错
				ViewParent parent = mStatusBarView.getParent();
				if (parent != null) {
					ViewGroup viewGroup = (ViewGroup) parent;
					if (viewGroup != null) {
						viewGroup.removeView(mStatusBarView);
					}
				}
			}
			ViewGroup.LayoutParams param = new ViewGroup.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT,
					getStatusBarHeight(activity));
			root.addView(mStatusBarView, param);
			return;
		}

		// sdk 5.x
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			activity.getWindow().setStatusBarColor(statusColor);
			return;
		}
	}
	//=============沉侵式==(end)=================


	//================新增(begin)=======================

	/**
	 * 往下移动控件, 移动的距离为 状态栏高度
	 *
	 * @param view
	 */
	public static void moveViewDown(View view) {
		//sdk 4.4: KITKAT
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			// 状态栏高度
			int distance = Global.getStatusBarHeight(view.getContext());
			// 父控件
			ViewParent parent = view.getParent();
			if (parent instanceof LinearLayout) {
				// 通过marginTop属性让控件往下偏移一段距离
				// 相当于：android:layout_marginTop="24dp"
				((LinearLayout.LayoutParams) view.getLayoutParams()).topMargin = distance;
			} else if (parent instanceof RelativeLayout) {
				((RelativeLayout.LayoutParams) view.getLayoutParams()).topMargin = distance;
			} else if (parent instanceof FrameLayout) {
				((FrameLayout.LayoutParams) view.getLayoutParams()).topMargin = distance;
			}
			return;
		}
	}

	/**
	 * 往上移动Activity中所有的控件, 移动的距离为 系统导航栏的高度
	 */
	public static void moveViewUp(Activity activity) {
		// 没有虚拟按键，不需要设置paddingBottom
		if (!Global.checkDeviceHasNavigationBar(activity)) {
			return;
		}

		// 4.4.以上, 并且，有虚拟按键的情况下，才调用设置paddingBottom
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			ViewGroup root = (ViewGroup) activity.findViewById(android.R.id.content);
			root.setBackgroundColor(Color.BLACK);
			root.setPadding(root.getTop(),
					root.getLeft(),
					root.getRight(),
					// 虚拟按栏的高度
					Global.getNavigationBarHeight(activity));
			return;
		}
	}

	/**
	 * 获取系统导航栏的高度
	 */
	public static int getNavigationBarHeight(Context activity) {
		Resources resources = activity.getResources();
		int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
		// 获取NavigationBar的高度
		int height = resources.getDimensionPixelSize(resourceId);
		return height;
	}

	//================新增(end)=========================

	// 获取是否存在NavigationBar(虚拟按键)
	public static boolean checkDeviceHasNavigationBar(Context context) {
		boolean hasNavigationBar = false;
		Resources rs = context.getResources();
		int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
		if (id > 0) {
			hasNavigationBar = rs.getBoolean(id);
		}

		// 机型适配
		try {
			Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
			Method m = systemPropertiesClass.getMethod("get", String.class);
			String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
			if ("1".equals(navBarOverride)) {
				hasNavigationBar = false;
			} else if ("0".equals(navBarOverride)) {
				hasNavigationBar = true;
			}
		} catch (Exception e) {
		}
		return hasNavigationBar;
	}

	//设置颜色
	public static int getColor(int bgColor) {
		return ContextCompat.getColor(mContext,bgColor);
	}
}
