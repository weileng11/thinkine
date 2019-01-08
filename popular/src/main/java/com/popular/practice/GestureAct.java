package com.popular.practice;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.github.ihsg.patternlocker.OnPatternChangeListener;
import com.github.ihsg.patternlocker.PatternIndicatorView;
import com.github.ihsg.patternlocker.PatternLockerView;
import com.popular.R;
import com.popular.comm.BaseActivity;
import java.util.List;
import butterknife.BindView;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.popular.practice
 * @description:
 * @date: 2019/1/8  
 * @time: 16:31
 */
public class GestureAct extends BaseActivity
{
	private static final int CODE_HAVE_GESTURE = 0;
	private static final int CODE_NO_GESTURE = 1;
	
	@BindView(R.id.pattern_indicator_view)
	PatternIndicatorView mPatternIndicatorView;
	@BindView(R.id.tv_hint)
	TextView mTvHint;
	@BindView(R.id.pattern_lock_view)
	PatternLockerView mPatternLockView;
	@BindView(R.id.tv_lost_gesture)
	TextView mTvLostGesture;
	
	private int gesture;
	@Override
	public int getLayoutRes(){
		return R.layout.act_gesture;
	}
	
	@Override
	public void initView(){
	}
	
	@Override
	public void initListener(){
		mPatternLockView.setOnPatternChangedListener(mChangeListener);
	}
	
	@Override
	public void initData(){
		gesture=1;
	}
	
	private String checkPwd;
	private String firstPwd;
	private String secondPwd;
	
	OnPatternChangeListener mChangeListener = new OnPatternChangeListener() {
		@Override
		public void onStart(PatternLockerView patternLockerView) {
		}
		
		@Override
		public void onChange(PatternLockerView patternLockerView, List<Integer> list) {
			if (gesture != CODE_HAVE_GESTURE) {
				mPatternIndicatorView.updateState(list, false);
			}
			
		}
		
		@Override
		public void onComplete(PatternLockerView patternLockerView, List<Integer> list) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int i : list) {
				stringBuilder.append(i);
			}
			if (gesture == CODE_HAVE_GESTURE) {
				checkPwd = list.toString();
			} else {
				if (TextUtils.isEmpty(firstPwd)) {
					firstPwd = list.toString();
				} else {
					secondPwd = list.toString();
				}
			}
			
			
		}
		
		@Override
		public void onClear(PatternLockerView patternLockerView) {
			if (gesture == CODE_HAVE_GESTURE) {
				
				onCheckPwdEqualListener listener = new onCheckPwdEqualListener() {
					@Override
					public void onEqual(boolean isEqual) {
						if (isEqual) {
							mPatternIndicatorView.setVisibility(View.VISIBLE);
							mTvLostGesture.setVisibility(View.GONE);
							gesture = CODE_NO_GESTURE;
							mTvHint.setText("绘制手势密码");
						} else {
							mTvHint.setText("绘制手势error");
						}
					}
				};
			} else {
				mPatternIndicatorView.updateState(null, false);
				if (TextUtils.isEmpty(secondPwd)) {
					mTvHint.setText("绘制手势密码2222222");
					return;
				}
				
				if (firstPwd.equals(secondPwd)) {
					//添加密码
					mTvHint.setText("绘制手势密码成功了");
				} else {
					mTvHint.setText("绘制手势密码");
				}
			}
			
		}
	};
	
	interface onCheckPwdEqualListener {
		void onEqual(boolean isEqual);
	}
}
